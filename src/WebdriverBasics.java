import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebdriverBasics {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "/Users/HomeMac/Desktop/SeleniumProject/Drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();

		String url = "https://www.google.co.uk";


		driver.get(url);
		
		System.out.println(driver.getTitle());
		String title = driver.getTitle();
		
		if (title.equals("Google")) {
			System.out.println("title is correct and is :" + title);
		} else {
			System.out.println("title is incorrect and is :" + title);
		}

//		String url1 = driver.getCurrentUrl();
//		System.out.println(url1);
//		
		
		System.out.println(driver.getCurrentUrl());
		driver.quit();
	}

}
