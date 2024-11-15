package com.exercise.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.exercise.base.Base;

public class DragAndDrop extends Base {
    
    @Test
    public void dragAndDrop() {
        // Navigate to the drag-and-drop page (clicking the link to open the page)
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[10]/a")).click();
        
        // Locate the elements for column A and column B
        WebElement coloumnA = driver.findElement(By.id("column-a"));
        WebElement columnB = driver.findElement(By.id("column-b"));
        
        // Initialize the Actions object for performing mouse interactions
        Actions drgDrp = new Actions(driver);

        // Perform the drag-and-drop action by clicking and holding column A, moving to column B, and releasing
        drgDrp.clickAndHold(coloumnA)    // Hold column A
              .moveToElement(columnB)    // Move to column B
              .release()                  // Release (drop) column A onto column B
              .perform();                 // Execute the action
        
        // Alternatively, you can use a more concise way to perform drag and drop:
        // This method is simpler and directly performs the drag and drop without explicitly specifying each step.
        // drgDrp.dragAndDrop(coloumnA, columnB).perform(); // Drag column A to column B
    }
}
