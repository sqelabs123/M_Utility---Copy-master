package Re_usable;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterClass;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Browsers.BrowserList;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Sauce_Instance_Login_Test  {
    
public  WebDriver driver;
    
	public static DesiredCapabilities capability;
	
    
	public Repo_Test action_obj;
	public Assertion_Test Assertion_obj;
	//public String Url="https://test.waterworkslms.com/waterworks";
	
	@BeforeClass
	@Parameters({"userId","password","url"})
	public void Login( String userId,String password,String url) throws IOException  {
		/*WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();*/
		//action_obj = new Repo_Test(driver);
		
		//String id="TueMar29112646IST2016vermaname@sqelabs.com";
		//String password="C12345678@c";s
		//String Url=td.get_string_CellData("URL", 1, 1);
		
		
		
	//####################
		/*capability = DesiredCapabilities.firefox();
		capability.setCapability("platform", "Windows 10");
		capability.setCapability("version", "40");
		capability.setCapability("name", "Test1");*/
		//############################

		//driver = new  RemoteWebDriver(new URL(url),capability);//natasha hide 12/03

		String downloadFilepath = "D:";
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFilepath);
		ChromeOptions options = new ChromeOptions();
	//	options.setExperimentalOption("prefs", chromePrefs);
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		WebDriver driver = new ChromeDriver(cap);                  
			
//		String exePath = "E:\\chromedriver.exe";
		

	 	String exePath =  System.getProperty("user.dir") + "\\TestData\\chromedriver1.exe";  //chrome driver address		
	 	System.setProperty("webdriver.chrome.driver", exePath);
	 	
		 /* String exePath = System.getProperty("user.dir") + "D:\\A_Projects\\M_Utility\\TestData\\chromedriver1.exe";
		
		System.setProperty("webdriver.chrome.driver", exePath);*/
		
		driver = new ChromeDriver(cap);
		//driver = new FirefoxDriver();
		action_obj = new Repo_Test(driver);
		Assertion_obj = new Assertion_Test(driver);

		System.out.println("---------------------------------------------------------------------------------------------------------------");
		//Open URL
		System.out.println("@URL Opening......."+url);
		driver.get(url);
		driver.manage().window().maximize();		
		action_obj.useranme().sendKeys(userId);
		action_obj.Password().sendKeys(password);
		action_obj.loginbutton().click();
		
		/*//add new functionalily 
		Select NewGroup=new Select(action_obj.Select_newGroup());
		NewGroup.selectByIndex(2);
		action_obj.Select_newGroup().click();*/
	}
	@AfterClass
	public void logout() throws InterruptedException, MalformedURLException {
	List<WebElement> lout=(List<WebElement>) driver.findElements(By.xpath(".//*[@title='User'] "));
		if(lout.size()==1)
		{
	    System.out.println("---------------------------------------------------------------------------------------------------------------");
		System.out.println("@#############################################################");
		JavascriptExecutor executor=(JavascriptExecutor) driver;
		executor.executeScript("scrollBy(0,-2000)", "");		
		  action_obj.user_icon_logout().click();
		  action_obj.logout().click();
		  driver.quit();
		  
		 
		} 
	}
	
}
