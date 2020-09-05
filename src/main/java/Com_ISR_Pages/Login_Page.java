package Com_ISR_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com_ISR_Base.com_isr_base;

public class Login_Page extends com_isr_base {
 
	@FindBy(xpath = "//span[text()='Sign in/Sign up']")
	WebElement signup_signin;
	
	@FindBy(xpath ="//span[@class='login-with']/following-sibling::button[1]")
	WebElement signin_facebook;
	
	@FindBy(xpath ="//input[@id='email']")
	WebElement facebook_email_field;
	
	@FindBy(xpath= "//input[@id='pass']")
	WebElement facebook_password_field;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement facebook_login_button;
	
	@FindBy(xpath ="//input[@name='email']")
	WebElement user_email_field;
	
	@FindBy(xpath= "//input[@name='password']")
	WebElement user_password_field;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[1]/div/div[3]/form/div[4]/button")
	WebElement login_button;
	
	@FindBy(xpath ="//*[@id=\"root\"]/div[5]/div/button/span[1]/span")
	WebElement cokies;
	
	@FindBy(xpath= "//div[@class='login-error']")
	WebElement error_message;
	
	@FindBy(xpath = "//input[@name = 'session[username_or_email]']")
	WebElement login_twitter_email;
	
	@FindBy(xpath = "//input[@type = 'password']")
	WebElement login_twitter_password;
	
	@FindBy(xpath = "//div[@role='button'][2]/div/span/span/span[text() = 'Log in']")
	WebElement login_twitter_submit_button;
	
	@FindBy(xpath="//input[@id = 'username']")
	WebElement login_linkedin_email;
	
	@FindBy(xpath ="//input[@id = 'password']")
	WebElement login_linkedin_password;
	
	@FindBy(xpath= "//button[@type='submit']")
	WebElement login_linkedin_submit_button;
	
	@FindBy(xpath = "//input[@id ='email']")
	WebElement login_facebook_email;
	
	@FindBy(xpath ="//input[@id ='pass']")
	WebElement login_facebook_password;
	
	@FindBy(xpath = "//input[@type ='submit']")
	WebElement login_facebook_submit_button;
	
	public Login_Page() {
		PageFactory.initElements(driver, this);
	}
	
	public String Loginpagetitle() {
		return driver.getTitle();
	}
	
	public Homepage Login(String user_email_id, String user_password) throws InterruptedException{
	cokies.click();
	signup_signin.click();
	user_email_field.sendKeys(user_email_id);
	user_password_field.sendKeys(user_password);
	Thread.sleep(10000);
	login_button.click();
	Thread.sleep(5000);
	return new Homepage();
	}
	
	public void userfacebooklogin(String user_email_id, String user_password) throws InterruptedException {
		cokies.click();
		signup_signin.click();
		Thread.sleep(5000);
		signin_facebook.click();
		windowhandel();
		facebook_email_field.sendKeys(user_email_id);
		facebook_password_field.sendKeys(user_password);
		facebook_login_button.click();
		Thread.sleep(5000);
		driver.switchTo().window(parentwindow);
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
    
    public void facebooklogin1(String facebook_email_id, String user_password) throws InterruptedException {
   	 login_facebook_email.sendKeys(facebook_email_id);
   	 login_facebook_password.sendKeys(user_password);
   	 login_facebook_submit_button.click();
   	 Thread.sleep(5000);	
    }
	
	public String errormessage() {
		return error_message.getText();
	}
}
