package HRM_BASECLASS;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.EventListener;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.spi.RegisterableService;
import javax.management.relation.RelationServiceNotRegisteredException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import HRM_UtilCLass.Testutil;
import HRM_UtilCLass.WebEventListener;

public class TestBase
{
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static Actions action;
	
	public TestBase() 
	{
		try{
		prop=new Properties();
		FileInputStream prop_file=new FileInputStream("C:\\workspace\\HRM_POM_Project1\\src\\main\\java\\HRM_UtilCLass\\config.properties");
		prop.load(prop_file);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public static void initilization()
	{
		String browsername=prop.getProperty("Browser");
		if(browsername.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","E:\\Seleniumworkfolder\\All jar files for project\\chromedriver_win32\\chromedriver.exe");
	         driver = new ChromeDriver();
		}else
		{
			System.setProperty("webdriver.gecko.driver","D:\\Raghu\\Raghu\\chromedriver_win32\\geckodriver-v0.26.0-win32.exe");
			driver = new FirefoxDriver();
		}
		e_driver=new EventFiringWebDriver(driver);
		eventListener=new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Testutil.PAGE_LOAD_TEST,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Testutil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));
		action=new Actions(driver);
		
	}

}
