package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.pages.CrmHomePage;
import com.crm.qa.pages.DressCartPage;
import com.crm.qa.pages.DressPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.WebEventListener;
//useless comment
public class TestBase {
	static protected WebDriver driver;
	static public Properties prop;
	protected LoginPage loginPage;
	protected CrmHomePage crmHomePage;
	protected DressPage dressHomePage;
	protected DressCartPage dressCartPage;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static WebDriverWait wait;
	
	public TestBase(){
		prop= new Properties();
		try {
		File f=new File("./");
		System.out.println(f.getAbsolutePath());
		FileInputStream ip = new FileInputStream("./src/main/java/com/crm/qa/config/Application.properties");
		prop.load(ip);
		
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void initialization(){
		String browsername=prop.getProperty("browser");
		//String urlname=prop.getProperty("url");
		if(browsername.equalsIgnoreCase("CHROME")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver");
//		    DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//
//		    
//		    capabilities.setCapability("acceptInsecureCerts",true);

		    
		  //  WebDriver driver = new FirefoxDriver(capabilities);
			//ChromeOptions options = new ChromeOptions();
//			options.addArguments("start-maximized"); // open Browser in maximized mode
//			options.addArguments("disable-infobars"); // disabling infobars
//			options.addArguments("--disable-extensions"); // disabling extensions
//			options.addArguments("--disable-gpu"); // applicable to windows os only
//			options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
//			options.addArguments("--no-sandbox"); // Bypass OS security model
//			WebDriver driver = new ChromeDriver(options);
			driver = new ChromeDriver(); 
			e_driver = new EventFiringWebDriver(driver);
			// Now create object of EventListerHandler to register it with EventFiringWebDriver
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
			driver = e_driver;
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();	
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		String timeOut=prop.getProperty("waitTimeOut");
		wait=new WebDriverWait(driver,Integer.parseInt(timeOut));
		
				
	}
	
	public void initializePOM(){
		loginPage= new LoginPage();
		crmHomePage= new CrmHomePage();
		dressHomePage= new DressPage();
		dressCartPage= new DressCartPage();
	}
	}

