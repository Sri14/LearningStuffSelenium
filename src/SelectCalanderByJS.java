import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SelectCalanderByJS {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "/Users/HomeMac/Desktop/SeleniumProject/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.spicejet.com/");
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTNR")).click();;
		driver.findElement(By.xpath("//a[contains(text(),'30')]")).click();
		
		
//		WebElement date = driver.findElement(By.id("view_fulldate_id_1"));
//		
//		String dateValue = "Sun, Dec 09 2018";
//		
//		selectDateByJS(driver, date, dateValue);
//
//		
//	}
//	
//	public static void selectDateByJS(WebDriver driver, WebElement element, String dateValue){
//		JavascriptExecutor js = ((JavascriptExecutor) driver);
//		js.executeScript("arguments[0].setAttribute('value','"+dateValue+"'):", element);

	
	}

}
