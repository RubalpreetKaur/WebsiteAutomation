
public class WebsiteAutomation{
	static Functions uiDriver=new Functions();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello");
	
	/*	int a = 12;
		int b = -10;
		boolean c = true;
		boolean d = false;
		System.out.println(~a);// -11 (minus of total positive value which starts from 0)
		System.out.println(~b);// 9 (positive of total minus, positive starts from 0)
		System.out.println(!c);// false (opposite of boolean value)
		System.out.println(!d);// true
		int p=10;  
		int q=5;  
		int min=(p<q)?p:q;  
		System.out.println(min);
		
		try{
			//click
		}catch(Exception e) {
			//error
		}finally {
			//retry click
		}
	
*/
		//============Strings=================
		/*
		 * String Rubal="Princess"; char ch=Rubal.charAt(0); //retrurn type character
		 * start from 0 System.out.println(ch); int le=Rubal.length();
		 * System.out.println(le); double rubal=100.545565232162;
		 * System.out.println(String.format("%.2f", rubal)); String rub="fuckOFf";
		 * System.out.println(rub.substring(3)); System.out.println(rub.substring(1,4));
		 */
		

		uiDriver.launchBrowser("CHROME","https://www.seleniumeasy.com/test/");
		uiDriver.click("Home.InputForm");
		uiDriver.click("Home.SimpleFormDemo");
		uiDriver.setValue("Home.userMessage","I am Rubal");
		uiDriver.click("Home.ButtonShowMessage");
		uiDriver.close();
	}
}
