package com.intBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.intBanking.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String browser)
	{
		logger=Logger.getLogger("ebanking");
        PropertyConfigurator.configure("Log4j.properties");
		
        if(browser.equals("chrome"))
        {
        System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
        driver=new ChromeDriver();
        }
        else if(browser.equals("edge"))
        {
        	System.setProperty("webdriver.edge.driver",readconfig.getEdgePath());
            driver=new EdgeDriver();
        }
        
        else if(browser.equals("ie"))
        {
        	System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
            driver=new InternetExplorerDriver();
        }
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseURL);
	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver,String tname) throws IOException
	{
	 File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
     
     FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png"));
     
     System.out.println("Screenshot taken");
	}
  
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	public static String randomNum()
	{
		String generatedString2=RandomStringUtils.randomNumeric(4);
		return(generatedString2);
	}
	
}
