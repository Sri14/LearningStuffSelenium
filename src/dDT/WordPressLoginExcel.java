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

import setUpExcel.setUpExcel;

public class WordPressLoginExcel {
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
		
		setUpExcel config = new setUpExcel("/Users/HomeMac/Documents/workspace/SeleniumSessions/src/dDT/TestData/InputData.xlsx");
		int row = config.getRowCount(0);
		System.out.println(row);
		
		Object[][] data = new Object[row][2];
		
		for(int i =0; i<row ; i++){
			
			data[i][0] = config.readData(0, i, 0);

			data[i][0] = config.readData(0, i, 1);

		}

		return data;

	}

}
