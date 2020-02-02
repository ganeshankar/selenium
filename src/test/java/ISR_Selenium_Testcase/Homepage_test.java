package ISR_Selenium_Testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Com_ISR_Base.com_isr_base;
import Com_ISR_Pages.Homepage;
import Com_ISR_Pages.Login_Page;

public class Homepage_test extends com_isr_base{
			Login_Page loginpage;
			Homepage homepage;
			public Homepage_test() {
				super();
			}
			
			@BeforeTest
			public void setup() throws InterruptedException {
				initialization();
				loginpage = new Login_Page();
				homepage = new Homepage();
				loginpage.Login(prop.getProperty("user_email_id"), prop.getProperty("user_password"));
				
			}
	
	@Test()
	public void selectorg1() throws InterruptedException {
		homepage.selectorgnew();
	}
	

}
