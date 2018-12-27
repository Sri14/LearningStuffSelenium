import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ElementVisibleTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/Users/HomeMac/Desktop/SeleniumProject/Drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.freecrm.com/register/");
		
		//1. is displayed () - checks if the element is visible
		
		boolean b1 = driver.findElement(By.id("submitButton")).isDisplayed();
		System.out.println(b1);
		
		//2. isEnabled() - checks 
		boolean b2=driver.findElement(By.id("submitButton")).isEnabled();
		System.out.println(b2);
		
		driver.findElement(By.xpath("//input[@type ='checkbox']")).click();
		
		boolean b3 = driver.findElement(By.id("submitButton")).isEnabled();
		System.out.println(b3);
		
		//3. isSelected() - only applicable for checkboxes,dropdowns and radio buttons
		
		boolean b4 = driver.findElement(By.name("agreeTerms")).isSelected();
		System.out.println(b4);
	}

}
