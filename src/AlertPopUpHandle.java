import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AlertPopUpHandle {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
//		System.setProperty("webdriver.gecko.driver", "/Users/HomeMac/Desktop/SeleniumProject/Drivers/geckodriver");
//		WebDriver driver = new FirefoxDriver();
//		
		
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		System.setProperty("webdriver.chrome.driver","/Users/HomeMac/Desktop/SeleniumProject/Drivers/chromedriver");	
		driver = new ChromeDriver(options); 
		driver.get("https://www.google.co.in");
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.name("proceed")).click();
		System.out.println("Test is completed");
	/*	
		Alert alert = driver.switchTo().alert();// Alert class switches the control to alert
		System.out.println(alert.getText());// to get the text of the alert

		String poptext = alert.getText(); 	//to check the alert message is correct
		if(poptext.equals("Please enter a valid user name")){
			System.out.println("Correct Alert");
		}else{
			System.out.println("Incorrect Alert");
		}
		Thread.sleep(5000); //wait command

		alert.accept(); //clicks on OK button

		//alert.dismiss();// to click on cancel button */
	}

}
