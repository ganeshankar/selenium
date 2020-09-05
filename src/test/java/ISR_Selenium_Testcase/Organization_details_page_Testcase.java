package ISR_Selenium_Testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Com_ISR_Base.com_isr_base;
import Com_ISR_Pages.Homepage;
import Com_ISR_Pages.Login_Page;
import Com_ISR_Pages.Organization_details_page;

public class Organization_details_page_Testcase extends com_isr_base{

public static String downloadPath = "C:\\Users\\Ganesh\\Downloads";
        
	Organization_details_page orgdetail;
	Homepage homepage;
	Login_Page loginpage;
	
	public Organization_details_page_Testcase() {
		super();
	}
	  
	
	@BeforeTest
	public void setup() throws InterruptedException {
		initialization();
	    loginpage = new Login_Page();
		loginpage.userfacebooklogin(prop.getProperty("user_email_id"),prop.getProperty("user_password"));
		homepage = new Homepage();
		homepage.selectorgnew();
		orgdetail  = new Organization_details_page();
	}
	
	@Test(priority =1)
	public void orgdetailspage() {
		orgdetail.orgdetailpage(prop.getProperty("org_detail_area"),prop.getProperty("org_detail_country_HQ"),prop.getProperty("org_detail_state"),prop.getProperty("org_detail_country_of_operation"), prop.getProperty("org_detail_pref_currency"),prop.getProperty("org_detail_pref_language"),prop.getProperty("org_detail_pref_timezone"),prop.getProperty("org_detail_description"));
		
	}
	
	@Test(priority =2)
	public void verifyuploadbutton() throws IOException {
		boolean actualresult =orgdetail.uploadbuttonverify();
		Assert.assertEquals(actualresult, false);
		System.out.println("upload button is disabled");
		
	}
	
	@Test(priority=3)
	public void uploadcertificiate() throws IOException {
	
		orgdetail.uploaddoc1(prop.getProperty("org_detail_upload_doc1"), prop.getProperty("String org_detail_upload_doc2"));
	}
	
	@Test(priority =4)
	public void downloadcertificate() {
		orgdetail.downloaddoc();
		
	}	
	
}
