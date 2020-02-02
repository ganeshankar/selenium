package Com_ISR_Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com_ISR_Base.com_isr_base;

public class Organization_uploadvideo_page extends com_isr_base {

	@FindBy(xpath="//div[@class='my-profile-menu']/div/child::div/ul/child::a[2]/li/div/span")
	WebElement video_page;
	
	@FindBy(xpath="//input[@name='youtubeUrl']")
	WebElement youtube_link;
	
	@FindBy(xpath="//input[@name='videoTitle']")
	WebElement youtube_title;
	
	@FindBy(xpath = "//input[@name='videoDescription']")
	WebElement youtube_description;
	
	@FindBy(xpath="//label[text()='Video description']")
	WebElement scrollpage;
	
	@FindBy(xpath = "//div[@class='submit-button']/button")
	WebElement save_youtube;
	
	
	public Organization_uploadvideo_page(){
		PageFactory.initElements(driver, this);
	}
	
	public void navigate_to_video_page() {
		video_page.click();
	}
	
	public void upload_video(String youtubelink, String youtubetitle, String youtubedescription) {
		youtube_link.sendKeys(Keys.CONTROL + "a");
		youtube_link.sendKeys(Keys.DELETE);
		youtube_link.sendKeys(youtubelink);
		youtube_title.sendKeys(Keys.CONTROL + "a");
		youtube_title.sendKeys(Keys.DELETE);
		youtube_title.sendKeys(youtubetitle);
		youtube_description.sendKeys(Keys.CONTROL + "a");
		youtube_description.sendKeys(Keys.DELETE);
		youtube_description.sendKeys(youtubedescription);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", scrollpage);
		save_youtube.click();
	}
	
}
