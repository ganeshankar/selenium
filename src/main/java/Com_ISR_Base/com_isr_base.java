package Com_ISR_Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Com_ISR_Util.com_isr_util;

public class com_isr_base {

	public static WebDriver driver;
	public static Properties prop;
	static public String parentwindow;
	
	public com_isr_base() {
		try {
		prop =new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\Ganesh\\eclipse-workspace\\ISR_Selenium\\src\\main\\java\\Com_ISR_Config\\config.properties");
		prop.load(ip);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization() {
		String browsername= prop.getProperty("browser");
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ganesh\\eclipse-workspace\\ISR_Selenium\\chromenew\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browsername.equals("FF"))	{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Ganesh\\eclipse-workspace\\ISR_Selenium\\chrome\\chromedriver.exe");
			driver = new FirefoxDriver();
			
				}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(com_isr_util.Implicit_wait, TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("url"));
	}

	public void windowhandel() {
		   Set<String> se = driver.getWindowHandles();
		   Iterator<String> it =se.iterator();
		   parentwindow = it.next();
		   String childwindow = it.next();
		   driver.switchTo().window(childwindow);	
	}
	
	}
