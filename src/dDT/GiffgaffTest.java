package dDT;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import net.sourceforge.htmlunit.corejs.javascript.ObjArray;

public class GiffgaffTest {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp(){
		System.setProperty("webdriver.gecko.driver", "/Users/HomeMac/Desktop/SeleniumProject/Drivers/geckodriver");
		driver = new FirefoxDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
	}
	
	
	@Test(dataProvider = "giffgaffData")
	public void giffgafflogin(String username, String password) throws Exception{
		
		driver.get("https://www.giffgaff.com/auth/login");
		
		driver.findElement(By.id("nickname")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login_submit_button")).click();
		Thread.sleep(3000);
		
		Assert.assertTrue(driver.getCurrentUrl().contains("com/dashboard"), "Please enter valid details");
	
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	@DataProvider (name = "giffgaffData")
	public Object[][] logindata(){
		
		Object[][] data = new Object[3][2];
		data[0][0] = "test1";
		data[0][1] = "password1";
		
		data[1][0] = "ggsri";
		data[1][1] = "Enter123";
		
		data[2][0] = "test13";
		data[2][1] = "password1";
		
		return data;
	}
	
	
	

}
