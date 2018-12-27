import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameHandling {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "/Users/HomeMac/Desktop/SeleniumProject/Drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.freecrm.com");
		driver.findElement(By.name("username")).sendKeys("testsri");
		driver.findElement(By.name("password")).sendKeys("enter123");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);
		
//		driver.switchTo().frame("mainpanel");
//		
//		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
//		Thread.sleep(3000);
		
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.xpath("//a[contains(text(),'Pipeline')]")).click();
		Thread.sleep(3000);
		driver.quit();

		
	}

}
