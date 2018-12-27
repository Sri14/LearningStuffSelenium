import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocatorConcept {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "/Users/HomeMac/Desktop/SeleniumProject/Drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F");
		
		//driver.findElement(By.id("firstname")).sendKeys("autofirstname");
		driver.findElement(By.xpath("//*[@id='firstname']")).sendKeys("Tom");
		//driver.findElement(By.linkText("Create a business account")).click();
		driver.findElement(By.partialLinkText("Notice")).click();
		
	}

}
