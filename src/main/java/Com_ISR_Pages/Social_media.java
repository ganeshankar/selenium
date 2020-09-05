package Com_ISR_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com_ISR_Base.com_isr_base;

public class Social_media extends com_isr_base {

	@FindBy(xpath = "//input[@name = 'session[username_or_email]']")
	WebElement login_twitter_email;
	
	@FindBy(xpath = "//input[@type = 'password']")
	WebElement login_twitter_password;
	
	@FindBy(xpath = "//div[@role='button'][2]/div/span/span/span[text() = 'Log in']")
	WebElement login_twitter_submit_button;
	
	@FindBy(xpath = "//span[text()='Tweet']")
	WebElement twitter_post_button;
	
	@FindBy(xpath="//input[@id = 'username']")
	WebElement login_linkedin_email;
	
	@FindBy(xpath ="//input[@id = 'password']")
	WebElement login_linkedin_password;
	
	@FindBy(xpath= "//button[@type='submit']")
	WebElement login_linkedin_submit_button;
	
	@FindBy(xpath= "//li[@data-control-name='select_share_post']/button/child::span")
	WebElement linkedin_share_button;
	
	@FindBy(xpath = "//div[starts-with(@aria-placeholder,'What do you want to talk about')]")
	WebElement linkedin_desc;
	
	@FindBy(xpath = "//span[text()='Post']")
	WebElement linkedin_post_button;
	
	@FindBy(xpath = "//input[@id ='email']")
	WebElement login_facebook_email;
	
	@FindBy(xpath ="//input[@id ='pass']")
	WebElement login_facebook_password;
	
	@FindBy(xpath = "//input[@type ='submit']")
	WebElement login_facebook_submit_button;
	
	@FindBy(xpath = "//textarea[starts-with(@aria-label,'Say something about this')]")
	WebElement facebook_desc;
	
	@FindBy(xpath= "//span[contains(text(),'Post to Facebook')]")
	WebElement facebook_post_button;
	
	@FindBy(xpath ="//div[@class='facebook']")
	WebElement facebook_link;
	
	@FindBy(xpath ="//div[@class='linkedin']")
	WebElement linkedin_link;
	
	@FindBy(xpath ="//div[@class='twitter']")
	WebElement twitter_link;
	
	
	
	
     public Social_media() {
		PageFactory.initElements(driver, this);
	}

     public void twitterlogin(String user_email_id, String user_password) throws InterruptedException {
    	login_twitter_email.sendKeys(user_email_id); 
    	login_twitter_password.sendKeys(user_password);
    	Thread.sleep(5000);
    	login_twitter_submit_button.click();
    	Thread.sleep(5000);	
     }

     public void linkedinlogin(String user_email_id, String user_password) throws InterruptedException {
    	 login_linkedin_email.sendKeys(user_email_id);
    	 login_linkedin_password.sendKeys(user_password);
    	 login_linkedin_submit_button.click();
    	 Thread.sleep(5000);	
     }
     
     public void facebooklogin(String facebook_email_id, String user_password) throws InterruptedException {
    	 login_facebook_email.sendKeys(facebook_email_id);
    	 login_facebook_password.sendKeys(user_password);
    	 login_facebook_submit_button.click();
    	 Thread.sleep(5000);	
     }

	    
	    public void twitter() throws InterruptedException {  
	    	driver.manage().window().maximize();
	    	twitter_post_button.click();
		  
	}

		public void linkedin(String linkedin_description) throws InterruptedException {
			driver.manage().window().maximize();
			linkedin_share_button.click();
			Thread.sleep(3000);
			linkedin_desc.sendKeys(linkedin_description);
			linkedin_post_button.click();
			driver.close();
		}
		
		public void facebook(String facebook_description) throws InterruptedException{
			driver.manage().window().maximize();
			facebook_desc.sendKeys(facebook_description);
			facebook_post_button.click();
			driver.close();
		
		}
			
		public void facebookshare(String facebook_email_id, String user_password, String facebook_description ) throws InterruptedException {
			facebook_link.click();
			windowhandel();
			driver.manage().window().maximize();
			facebooklogin( facebook_email_id, user_password);
			facebook(facebook_description);
			driver.switchTo().window(parentwindow);
		}
		
			public void linkedinshare(String user_email_id, String user_password, String linkedin_description ) throws InterruptedException {		
			linkedin_link.click();
			windowhandel();
			driver.manage().window().maximize();
			linkedinlogin(user_email_id, user_password);
			linkedin(linkedin_description);
			driver.switchTo().window(parentwindow);
		}
			
			public void twittershare(String user_email_id, String user_password ) throws InterruptedException {
			twitter_link.click();
			windowhandel();
			driver.manage().window().maximize();
			Thread.sleep(5000);
			twitterlogin(user_email_id, user_password);
			twitter();
			Thread.sleep(3000);
			driver.close();
			driver.switchTo().window(parentwindow);
		}
			
			public void facebooklinkclick(String facebook_description) throws InterruptedException {
				facebook_link.click();
				windowhandel();
				driver.manage().window().maximize();
				facebook(facebook_description);
				driver.switchTo().window(parentwindow);
			}
			
			public void linkedinlinkclick(String linkedin_description) throws InterruptedException {
				linkedin_link.click();
				windowhandel();
				driver.manage().window().maximize();
				linkedin(linkedin_description);
				driver.switchTo().window(parentwindow);
			}
			
			public void twitterlinkclick() throws InterruptedException {
				twitter_link.click();
				windowhandel();
				driver.manage().window().maximize();
				twitter();
				driver.close();
				driver.switchTo().window(parentwindow);
			}
			
}
