import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BootstrapDropboxHandle {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "/Users/HomeMac/Desktop/SeleniumProject/Drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		
		driver.get("http://v4-alpha.getbootstrap.com/components/dropdowns/");
		
		driver.findElement(By.id("dropdownMenu2")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[contains(text(),'Another action')]")).click();
		
		Thread.sleep(2000);
		driver.quit();
	}

}
