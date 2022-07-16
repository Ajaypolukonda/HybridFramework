package commonFunction;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import constant.AppUtil;

public class FunctionLibrary extends AppUtil{
	//method for login
	public static boolean verifylogin(String username,String password)
	{
		driver.findElement(By.xpath(ajay.getProperty("objuser"))).sendKeys(username);
		driver.findElement(By.xpath(ajay.getProperty("objpass"))).sendKeys(password);
		driver.findElement(By.xpath(ajay.getProperty("objloginbtn"))).click();
		String expected="adminflow";
		String actual=driver.getCurrentUrl();
		if (actual.toLowerCase().contains(expected.toLowerCase())) 
		{
			Reporter.log("success"+expected+"   "+actual,true);
			return true;
		}
		else
		{
			Reporter.log("fail"+expected+"   "+actual,true);
			return false;
		}
	}
	//method for click branches
	public static void clickbranches() {
		driver.findElement(By.xpath(ajay.getProperty("objbranches"))).click();
	}
	//method for logout
	public static boolean verifylogout() {
		driver.findElement(By.xpath(ajay.getProperty("objlogout"))).click();
		if (driver.findElement(By.xpath(ajay.getProperty("objloginbtn"))).isDisplayed()) 
		{
			Reporter.log("logout success",true);
			return true;
		}
		else
		{
			Reporter.log("logout fail",true);
			return false;
		}
	}
	//method for branch creation
	public static boolean verifybranchcreation(String branchname,String address1,String address2,
			String address3,String area,String zipcode,String country,String state,String city) throws Throwable
	{
		driver.findElement(By.xpath(ajay.getProperty("objnewbranch"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ajay.getProperty("objbranchname"))).sendKeys(branchname);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ajay.getProperty("objaddress1"))).sendKeys(address1);
		Thread.sleep(2000);
		driver.findElement(By.name(ajay.getProperty("objaddess2"))).sendKeys(address2);
		Thread.sleep(2000);
		driver.findElement(By.name(ajay.getProperty("objaddress3"))).sendKeys(address3);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ajay.getProperty("objarea"))).sendKeys(area);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ajay.getProperty("objzipcode"))).sendKeys(zipcode);
		Thread.sleep(2000);
		new Select(driver.findElement(By.xpath(ajay.getProperty("objcountry")))).selectByVisibleText(country);
		Thread.sleep(2000);
		new Select(driver.findElement(By.xpath(ajay.getProperty("objstate")))).selectByVisibleText(state);
		Thread.sleep(2000);
		new Select(driver.findElement(By.xpath(ajay.getProperty("objcity")))).selectByVisibleText(city);
		Thread.sleep(2000);
		driver.findElement(By.xpath(ajay.getProperty("objsubmitbtn"))).click();
		//capture alert message
		String expectedalert=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		String actualalert="New Branch with id ";
		if (expectedalert.toLowerCase().contains(actualalert.toLowerCase())) 
		{
			Reporter.log("Branch created successfully"+expectedalert+"   "+actualalert,true);
			return true;
		}
		else {
			Reporter.log("branch creation fail"+expectedalert+"    "+actualalert,true);
			return false;
		}
	}
	public static boolean verifybranchupdate(String branch,String address,String Area)
	{
		driver.findElement(By.xpath(ajay.getProperty("objbranchedit"))).click();
		WebElement element=driver.findElement(By.xpath(ajay.getProperty("objbranch")));
		element.clear();
		element.sendKeys(branch);
		WebElement element1=driver.findElement(By.xpath(ajay.getProperty("objaddress")));
		element1.clear();
		element1.sendKeys(address);
		WebElement element2=driver.findElement(By.xpath(ajay.getProperty("objareaofbank")));
		element2.clear();
		element2.sendKeys(Area);
		driver.findElement(By.xpath(ajay.getProperty("objupdatebtn"))).click();
		String expectedupdate=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		String actualupdate="Branch";
		if (expectedupdate.toLowerCase().contains(actualupdate.toLowerCase())) 
		{
		Reporter.log(expectedupdate+"    "+actualupdate,true);
		return true;
		}
		else {
			Reporter.log(expectedupdate+"   "+actualupdate,true);
			return false;
		}
}
	public static void clickroles() {
		driver.findElement(By.xpath(ajay.getProperty("objrolesbtn"))).click();
	}
	public static boolean verifyrolecreation(String rolename,String roledes,String roletype) throws Throwable
	{
		driver.findElement(By.xpath(ajay.getProperty("objnewrole"))).click();
		driver.findElement(By.xpath(ajay.getProperty("objrolename"))).sendKeys(rolename);
		driver.findElement(By.xpath(ajay.getProperty("objroledes"))).sendKeys(roledes);
		Thread.sleep(2000);
		new Select(driver.findElement(By.xpath(ajay.getProperty("objroletype")))).selectByVisibleText(roletype);
		driver.findElement(By.xpath(ajay.getProperty("objsubmitrolebtn"))).click();
		String expectedrole=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		String actualrole="New Role with id 9 ";
		if (expectedrole.toLowerCase().contains(actualrole.toLowerCase())) 
		{
			Reporter.log(expectedrole+"   "+actualrole,true);
			return true;
		}
		else
		{
			Reporter.log(expectedrole+"   "+actualrole,true);
			return false;
		}
	}
	
	}






