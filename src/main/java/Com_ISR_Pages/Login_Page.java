package Com_ISR_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com_ISR_Base.com_isr_base;

public class Login_Page extends com_isr_base {
 
	@FindBy(xpath = "//span[text()='Sign in/Sign up']")
	WebElement signup_signin;
	
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
	
	public String errormessage() {
		return error_message.getText();
	}
}
