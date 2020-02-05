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

public static String downloadPath = "C:\\Users\\Ganesh\\Downloads";
        
	Organization_details_page orgdetail;
	Homepage homepage;
	Login_Page loginpage;
	
	public Organization_details_page_Testcase() {
		super();
	}
	
	private boolean isFileDownloaded_Ext(String dirPath, String ext){
		boolean flag=false;
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        flag = false;
	    }
	    
	    for (int i = 1; i < files.length; i++) {
	    	if(files[i].getName().contains(ext)) {
	    		flag=true;
	    	}
	    }
	    return flag;
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
		
		Assert.assertTrue(isFileDownloaded_Ext(downloadPath, ".pdf"), "Failed to download Expected document");
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
