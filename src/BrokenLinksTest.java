import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrokenLinksTest {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "/Users/HomeMac/Desktop/SeleniumProject/Drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.giffgaff.com");

		List<WebElement> list = driver.findElements(By.tagName("a"));
		System.out.println(list.size());
		
		List<WebElement> activeLinks = new ArrayList<WebElement>();
		
		for(int x=0; x<list.size();x++){
			if(list.get(x).getAttribute("href")!= null){
				activeLinks.add(list.get(x));
			}
			
		System.out.println("number of active links"+activeLinks.size());	
		}
		
		Thread.sleep(2000);
		driver.quit();

	}

}
