package ISR_Selenium_Testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Com_ISR_Base.com_isr_base;
import Com_ISR_Pages.Homepage;
import Com_ISR_Pages.Login_Page;

public class Homepage_test extends com_isr_base{
		
			Homepage homepage;
			public Homepage_test() {
				super();
			}
			
			@BeforeTest
			public void setup() throws InterruptedException {
				initialization();
				homepage = new Homepage();
				
			}
	
	@Test()
	public void selectorg1() throws InterruptedException {
		homepage.selectorgnew();
	}
	

}
