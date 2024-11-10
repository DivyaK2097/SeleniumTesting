package com.exercise.base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

public class Base {
    protected WebDriver driver;
    String url = "https://the-internet.herokuapp.com/";

    @BeforeMethod
    public void setup() {
        //Setup WebDriver (ensure correct ChromeDriver path)
        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        //Set implicit wait duration 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown() {
        //Close and quit WebDriver session
        driver.quit();
    }
}
