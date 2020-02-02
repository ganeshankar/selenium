package ISR_Selenium_Testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com_ISR_Base.com_isr_base;
import Com_ISR_Pages.Homepage;
import Com_ISR_Pages.Login_Page;

public class Login_Page_test extends com_isr_base {
	Login_Page LoginPage;
	Homepage homepage;
	public Login_Page_test() {
		super();
	}
	
	
	@BeforeMethod
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
	LoginPage.Login(prop.getProperty("user_email_id"), prop.getProperty("user_password"));
	
	}

	
	  @Test(priority = 3) 
	      public void invalidloginemail() throws InterruptedException {
		  LoginPage.Login(prop.getProperty("wrong_user_eamil_id"),prop.getProperty("user_password")); 
		  Thread.sleep(10000);
		  String actualresult= LoginPage.errormessage();
		  Assert.assertEquals(actualresult, "Invalid credentials. Please try again.");
	  }
	  
	  @Test(priority = 4) 
	      public void invalidloginpassword() throws InterruptedException {
		  LoginPage.Login(prop.getProperty("user_email_id"),prop.getProperty("wrong_user_password"));
		  Thread.sleep(10000);
		  String actualresult= LoginPage.errormessage();
		  Assert.assertEquals(actualresult, "Invalid credentials. Please try again.");
	  }
	 
	
	@AfterMethod
	public void close() {
		driver.quit();
	}
	
}
