package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {
	
	protected WebDriver driver;
	protected static Logger logger;// = LoggerUtils.getInfoLogger(); //OR you can keep the logger as static reference
	// so that it works when extended by listeners otherwise it is treated as null in listeners
	
	protected static ExtentReports exRepo;
	protected static ExtentTest test;
	protected FileInputStream fis;
	protected Properties config;
	protected static String browser;
	protected static String url;
	protected String configFile = System.getProperty("user.dir")+"\\config\\common\\automation.properties";
	
	@BeforeSuite
	public void setUpBeforeSuite(){
		
		logger = LoggerUtils.getInfoLogger();
		logger.info("@BeforeSuite");
		
		exRepo = ExtentManager.getInstance();
		
		config = new Properties();
		
		try {
			fis = new FileInputStream(configFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			config.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		browser = config.getProperty("browser");
		url = config.getProperty("url");
		
		logger.info("Browser is ---> "+browser+". And Url is ---> "+url);
		
		
	}
	
	@BeforeClass
	public void setupBeforeClass(){
		
		System.out.println("Before Class");
		logger.info("Before Class");	
		
	}
	
	@BeforeTest
	public void setupBeforeTest(){
		
		logger.info("@BeforeTest");
		
		
	}
	
	@BeforeMethod
	@Parameters({"browser"})
	public void setupBeforeMethod(String b){
		
		//logger.debug("OPENING BROWSER...--->> "+b);
		logger.info("OPENING BROWSER... >> "+ browser);
		driver = DriverFactory.openBrowser(browser);
		
	}
	
	@AfterMethod
	public void tearDownAfterMethod(){
		
		if(driver != null){
			logger.info("CLOSING BROWSER... >> "+browser);
			driver.close();
		}
		DriverFactory.setDriverInstanceToNull();
				
	}
	
	@AfterTest
	public void tearDownAfterTest(){
		
		logger.info("@AfterTest");
		
		
	}
	
	@AfterSuite
	public void tearDownAfterSuite(){
		
		logger.info("@AfterSuite");
		
	}
	
	@AfterClass
	public void tearDownAfterClass(){
		
		System.out.println("After Class");
		logger.info("After Class");
		
	}

}
