package com.actiTime.testScripts.login;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.actiTime.pageLibrary.loginPage.LoginPage;
import com.actiTime.testBase.TestBase;

public class TestLogin1 extends TestBase{
	
	
	@BeforeClass
	public void setUp() throws IOException{
		init();
	}
	
	@Test
	public void testLogin1() throws Exception{
		new LoginPage().loginToApplication();
		
	}
	
	@AfterClass
	
	public void testDown(){
		closeBrowser();
	}

}
