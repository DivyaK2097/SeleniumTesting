package com.exercise.base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
	protected WebDriver driver;
	String url = "https://the-internet.herokuapp.com/";
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Windows\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(160));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(160));
		driver.close();
		driver.quit();
	}
}
