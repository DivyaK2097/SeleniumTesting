package com.exercise.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.exercise.base.Base;

public class BasicAuth extends Base {
    
    @Test
    public void basicAuth() {
        //Set up basic authentication credentials in the URL
        String username = "admin";
        String password = "admin";
        String url = "https://" + username + ":" + password + "@the-internet.herokuapp.com/basic_auth";
        
        //Navigate to the URL
        driver.get(url);
        
        //Implicit wait (for general elements loading)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        //Wait explicitly for the page content to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        //Wait for the success message or any specific element that indicates the page is loaded
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='example']/h3")));
        
        //Now you can interact with the page if needed 
        String successMessage = driver.findElement(By.xpath("//div[@class='example']/h3")).getText();
        System.out.println("Success Message: " + successMessage);
        
        //Wait for sometime before closing the browser
        try {
            Thread.sleep(5000);  // Wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
