import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ReadPropFile {
	static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {

		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(
				"/Users/HomeMac/Documents/workspace/SeleniumSessions/src/config.properties");

		prop.load(ip);

		String browser = prop.getProperty("browser");

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"/Users/HomeMac/Desktop/SeleniumProject/Drivers/chromedriver");
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/HomeMac/Desktop/SeleniumProject/Drivers/geckodriver");
			driver = new FirefoxDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id(prop.getProperty("Our_Offer_id")))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.linkText(prop.getProperty("Samsung_linktext"))).click();
		driver.findElement(By.className(prop.getProperty("sort_classname"))).click();
		driver.findElement(By.xpath(prop.getProperty("community_favourites_xpath"))).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText(prop.getProperty("Samsung_J6_linktext"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("gold_colour_xpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("PayMonthly_Button_xpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("12Months_xpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("100Initial_xpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("Checkout_now_xpath"))).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText(prop.getProperty("RegisterHere_linkText"))).click();
		driver.findElement(By.id(prop.getProperty("Email_id"))).sendKeys(prop.getProperty("NewEmail"));
		driver.findElement(By.id(prop.getProperty("Password_id"))).sendKeys(prop.getProperty("Password"));
		driver.findElement(By.id(prop.getProperty("NoThanks_id"))).click();
		driver.findElement(By.id(prop.getProperty("RegisterButton_id"))).click();
		
		Select select= new Select(driver.findElement(By.id(prop.getProperty("Title_id"))));
		select.selectByVisibleText(prop.getProperty("Title"));
		
		driver.findElement(By.id(prop.getProperty("FirstName_id"))).sendKeys(prop.getProperty("FirstName"));
		driver.findElement(By.id(prop.getProperty("LastName_id"))).sendKeys(prop.getProperty("LastName"));
		
		
		
		
		Thread.sleep(2000);
		driver.quit();

	}

}
