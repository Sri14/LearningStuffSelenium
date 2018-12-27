package com.parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersTest {
	
	WebDriver driver;
	
	
	
	@Test
	@Parameters({"browser"})
	public void launchBrowser(String browser){
	
		if(browser.equals("chrome")){
		System.setProperty("webdriver.chrome.driver", "/Users/HomeMac/Desktop/SeleniumProject/Drivers/chromedriver");
		driver = new ChromeDriver();
		}else if(browser.equals("firefox")){
		System.setProperty("webdriver.gecko.driver", "/Users/HomeMac/Desktop/SeleniumProject/Drivers/geckodriver");
		driver = new FirefoxDriver();
		}
	}
	
	@Test(priority=1)
	@Parameters({"url"})
	public void launchurl(String url){
		driver.get(url);
	}
	
	@Test(priority=2)
	@Parameters({"username"})
	public void username(String username){
		driver.findElement(By.id("login1")).sendKeys(username);
	}
	
	@Test(priority=3)
	@Parameters({"password"})
	public void password(String password){
		driver.findElement(By.id("password")).sendKeys(password);
	}
	
	@Test(priority=4)
	public void submitButton(){
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	
	@Test(priority=5)
	public void checkTitle(){
		String title = driver.getTitle();
		Assert.assertEquals(title, "Rediffmail NG - Login error");
	}

	@AfterClass
	public void quit(){
		driver.quit();
	}
	
	
	
	
}
