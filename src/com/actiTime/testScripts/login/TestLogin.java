package com.actiTime.testScripts.login;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.actiTime.pageLibrary.loginPage.LoginPage;
import com.actiTime.testBase.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestLogin extends TestBase {

	@BeforeClass
	public void setUp() throws IOException {
		init();
	}

	@Test
	public void testLogin() throws Exception {

		ExtentReports report = new ExtentReports(System.getProperty("user.dir")
				+ "\\src\\com\\actiTime\\screenShot\\LoginTest.html");
		ExtentTest logger = report.startTest("verify actime login");
		logger.log(LogStatus.INFO, "Browser is up and running");
		LoginPage login = new LoginPage();
		login.loginToApplication();
		logger.log(LogStatus.INFO, "Login Is successfule");
		report.endTest(logger);
		report.flush();
	}

	@AfterClass
	public void testDown() {
		closeBrowser();
	}

}
