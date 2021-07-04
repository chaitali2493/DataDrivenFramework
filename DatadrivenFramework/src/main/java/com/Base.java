package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Base {



	@Test(dataProvider="Data")
	public void configuration_properties_initialization(String username_var, String password_var) 
	{
		
		System.setProperty("webdriver.chrome.driver", "D://setup//chrome_driver//chromedriver_win32//chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.xpath("//input[@class=\"input_error form_input\"]")).sendKeys(username_var);
		driver.findElement(By.xpath("//input[contains(@id,'password')]")).sendKeys(password_var);
		driver.findElement(By.cssSelector("input#login-button")).click();
		//driver.close();
		
	}
	
	@DataProvider(name = "Data")
	public Object[][] Data_pass()
	{
		
		Object[][] obj_var=new Object[2][2];
		obj_var[0][0]="locked_out_user";
		obj_var[0][1]="secret_sauce";
		
	    obj_var[1][0]="standard_user";
        obj_var[1][1]="secret_sauce";
		
		return obj_var;
		
	}
	
}
