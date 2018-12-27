package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/HomeMac/Desktop/SeleniumProject/Drivers/chromedriver");
		driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.get("https://www.google.co.uk");
	}

	@Test(priority = 1, groups="Title")
	public void getTitle() {
		String title = driver.getTitle();
	}

	@Test(priority = 2, groups="Logo")
	public void checkLogo() {
		Boolean d = driver.findElement(By.id("hplogo")).isDisplayed();
	}

	@Test(priority = 3, groups="Link Text")
	public void checkMailLink() {
		Boolean m = driver.findElement(By.linkText("Gmail")).isEnabled();
	}
	
	@Test(priority = 4, groups="Test")
	public void test4(){
		System.out.println("Test 4");
	}
	
	@Test(priority = 5, groups="Test")
	public void test5()
	{
		System.out.println("Test 5");
	}
	
	@Test(priority = 6, groups="Test")
	public void test6(){
		System.out.println("Test 6");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}	

}
