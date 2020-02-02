package ISR_Selenium_Testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Com_ISR_Base.com_isr_base;
import Com_ISR_Pages.Homepage;
import Com_ISR_Pages.Login_Page;
import Com_ISR_Pages.Organization_uploadvideo_page;

public class Organization_uploadvideo_page_testcase extends com_isr_base{
      Homepage homepage;
      Login_Page loginpage;
      Organization_uploadvideo_page orgvideo;
      
      public Organization_uploadvideo_page_testcase() {
      super();
      }
	
	@BeforeTest
	public void setup() throws InterruptedException {
		initialization();
		loginpage = new Login_Page();
		loginpage.Login(prop.getProperty("user_email_id"), prop.getProperty("user_password"));
		homepage = new Homepage();
		homepage.selectorgnew();
		orgvideo = new Organization_uploadvideo_page();
		orgvideo.navigate_to_video_page();
	}
	
	@Test()
	public void organization_video() {
		orgvideo.upload_video(prop.getProperty("org_youtube_link"), prop.getProperty("org_youtube_title"), prop.getProperty("org_youtube_description"));
		
	}
	
}
