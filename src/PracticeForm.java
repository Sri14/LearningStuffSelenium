import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.synth.SynthSpinnerUI;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class PracticeForm {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "/Users/HomeMac/Desktop/SeleniumProject/Drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://giffgaff.com");
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[@id='our_offer']"))).build().perform();
		driver.findElement(By.xpath("//a[contains(text(),'Samsung')]")).click();
		driver.findElement(By.className("handsets-filters-selectors__sort")).click();
		driver.findElement(By.xpath("//li[@data-sort='community-rating']")).click();
		driver.findElement(By.linkText("Samsung Galaxy J6")).click();
		driver.findElement(By.xpath("//li[@title='gold']")).click();
		driver.findElement(By.xpath("//input[@name='btnSubmit']")).click();
		
		WebElement Submitbtn = driver.findElement(By.xpath("//input[@name='btnSubmit']"));
		flash(Submitbtn, driver);

		Thread.sleep(2000);
		
		action.moveToElement(driver.findElement(By.xpath("//a[@class='topmenu navlink__level1']"))).build().perform();
		driver.findElement(By.xpath("//a[contains(text(),'Pre-owned phones')]")).click();
		Select select = new Select(driver.findElement(By.xpath("//select[@id='filter']")));
		select.selectByVisibleText("Apple");
		
		Thread.sleep(3000);
		driver.quit();
		
	}
	
	public static void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgColor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 100; i++) {
			changeColor("rgb(0,255,0)", element, driver);
			changeColor(bgColor, element, driver);

		}
	}

	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '" +color+"'", element);
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
		}
	}

}
