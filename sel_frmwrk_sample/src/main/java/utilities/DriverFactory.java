package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	private static DriverFactory driverFactoryInstance;
	private static WebDriver driverInstance;
	
	private DriverFactory(){
		
		System.out.println("Driver Factory Instantiated...");
		
	}
	
	public DriverFactory getInstance(){
		
		if(driverFactoryInstance == null){
			synchronized(DriverFactory.class){
				
				if(driverFactoryInstance == null){
					driverFactoryInstance = new DriverFactory();
				}
				
			}
		}
		return driverFactoryInstance;
	}
	
	public static WebDriver openBrowser(String bType){
		
		if(driverInstance == null){
			
			synchronized(DriverFactory.class){
				
				if(driverInstance == null){
					
					if(bType.equalsIgnoreCase("firefox")){
						
						System.setProperty("webdriver.gecko.driver", "D:\\jars\\latest\\geckodriver.exe");
						driverInstance = new FirefoxDriver();
						
					}
					else if(bType.equalsIgnoreCase("chrome")){
						
						System.setProperty("webdriver.chrome.driver", "D:\\jars\\latest\\chromedriver.exe");
						driverInstance = new ChromeDriver();
						
					}
					else if(bType.equalsIgnoreCase("ie")){
						
						System.setProperty("webdriver.ie.driver", "D:\\jars\\latest\\geckodriver.exe");
						driverInstance = new FirefoxDriver();
						
					}
					
				}
				
			}
			
		}
		
		return driverInstance;
		
	}
	
	/*public static WebDriver openBrowser(String bType){
		
		
					
		if(driverInstance == null){
			
			if(bType.equalsIgnoreCase("firefox")){
				
				System.setProperty("webdriver.gecko.driver", "D:\\jars\\latest\\geckodriver.exe");
				driverInstance = new FirefoxDriver();
				
			}
			else if(bType.equalsIgnoreCase("chrome")){
				
				System.setProperty("webdriver.chrome.driver", "D:\\jars\\latest\\chromedriver.exe");
				driverInstance = new ChromeDriver();
				
			}
			else if(bType.equalsIgnoreCase("ie")){
				
				System.setProperty("webdriver.ie.driver", "D:\\jars\\latest\\geckodriver.exe");
				driverInstance = new FirefoxDriver();
				
			}
			
		}
					

		
		return driverInstance;
		
	}*/
	
	public static WebDriver getDriverInstance(){
		
		return driverInstance;
		
	}
	
	public static void setDriverInstanceToNull(){
		
		driverInstance = null;
		
	}

}
