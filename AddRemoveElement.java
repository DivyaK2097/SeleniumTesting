package com.exercise.test;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.exercise.base.Base;

public class AddRemoveElement extends Base {

    @Test
    public void addAndRemoveElement() {
        //Navigate to the Add/Remove Elements in page
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[2]/a")).click();

        //Wait for the "Add Element" button to be visible and clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/div/button")));

        //Add two elements by clicking the "Add Element" button twice
        addButton.click();
        addButton.click();

        //Wait for the new elements to be added (verify two new buttons are visible)
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//*[@id='elements']/button"), 1));

        //Remove the first added element
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"elements\"]/button[1]")));
        deleteButton.click();
    }
}
