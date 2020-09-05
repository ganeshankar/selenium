package ISR_Selenium_Testcase;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Com_ISR_Base.com_isr_base;
import Com_ISR_Pages.Homepage;
import Com_ISR_Pages.Login_Page;
import Com_ISR_Pages.Social_media;

public class Social_media_test extends com_isr_base{

	static Social_media se;
	static Homepage homepage;
	 Login_Page login;
	
	 public  Social_media_test(){
			super();
		    }
			

			@BeforeTest
			public void setup() {
				initialization();
				
			se = new Social_media();
			homepage = new Homepage();
			login = new Login_Page();
			}

			@Test (priority =1)
			public void beneficiaryfacebookshare() throws InterruptedException {
				driver.get(prop.getProperty("beneficiary_url"));
				Thread.sleep(10000);
				se.facebookshare(prop.getProperty("facebook_email_id"), prop.getProperty("user_password"), prop.getProperty("facebook_description"));	
								
			}
			
			@Test (priority =2)
			public void beneficiarylinkedinshare() throws InterruptedException {
				Thread.sleep(5000);
				se.linkedinshare(prop.getProperty("user_email_id"), prop.getProperty("user_password"), prop.getProperty("linkedin_description"));	
								
			}
			
			@Test (priority =3)
			public void beneficiarytwittershare() throws InterruptedException {
				Thread.sleep(5000);
				se.twittershare(prop.getProperty("user_email_id"), prop.getProperty("user_password"));	
								
			}
		
			@Test (priority =4)
			public void angelfacebbokshare() throws InterruptedException {
				driver.get(prop.getProperty("angel_url"));
				Thread.sleep(10000);
				se.facebooklinkclick(prop.getProperty("facebook_description"));
			}
			
			@Test (priority =5)
			public void angellinkedinshare() throws InterruptedException {
				Social_media se = new Social_media();
				Thread.sleep(5000);
				se.linkedinlinkclick(prop.getProperty("linkedin_description"));
			}
			
			@Test (priority =6)
			public void angeltwittershare() throws InterruptedException {
				Social_media se = new Social_media();
				Thread.sleep(5000);
				se.twitterlinkclick();
			}
					
			@Test(priority =7)
			public void facilitatorfacebookshare() throws InterruptedException {
				driver.get(prop.getProperty("facilitator_url"));
				Thread.sleep(10000);
				se.facebooklinkclick(prop.getProperty("facebook_description"));
			}
			
			@Test(priority =8)
			public void facilitatorlinkedinshare() throws InterruptedException {
				Thread.sleep(5000);
				se.linkedinlinkclick(prop.getProperty("linkedin_description"));
			}
			
			@Test(priority =9)
			public void facilitatortwittershare() throws InterruptedException {
				Thread.sleep(5000);
				se.twitterlinkclick();
			}		
			
			@Test(priority =10)
			public void educationfacebookshare() throws InterruptedException {
				driver.get(prop.getProperty("education_url"));
				Thread.sleep(10000);
				se.facebooklinkclick(prop.getProperty("facebook_description"));
			}
				
			@Test(priority =11)
			public void educationlinkedinshare() throws InterruptedException {
				Thread.sleep(5000);
				se.linkedinlinkclick(prop.getProperty("linkedin_description"));
			}
			
			@Test(priority =12)
			public void educationtwittershare() throws InterruptedException {
				Thread.sleep(5000);
				se.twitterlinkclick();
			}		
			
			@AfterTest()
			public void closebrowser() {
					driver.quit();
				}
		}
