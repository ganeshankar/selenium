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
		loginpage.Login(prop.getProperty("user_email_id"), prop.getProperty("user_password"));
		homepage = new Homepage();
		homepage.selectorgnew();
		ofcra = new Organization_Fcra_page();
	}
	
	@Test(priority =1)
	public void upload_fcra() throws InterruptedException, IOException {
		ofcra.fcra_registration(prop.getProperty("org_fcra_enterdate"));
		
      String actualresult= ofcra.pendingstate();
	Assert.assertEquals(actualresult, "fcra_expected_message_on_fcra_page_pending");
	}
		

	@Test(priority =2)
	public void download_fcra() {
		ofcra.downloadfcra();
	}
	
	@Test(priority =3)
	public void pending_fcra() {
		ofcra.pendingstate();
		String actualresult= ofcra.pendingstate();
		Assert.assertEquals(actualresult, "fcra_expected_message_on_fcra_page_pending");
	}
	
	@Test(priority =4)
	public void verified_fcra() {
		ofcra.verifiedfcra();
		String actualresult= ofcra.verifiedfcra();
		Assert.assertEquals(actualresult, "fcra_expected_message_on_fcra_page_pending");
	}	
}
