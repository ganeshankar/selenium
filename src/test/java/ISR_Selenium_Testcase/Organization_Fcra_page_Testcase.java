package ISR_Selenium_Testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Com_ISR_Base.com_isr_base;
import Com_ISR_Pages.Homepage;
import Com_ISR_Pages.Login_Page;
import Com_ISR_Pages.Organization_Fcra_page;

public class Organization_Fcra_page_Testcase extends com_isr_base{
    Organization_Fcra_page ofcra;
	Login_Page loginpage;
	
	Homepage homepage;
	public Organization_Fcra_page_Testcase() {
		super();
	}
	
	@BeforeTest
	public void setup() throws InterruptedException {
		initialization();
		loginpage = new Login_Page();
		loginpage.userfacebooklogin(prop.getProperty("user_email_id"), prop.getProperty("user_password"));
		homepage = new Homepage();
		homepage.selectorgnew();
		ofcra = new Organization_Fcra_page();
		ofcra.navigate_to_fcrapage();
	}
	
	@Test(priority =1)
	public void upload_fcra() throws InterruptedException, IOException {
		ofcra.fcra_registration(prop.getProperty("org_fcra_enterdate"));
		
      String actualresult= ofcra.fcra_status();
	Assert.assertEquals(actualresult, "Approval Pending");
	}
		

	@Test(priority =2)
	public void download_fcra() {
		ofcra.downloadfcra();
	}
	
	@Test(priority = 3)
	public void status_of_fcra() {
		ofcra.Status_fcra();

	}
	
}
