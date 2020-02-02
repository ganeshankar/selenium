package Com_ISR_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Com_ISR_Base.com_isr_base;

public class Organization_setting_page extends com_isr_base{
	
	@FindBy(xpath = "//div[@class='my-profile-menu']/div/child::div/ul/child::a[8]/li/div/span")
	WebElement setting_page_of_org;
	
	@FindBy(xpath = "//div[@class='settings-fields']/child::div[2]/div/div/div/div/div/select")
	WebElement select_value_familyangel;
	
	@FindBy(xpath = "//div[@class='submit-button']/button")
	WebElement save_button;
	
	public Organization_setting_page() {
		PageFactory.initElements(driver, this);
	}
	
	public void navigatetosetting() {
		setting_page_of_org.click();
	}
	
	public void become_familyangel_setting(String familyangel)
	{
		
		Select se1 = new Select(select_value_familyangel);
		se1.selectByValue(familyangel);
		save_button.click();
		
	}
	

}
