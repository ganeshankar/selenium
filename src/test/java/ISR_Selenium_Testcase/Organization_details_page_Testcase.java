package ISR_Selenium_Testcase;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com_ISR_Base.com_isr_base;
import Com_ISR_Pages.Homepage;
import Com_ISR_Pages.Login_Page;
import Com_ISR_Pages.Organization_details_page;

public class Organization_details_page_Testcase extends com_isr_base{

private static String downloadPath = "C:\\Users\\navyug\\Downloads";
	
	private File getLatestFilefromDir(String dirPath){
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        return null;
	    }

	    File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	           lastModifiedFile = files[i];
	       }
	    }
	    return lastModifiedFile;
	}
	
        
	Organization_details_page orgdetail;
	Homepage homepage;
	Login_Page loginpage;
	
	public Organization_details_page_Testcase() {
		super();
	}
	
	
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
	    loginpage = new Login_Page();
		loginpage.Login(prop.getProperty("user_email_id"),prop.getProperty("user_password"));
		homepage = new Homepage();
		homepage.selectorgnew();
		orgdetail  = new Organization_details_page();
	}
	
	@Test(priority =1)
	public void orgdetailspage() {
		orgdetail.orgdetailpage(prop.getProperty("org_detail_area"),prop.getProperty("org_detail_country_HQ"),prop.getProperty("org_detail_state"),prop.getProperty("org_detail_country_of_operation"), prop.getProperty("org_detail_pref_currency"),prop.getProperty("org_detail_pref_language"),prop.getProperty("org_detail_pref_timezone"),prop.getProperty("org_detail_description"));
		
	}
	@Test(priority =2)
	public void downloadcertificate() {
		orgdetail.downloaddoc();
		
		File getLatestFile = getLatestFilefromDir(downloadPath);
		String fileName = getLatestFile.getName();
		 Assert.assertTrue(fileName.equals("angel_(1).pdf"), "Downloaded file name is not matching with expected file name");
	 }
		
	
	@Test(priority =3)
	public void uploadcertificate() throws IOException {
		orgdetail.uploaddoc(prop.getProperty("org_detail_upload_doc1"), prop.getProperty("String org_detail_upload_doc2"));
	}

	@AfterMethod
	public void close() {
		driver.quit();
	}

}
