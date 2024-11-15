package com.exercise.test;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.exercise.base.Base;

public class DropDown extends Base {
    @Test
    public void dropDown() {
        //Navigate to dropdown page
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[11]/a")).click();
        
        //Wait for the dropdown to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"dropdown\"]")));

        //Interact with dropdown
        Select select = new Select(dd);
        
        //Index - Option 1 (0-based index)
        select.selectByIndex(1);
        
        //Value - Value of the option 
        select.selectByValue("1");
        
        //Visible Text - Matching text in the dropdown
        select.selectByVisibleText("Option 2");
    }
}
