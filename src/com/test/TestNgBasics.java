package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgBasics {
	
//Pre-Conditions starting with @Before
	
	@BeforeSuite
	public void setup() {
		System.out.println("Setup system property for chrome");
	}

	@BeforeTest
	public void launchBrowser() {
		System.out.println("Launch Browser");
	}
	
	@BeforeClass
	public void login() {
		System.out.println("Login to app");
	}

	@BeforeMethod
	public void enterUrl() {
		System.out.println("Entering Url");
	}


//Test case starting with @Test
	@Test
	public void googleTitleTest() {
		System.out.println("Google Title test");
	}
	
	@Test
	public void search(){
		System.out.println("Search function");
	}
//post conditions starting with @After condition
	
	
	@AfterMethod
	public void logOut() {
		System.out.println("Logout Method");
	}

	@AfterTest
	public void deleteAllCookies() {
		System.out.println("Delete All cookies");
	}

	@AfterClass
	public void closeBrowser(){
		System.out.println("Close browser");
	}
	
//	@AfterSuite
//	public void generateTestReport(){
//		System.out.println("Generate Test Report");
//	}
	
}

