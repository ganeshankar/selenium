package ISR_Selenium_Testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Com_ISR_Base.com_isr_base;
import Com_ISR_Pages.Homepage;
import Com_ISR_Pages.Login_Page;
import Com_ISR_Pages.Organization_setting_page;

public class Organization_setting_page_Testcase  extends com_isr_base{
	Organization_setting_page orgsetting;
	Login_Page loginpage;
	Homepage homepage;
	
	public Organization_setting_page_Testcase() {
		super();
	}
	
	@BeforeTest
	public void setup() throws InterruptedException {
		initialization();
		loginpage = new Login_Page();
		loginpage.userfacebooklogin(prop.getProperty("user_email_id"), prop.getProperty("user_password"));
		homepage = new Homepage();
		homepage.selectorgnew();
		orgsetting = new Organization_setting_page();
		orgsetting.navigatetosetting();
	}
	
	@Test()
	public void beneficiaryfamilyangel() {
		orgsetting.become_familyangel_setting(prop.getProperty("org_setting1"));
	}
	
	
	}
	


