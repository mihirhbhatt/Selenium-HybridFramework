package com.actiTime.testScripts.timeTracksPageScripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.actiTime.pageLibrary.loginPage.LoginPage;
import com.actiTime.testBase.TestBase;

public class TC_001 extends TestBase{
	
	String dateTime ="12/Mar/2014";
	
	
	@BeforeClass
	public void setUp() throws IOException{
		init();
	}
	
	@Test
	public void testCreateNewTimeTrack() throws Exception{
		LoginPage loginpage = new LoginPage();
		loginpage.loginToApplication();
		driverwait(6);
		expliciteWait(getWebElement("actiTime.timeTrack.new.link"), 10);
		getWebElement("actiTime.timeTrack.new.link").click();
		getWebElement("actimeTime.timeTrack.new.selectCustomer.button").click();
		getWebElements("actimeTime.timeTrack.new.selectCustomer.customerlist").get(3).click();
		driverwait(3);
		//driver.findElement(By.xpath("//a[contains(text(),'Our Company')]")).click();
		getWebElement("actimeTime.timeTrack.new.selectProject.button").click();
		driver.findElement(By.xpath("//a[contains(text(),'One-page web site')]")).click();
		int taskrows = getWebElements("actimeTime.timeTrack.new.taskTableName.rows").size();
		int taskcols = getWebElements("actimeTime.timeTrack.new.taskTableName.rows").size();
		System.out.println(taskrows);
		for(int i = 1; i<4; i++){
			String firstPart = "//*[@id='createTasksPopup_createTasksTableContainer']/table/tbody/tr[";
			String secondPart = "]/td[";
			String thirdpart = "]";
			
			for(int j = 1; j<=4;j++){
				String enterTaskName = firstPart+i+secondPart+j+thirdpart;
				if(j == 1){
					driver.findElement(By.xpath(enterTaskName+"/input")).sendKeys("test"+i);	
				}
				else if(j ==2){
					enterTaskName = firstPart+i+secondPart+j+thirdpart;
					driver.findElement(By.xpath(enterTaskName+"/table/tbody/tr/td/a/img")).click();
					driverwait(1);
					driver.findElement(By.xpath("//*[@id='editDescriptionPopupText']")).sendKeys("I am creating task");
					driver.findElement(By.xpath("//*[@id='scbutton']")).click();
				}
				else if(j == 3){
					String date_dd_MM_yyyy[] = dateTime.split("/");
					// click on calendar
					driverwait(1);
					enterTaskName = firstPart+i+secondPart+j+thirdpart;
					//System.out.println(enterTaskName);
					driver.findElement(By.xpath(enterTaskName+"/div/table/tbody/tr/td[2]/em/button")).click();
					driverwait(1);
					//driver.findElements(By.xpath("//*[@class='x-date-picker x-unselectable atap-base-date-picker atap-date-picker']/table/tbody/tr/td[2]/table/tbody/tr/td[2]/em/button")).get(0).click();
					if(i == 1){
						driver.findElements(By.xpath("//div[@class='x-date-picker x-unselectable atap-base-date-picker atap-date-picker']/table/tbody/tr/td[2]/table/tbody/tr/td[2]")).get(0).click();	
					}
					if(i == 2){
						driver.findElements(By.xpath("//div[@class='x-date-picker x-unselectable atap-base-date-picker atap-date-picker']/table/tbody/tr/td[2]/table/tbody/tr/td[2]")).get(1).click();	
					}
					
					if(i == 3){
						driver.findElements(By.xpath("//div[@class='x-date-picker x-unselectable atap-base-date-picker atap-date-picker']/table/tbody/tr/td[2]/table/tbody/tr/td[2]")).get(2).click();	
					}
					
					driverwait(1);
					// select year
					List<WebElement> year = driver.findElements(By.xpath("//*[@class='x-date-mp-year']/a"));
					for(WebElement y:year){
						if(y.getText().equalsIgnoreCase(date_dd_MM_yyyy[2])){
							y.click();
						}
					}
					// select month
					List<WebElement> monthsFirstCol = driver.findElements(By.xpath("//*[@class='x-date-mp-month x-date-mp-sep']/a"));
					for(WebElement month:monthsFirstCol){
						if(month.getText().equalsIgnoreCase(date_dd_MM_yyyy[1])){
							month.click();
						}
					}
					List<WebElement> monthsSecondCol = driver.findElements(By.xpath("//*[@class='x-date-mp-month']/a"));
                       for(WebElement month:monthsSecondCol){
                    	   if(month.getText().equalsIgnoreCase(date_dd_MM_yyyy[1])){
   							month.click();
   						}
					}
                     driverwait(1);
					// click on ok button of calendar
                     if(i==1){
                    	 driver.findElements(By.xpath("//*[@class='x-date-mp-btns']/td/button[1]")).get(0).click(); 
                     }
                     if(i==2){
                    	 driver.findElements(By.xpath("//*[@class='x-date-mp-btns']/td/button[1]")).get(1).click(); 
                     }
                     if(i==3){
                    	 driver.findElements(By.xpath("//*[@class='x-date-mp-btns']/td/button[1]")).get(2).click(); 
                     }
					
					driverwait(1);
					// click on date
					List<WebElement> date = driver.findElements(By.xpath("//*[@class='x-date-date']/em/span"));
					for(WebElement d:date){
						if(d.getText().equalsIgnoreCase(date_dd_MM_yyyy[0])){
							d.click();
						}
					}
				}	
				else if(j==4){
					driverwait(1);
					enterTaskName = firstPart+i+secondPart+j+thirdpart;
					//System.out.println(enterTaskName);
					driver.findElement(By.xpath(enterTaskName+"/div/table/tbody/tr/td[2]/em/button")).click();
					driverwait(1);
					int count = driver.findElements(By.xpath("//div[@class='x-layer x-menu at-dropdown-list-btn-menu billingTypeSelectorMenu addNewTasks']/ul/li")).size();
					System.out.println("count is:-"+count);
					if(i==1){
						driver.findElements(By.xpath("//div[@class='x-layer x-menu at-dropdown-list-btn-menu billingTypeSelectorMenu addNewTasks']/ul/li")).get(3).click();	
					}
					if(i==2){
						driver.findElements(By.xpath("//div[@class='x-layer x-menu at-dropdown-list-btn-menu billingTypeSelectorMenu addNewTasks']/ul/li")).get(12).click();
					}
					
					if(i==3){
						driver.findElements(By.xpath("//div[@class='x-layer x-menu at-dropdown-list-btn-menu billingTypeSelectorMenu addNewTasks']/ul/li")).get(22).click();
					}
					
				}
			}
		}
		driverwait(3);
		driver.findElement(By.xpath("//*[@id='createTasksPopup_commitBtn']/div/span")).click();
		driverwait(6);
	}
	
	@AfterClass
	public void tearDown(){
		closeBrowser();
	}

}
