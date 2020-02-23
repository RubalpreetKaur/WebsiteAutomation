import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hslf.model.Sheet;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;


public class Functions {
	String userDir=System.getProperty("user.dir");
	WebDriver driver=null;
	public String getLocator(String WebElement) {
		String xpath="";
		WebElement=WebElement.replace(".", ";");
		String element[]=WebElement.split(";");
		String Page=element[0];
		String Element=element[1];
		try {
		String FileName=userDir+"/Test/Plan/OR/uimap.xls";
		File file=new File(FileName);
		FileInputStream input=new FileInputStream(file);
		HSSFWorkbook hssf=new HSSFWorkbook(input);
		HSSFSheet sheetName=hssf.getSheet("locator");
		for(int i=1;i<=sheetName.getLastRowNum();i++) {
			String c0=sheetName.getRow(i).getCell(0).getStringCellValue();
			String c1=sheetName.getRow(i).getCell(1).getStringCellValue();
			xpath =sheetName.getRow(i).getCell(2).getStringCellValue();
			if(Page.equals(c0) && Element.equals(c1)) {
				return xpath;
			}
		}}catch(Exception e) {
			
		}
		return xpath;
	}
	
	public void launchBrowser(String Browser,String URL) {
		if(Browser.equalsIgnoreCase("CHROME")) {
			System.setProperty("webdriver.chrome.driver", userDir+"/Browsers/chromedriver.exe");
			driver= new ChromeDriver();
		}else if(Browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", userDir+"/Browsers/IEServerDriver.exe");
			driver= new InternetExplorerDriver();
		}else if(Browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.gecko.driver", userDir+"/Browsers/FirefoxDriver.exe");
			driver= new FirefoxDriver();
		}
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.NANOSECONDS);
	}
	
	public void click(String WebElement) {
		try {
			WebElement ele = getControl(WebElement);
			ele.click();
		} catch (Exception e) {
			System.out.println("element not clicked");
		}

	}
	public void VerifyText(String WebElement,String ExpectedText) {
		WebElement ele=getControl(WebElement);
		String ActualText=ele.getText().trim();
		if(ActualText.equals(ExpectedText.trim()))
			System.out.println("Passed..... Actual Text is matched to Expected");
		else
			System.out.println("Failed..... Actual Text is not matched to Expected");
	}
	public void close() {
		driver.close();
	}
	public WebElement getControl(String WebElemnt) {
		WebElement obj = null;
		String xpath=getLocator(WebElemnt);
		try {
			obj = driver.findElement(By.xpath(xpath));

		} catch (Exception e) {
			System.out.println("element with xpath: " + xpath + " not found");
		}
		return obj;
	}
	
	public void setValue(String WebElement, String Value) {
		WebElement ele = getControl(WebElement);
		String Type=ele.getAttribute("type");
		try {
		if(Type.equals("text"))
		{
			ele.sendKeys(Value);
		}
		
		if(Type.equals("select"))
		{
			Select sl = new Select(ele);
			sl.selectByVisibleText(Value);
		}
					
		
	} catch (Exception e) {
		System.out.println("element not selected");
	}
	
	}
}
