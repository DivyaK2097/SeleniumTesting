package com.exercise.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.exercise.base.Base;

public class CheckBoxes extends Base {

    @Test
    public void checkBoxes() {
        // Navigate to the page containing the checkboxes
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[6]/a")).click();
        
        // Wait until the checkboxes are visible and interactable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ch1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"checkboxes\"]/input[1]")));
        WebElement ch2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"checkboxes\"]/input[2]")));
        
        // Print the selected state of checkbox 1 (before clicking)
        System.out.println("Checkbox 1 (Before): "  + ch1.isSelected());

        // Print the selected state of checkbox 2 (before clicking)
        System.out.println("Checkbox 2 (Before): "  + ch2.isSelected());

        // Only click if the checkbox is not already in the desired state
        if (!ch1.isSelected()) {
            ch1.click();  // Click if checkbox 1 is not selected
        }

        if (!ch2.isSelected()) {
            ch2.click();  // Click if checkbox 2 is not selected
        }
        
        // Print the selected state of each checkbox after clicking
        System.out.println("After clicking each checkbox:");
        System.out.println("Checkbox 1 (After): "  + ch1.isSelected());
        System.out.println("Checkbox 2 (After): "  + ch2.isSelected());
    }
}
