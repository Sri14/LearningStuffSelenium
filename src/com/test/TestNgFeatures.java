package com.test;

import org.testng.annotations.Test;

public class TestNgFeatures {

	@Test
	public void loginTest() {
		System.out.println("Login Test");
		 int i = 9/0;
	}

	@Test(dependsOnMethods = "loginTest")
	public void homePage() {
		System.out.println("Home Page Test");
	}

	@Test(dependsOnMethods = "loginTest")
	public void searchPage() {
		System.out.println("Search Page Test");
	}

	@Test(dependsOnMethods = "loginTest")
	public void registrationPage() {
		System.out.println("Registration Page Test");
	}

}
