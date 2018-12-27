package practiseExcelData;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import setUpExcel.GiffgaffExcelSetUp;

public class GiffgaffTestExcel {
	WebDriver driver;

	@Test(dataProvider = "giffgaffData")
	public void login(String username, String password) throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/HomeMac/Desktop/SeleniumProject/Drivers/geckodriver");
		driver = new FirefoxDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.giffgaff.com/auth/login");

		driver.findElement(By.id("nickname")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login_submit_button")).click();
		Thread.sleep(3000);

		Assert.assertTrue(driver.getCurrentUrl().contains("com/dashboard"), "Please enter valid login details");

		driver.quit();

	}
	
	@DataProvider(name = "giffgaffData")
	public Object[][] passdata(){
		
		GiffgaffExcelSetUp config = new GiffgaffExcelSetUp("/Users/HomeMac/Documents/workspace/SeleniumSessions/src/dDT/TestData/GiffgaffData.xlsx");
		int rows = config.getRowCount(0);
		
		
		Object[][] data = new Object[rows][2];		
		for(int i=0; i<rows;i++){
			
			data[i][0]=config.getData(0, i, 0);
			data[i][1]=config.getData(0, i, 1);
		}
		return data;
		
		
	}
	
}



/*
 *@DataProvider(name = "giffgaffData")
	public Object[][] passData() {
		GiffgaffExcelSetUp config = new GiffgaffExcelSetUp("/Users/HomeMac/Documents/workspace/SeleniumSessions/src/dDT/TestData/GiffgaffData.xlsx");
		int rows = config.getRowCount(0);

		Object[][] data = new Object[rows][2];

		for (int i = 0; i < rows; i++) {
			data[i][0] = config.getData(0, i, 0);
			data[i][1] = config.getData(0, i, 1);
		}
		return data;

	}
 */
