package ISR_Selenium_Testcase;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Com_ISR_Base.com_isr_base;
import Com_ISR_Pages.Homepage;
import Com_ISR_Pages.Login_Page;
import Com_ISR_Pages.Organization_member_page;

public class Organization_member_page_Testcase extends com_isr_base {
	
	Organization_member_page orgmember;
    Login_Page loginpage;
	Homepage homepage;
	
	public Organization_member_page_Testcase() {
		super();
	}
	
	
	@BeforeTest
	public void setup() throws InterruptedException {
		initialization();
		loginpage = new Login_Page();
		loginpage.userfacebooklogin(prop.getProperty("user_email_id"), prop.getProperty("user_password"));
		homepage = new Homepage();
		homepage.selectorgnew();
		orgmember = new Organization_member_page();
		orgmember.navigatetomember();
	}
	
	@Test(priority =1)
	public void addmember() {
		orgmember.addmember(prop.getProperty("org_member_name"), prop.getProperty("org_member_expert"), prop.getProperty("org_member_emailid"));
	    
	}
	
	@Test(priority =2)
	public void edit_member_name_expert() {
		orgmember.editmember(prop.getProperty("org_edit_name"), prop.getProperty("org_edit_expert"));
	}
	
	@Test(priority =3)
	public void add_same_email() {
		orgmember.addmember(prop.getProperty("org_member_name"), prop.getProperty("org_member_expert"), prop.getProperty("org_member_emailid"));
	
		String actualresult = orgmember.errormessage();
		Assert.assertEquals(actualresult, "User already assigned to this or other organization.");
		orgmember.closememberpopup();
	}
	
	@Test(priority =4)
	public void edit_email() {
		boolean actualresult = orgmember.editemailid();
	    Assert.assertTrue(actualresult);
	}
	
	@Test(priority =5)
	public void download_sample_member() {
	orgmember.downloadsample();
}

	@Test(priority =6)
	public void upload_member() throws IOException, InterruptedException {
	orgmember.uploadmember();
}

}