package dDT;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WordPressLogin {
	WebDriver driver;

	@Test(dataProvider = "wordpressData")
	public void loginToWordPress(String username, String password) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "/Users/HomeMac/Desktop/SeleniumProject/Drivers/geckodriver");
		driver = new FirefoxDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://demosite.center/wordpress/wp-login.php");

		driver.findElement(By.id("user_login")).sendKeys(username);

		WebElement password1 = driver.findElement(By.id("user_pass"));
		password1.sendKeys(password);
		password1.sendKeys(Keys.TAB);
		Thread.sleep(5000);

		driver.findElement(By.id("wp-submit")).click();
		Thread.sleep(3000);

		Assert.assertTrue(driver.getTitle().contains("Dashboard"),"User unable to login");
		
		System.out.println("user able to login");
	}

	@AfterMethod
	@Test
	public void tearDown() {
		driver.quit();
	}

	@DataProvider(name = "wordpressData")
	public Object[][] passData() {

		Object[][] data = new Object[3][2];

		data[0][0] = "admin1";
		data[0][1] = "demo1";

		data[1][0] = "admin";
		data[1][1] = "demo123";

		data[2][0] = "admin1";
		data[2][1] = "demo1333";

		return data;

	}

}
