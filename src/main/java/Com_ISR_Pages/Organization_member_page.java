package Com_ISR_Pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Com_ISR_Base.com_isr_base;

public class Organization_member_page extends com_isr_base{
	
	
	@FindBy(xpath= "//div[@class= 'my-profile-menu']/div/child::div/ul/child::a[6]/li/div/span")
	WebElement member_of_org;
	
	@FindBy(xpath="//div[@class='btn__addNewMember']/button")
	WebElement click_on_add_member_button;
	
	@FindBy(xpath="//div[@class='partner-add-member-modal-form']/form/div/div/div/input")
	WebElement member_name;

	@FindBy(xpath="//div[@class='partner-add-member-modal-form']/form/child::div[2]/div/div/div/div/div/select")
	WebElement member_expert;
	
	@FindBy(xpath="//div[@class='partner-add-member-modal-form']/form/child::div[3]/div/div/input")
	WebElement member_emailid;
	
	@FindBy(xpath="//div[@class='partner-add-member-modal-form']/form/child::div[4]/button")
	WebElement save_member_button;
	
	@FindBy(xpath="//div[@class='error']")
	WebElement error_message;
	
	@FindBy(xpath="//div[@class='partner-add-member-modal-container']/div/child::div[2]/button")
	WebElement cross_button_popup_member;
	
	@FindBy(xpath="//div[@class='member-container']/div/div/table/child::tbody/tr/child::td[4]/span")
	WebElement edit_link_member;
	
	@FindBy(xpath="//a[@class='download-sample-bulkupload']")
	WebElement download_sample_member;
	
	@FindBy(xpath="//div[@class= 'dropzone-wrapper']/div/div/button")
	WebElement upload_member;
	
	public Organization_member_page() {
		PageFactory.initElements(driver, this);
	}
	
	public void navigatetomember() {
	member_of_org.click();
	}
	
	public void addmember(String name, String expert, String emailid) {
		click_on_add_member_button.click();
		member_name.sendKeys(name);
		Select se1 =new Select(member_expert);
		se1.selectByValue(expert);
		member_emailid.sendKeys(emailid);
		save_member_button.click();
	}
		
	public void editmember(String name,String expert) {
		edit_link_member.click();
		member_name.sendKeys(Keys.CONTROL + "a");
		member_name.sendKeys(Keys.DELETE);
		member_name.sendKeys(name);
		
		Select se1 =new Select(member_expert);
		se1.selectByValue(expert);
		
		save_member_button.click();	
		}
		
		public boolean editemailid() {
	    return edit_link_member.isEnabled();
	}
		
		public void closememberpopup() {
			cross_button_popup_member.click();
		}
		
		public String errormessage() {
			return error_message.getText();	
		}
	
	public void downloadsample() {
		download_sample_member.click();
	}
	
	public void uploadmember() throws IOException, InterruptedException {
		upload_member.click();
		Thread.sleep(5000);
		Runtime.getRuntime().exec("C:\\Users\\Ganesh\\eclipse-workspace\\ISR_Selenium\\data\\upload member.exe");
	}

	
}
