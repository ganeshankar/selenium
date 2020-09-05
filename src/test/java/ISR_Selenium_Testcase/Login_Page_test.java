package ISR_Selenium_Testcase;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Com_ISR_Base.com_isr_base;
import Com_ISR_Pages.Login_Page;

public class Login_Page_test extends com_isr_base {
	Login_Page LoginPage;
	public Login_Page_test() {
		super();
	}
	
	
	@BeforeTest
	public void setup() {
		initialization();
		LoginPage  = new Login_Page();
	}
	
	@Test(priority =1)
	public void loginpagetitletest() {
	String actualresult =	LoginPage.Loginpagetitle();
	Assert.assertEquals(actualresult, "ABH");
	}
	
	@Test(priority =2)
	public void logintest() throws InterruptedException {
	LoginPage.userfacebooklogin(prop.getProperty("user_email_id"), prop.getProperty("user_password"));
	
	}
	
}
