import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HtmlUnitDriver {

	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.gecko.driver", "/Users/HomeMac/Desktop/SeleniumProject/Drivers/geckodriver");
		//WebDriver driver = new FirefoxDriver();
		
		WebDriver driver = new org.openqa.selenium.htmlunit.HtmlUnitDriver();
		
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://www.freecrm.com");
		System.out.println("Before login title ==== " + driver.getTitle());

		driver.findElement(By.name("username")).sendKeys("naveenk");
		driver.findElement(By.name("password")).sendKeys("test@123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type = 'submit']")).click();
		System.out.println("After login title =====  " + driver.getTitle());
		Thread.sleep(2000);
		driver.quit();
	}

}
