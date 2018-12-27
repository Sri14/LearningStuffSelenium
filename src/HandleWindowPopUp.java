import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandleWindowPopUp {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "/Users/HomeMac/Desktop/SeleniumProject/Drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		
		driver.get("http://popuptest.com/goodpopups.html");
		
		driver.findElement(By.xpath("//a[contains(text(),'Good PopUp #1')]")).click();
		
		Set <String> handlers=driver.getWindowHandles();
		Iterator<String> it = handlers.iterator();
		
		String parentWindow = it.next();
		System.out.println(parentWindow);
		
		String childWindow = it.next();
		System.out.println(childWindow);
		
		driver.switchTo().window(childWindow);
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		driver.close();
		
		driver.switchTo().window(parentWindow);
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		driver.quit();
		
		
		
	
	}

}
