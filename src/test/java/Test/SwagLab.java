package Test;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.TestUtil;

public class SwagLab {
	WebDriver driver;
	
	@BeforeTest
	public void setup()
	{		
	System.setProperty("webdriver.chrome.driver", "D://setup//chrome_driver//chromedriver//chromedriver.exe");
	driver =new ChromeDriver();
	driver.get("https://www.saucedemo.com/v1/");				
	}

	@DataProvider
	public Object[][] LoginData() 
	{
		Object[][] data =TestUtil.getData("login");
		System.out.println("Username_o"+data);
		return data;
	}
	
	
	@Test(dataProvider="LoginData")
	public void LoginTest(String Username, String Password)
	{
	System.out.println(Username);
	System.out.println(Password);
		driver.findElement(By.id("user-name")).sendKeys(Username);
		driver.findElement(By.id("password")).sendKeys(Password);
		driver.findElement(By.id("login-button")).click();
	}
	/*
	
	@AfterTest
	public void teardown()
	{		
		driver.quit();			
	}
	*/
}
