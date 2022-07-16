package constant;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class AppUtil {
	public static WebDriver driver;
	public static Properties ajay;
	@BeforeSuite
	public void setUp() throws Throwable
	{
		ajay=new Properties();
		ajay.load(new FileInputStream("D:\\Automation_practice\\Hybrids_Framework\\propertyFiles\\Environment.properties"));
		if (ajay.getProperty("Browser").equalsIgnoreCase("chrome")) 
		{
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(ajay.getProperty("url"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else if (ajay.getProperty("Browser").equalsIgnoreCase("firefox")) 
		{
		driver=new FirefoxDriver();
		driver.get(ajay.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else
		{
			Reporter.log("Browser value not matching",true);
		}
		
		
	}
	@AfterSuite
	public void tearDown() {
		driver.close();
	}

}
