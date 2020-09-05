package Com_ISR_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com_ISR_Base.com_isr_base;

public class Homepage extends com_isr_base{
	
	
	@FindBy(xpath="//*[@id=\"target\"]/div[2]/div/span[2]/div/div[1]")
	WebElement myprofile;
	
	@FindBy(xpath ="//span[text()='Edit Organization']")
	public WebElement selectorg_from_myprofile;
	
	@FindBy(xpath = "//div[@id='root']/header/child::div[2]/child::a/img")
	public WebElement ABH_logo;
	
	public Homepage() {
		PageFactory.initElements(driver, this);
	}
			
	
	  public Organization_details_page selectorgnew() throws InterruptedException { 
		  Thread.sleep(10000);
		  myprofile.click(); 
		  Actions at = new Actions(driver);
	  at.click(selectorg_from_myprofile).build().perform(); return new
	  Organization_details_page(); }
	 
	public void abh_logo() {
		ABH_logo.click();
	}

}
