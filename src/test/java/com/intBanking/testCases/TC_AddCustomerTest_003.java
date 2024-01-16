package com.intBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.intBanking.pageObjects.AddCustomerPage;
import com.intBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass 
{

	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username is provided");
		lp.setPassword(password);
		logger.info("Password is provided");
		lp.clickSubmit();
		
		Thread.sleep(5000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		
		Thread.sleep(5000);
		
		/*WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(By.id("dismiss-button")));
		ele.click();*/
		//driver.switchTo().alert().dismiss();
		
		logger.info("Providing customer details...");
		addcust.custName("Geetha");
		addcust.custgender("female");
		addcust.custdob("05","21","95");
		Thread.sleep(5000);
		addcust.custaddress("India");
		addcust.custcity("Banaglore");
		addcust.custstate("Karnataka");
		addcust.custpinno("560023");
		addcust.custtelephoneno("9113522622");
		
		Thread.sleep(5000);
		
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdefg");
		addcust.custsubmit();
		
		Thread.sleep(5000);
		logger.info("Validation started...");
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("Testcase passed");
		}
		else
		{
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
			logger.info("Testcase failed");
		}
		
	}

	
	}
	
	

