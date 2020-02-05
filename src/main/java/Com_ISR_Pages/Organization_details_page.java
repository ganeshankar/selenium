package Com_ISR_Pages;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Com_ISR_Base.com_isr_base;

public class Organization_details_page extends com_isr_base{

	@FindBy(xpath = "//div[@class='edit-partner-details']/descendant::div[10]/select")
	WebElement area_of_activity;
	
	@FindBy(xpath = "//div[@class='edit-partner-details']/descendant::div[13]/input")
	WebElement office_address;
	
	@FindBy(xpath = "//div[@class='edit-partner-details']/descendant::div[21]/select")
	WebElement country_hq;

	@FindBy(xpath = "//div[@class='edit-partner-details']/descendant::div[27]/select")
	WebElement state;
	
	@FindBy(xpath = "//div[@class='edit-partner-details']/descendant::div[33]/select")
	WebElement country_of_operation;
	
	@FindBy(xpath = "//div[@class='edit-partner-details']/descendant::div[39]/select")
	WebElement  preferred_currency;
	
	@FindBy(xpath = "//div[@class='edit-partner-details']/descendant::div[45]/select")
	WebElement preferred_language;
	
	@FindBy(xpath = "//div[@class='edit-partner-details']/descendant::div[51]/select")
	WebElement  preferred_timezone;
	
	@FindBy(xpath = "//div[@class='edit-partner-details']/descendant::div[55]/textarea[3]")
	WebElement org_description;
	
	@FindBy(xpath = "//div[@class='edit-partner-details']/descendant::div[64]/button")
	WebElement upload_doc1;
	
	@FindBy(xpath = "//div[@class='edit-partner-details']/descendant::div[74]/button")
	WebElement upload_doc2;
	
	@FindBy(xpath = "//div[@class='edit-partner-details']/descendant::div[78]/child::span/a/button")
	WebElement download_doc1;
	
	@FindBy(xpath = "//div[@class='edit-partner-details']/descendant::div[80]/child::span/a/button")
	WebElement download_doc2;
	
	@FindBy(xpath = "//div[@class='edit-partner-details']/descendant::div[82]/button")
	WebElement save_org_details;
	
	@FindBy(xpath= "//span[text()='Organization Profile']")
	WebElement scroll1;
	
	@FindBy(xpath= "//span[text()='Organization Club']")
	WebElement scroll2;
	
	public Organization_details_page() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void orgdetailpage(String area, String countryhq, String orgstate, String countryofoperation, String prefcurrency, String preflanguage, String preftimezone,  String orgdesc) {
		Select se1 =new Select(area_of_activity);
		se1.selectByValue("1");
		
		office_address.sendKeys(Keys.CONTROL + "a");
		office_address.sendKeys(Keys.DELETE);
		office_address.sendKeys(area);
		
		Select se2 =new Select(country_hq);
		se2.selectByValue(countryhq);
		
		Select se4 = new Select(state);
        se4.selectByValue(orgstate);
		
        Select se5 = new Select(country_of_operation);
        se5.selectByVisibleText(countryofoperation);
        
        scroll1.click();
		
        Select se6 =new Select(preferred_currency);
        se6.selectByValue(prefcurrency);
        
        Select se7 =new Select(preferred_language);
        se7.selectByValue(preflanguage);
        
        Select se8 = new Select(preferred_timezone);
        se8.selectByVisibleText(preftimezone);
        
        org_description.sendKeys(Keys.CONTROL + "a");
        org_description.sendKeys(Keys.DELETE);
        org_description.sendKeys(orgdesc);
        
        scroll1.click();
		scroll2.click();
        
        save_org_details.click();
	}
	
	public void uploaddoc(String uploaddoc1, String uploaddoc2) throws IOException {
		scroll1.click();
		scroll2.click();
		if (upload_doc1.isEnabled()) {
		upload_doc1.click();
		Runtime.getRuntime().exec(uploaddoc1);
   
		upload_doc2.click();
		Runtime.getRuntime().exec(uploaddoc1);
		
		save_org_details.click();
	} else {
		System.out.println("button is enabled:" + upload_doc1.isEnabled() );
		System.out.println("button is enabled:" + upload_doc2.isEnabled() );
	}
	}

    public void downloaddoc() {
    	
    	scroll1.click();
		scroll2.click();
    	download_doc1.click();
    	download_doc2.click();
    }


}
