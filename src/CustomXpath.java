import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CustomXpath {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "/Users/HomeMac/Desktop/SeleniumProject/Drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.giffgaff.com/mobile-phones/pre-owned/apple/apple-iphone-7/phone-plans");
		
		
		driver.findElement(By.xpath("//a[@id='pay-monthly-btn']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'256GB')]")).click();
		driver.findElement(By.xpath("//input[contains(@value,'5000')]")).click();
		driver.findElement(By.xpath("//li[@title='jet-black']")).click();
		
		
		Thread.sleep(3000);
		driver.quit();
		
		
	}

}
