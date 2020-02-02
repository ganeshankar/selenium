package Com_ISR_Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com_ISR_Base.com_isr_base;

public class Organization_Fcra_page extends com_isr_base {
	
	@FindBy(xpath = "//span[text()='FCRA Registration']")
	WebElement link_from_menubar_under_organization_pofile;
	
	@FindBy(xpath = "//div[@class='id-verification__button']/child::button")
	WebElement upload_button;
	
	@FindBy(xpath = "//div[@class='upload-file-modal-form']/form/div/div/div/div/div/button")
	WebElement upload_button_on_popup_page;
	
	@FindBy(xpath = "//div[@class='upload-file-modal-form-caption']/child::div[1]/div/input")
	WebElement date_field_on_popup_page;
	
	@FindBy(xpath = "//div[@class='button-wrapper']/button")
	WebElement submit_button_on_popup_page;
	
	@FindBy(xpath = "//span[text()='Approval Pending']")
	WebElement message_fcra_pending;
	
	@FindBy(xpath = "//span[text() ='Verified']")
	WebElement message_fcra_approve;
	
	@FindBy(xpath = "//div[@class='single-document']/child::span/a/button")
	WebElement fcra_download;
	
	public Organization_Fcra_page() {
		PageFactory.initElements(driver, this);
	}

	public void fcra_registration(String org_fcra_enterdate) throws InterruptedException, IOException {
		link_from_menubar_under_organization_pofile.click();
		upload_button.click();
		upload_button_on_popup_page.click();
		Thread.sleep(5000);
		Runtime.getRuntime().exec("C:\\Users\\Ganesh\\eclipse-workspace\\ISR_Selenium\\data\\FCRA.exe");
		date_field_on_popup_page.sendKeys(org_fcra_enterdate);
		submit_button_on_popup_page.click();
		
	}
	
	public void downloadfcra() {
		fcra_download.click();
	}

	public String pendingstate() {
		return message_fcra_pending.getText();
	}
	
	public String verifiedfcra() {
		return message_fcra_approve.getText();
	}
}

