package org.example.Selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class sel13checkbox{
    WebDriver driver;
    @BeforeTest
    public void openBrowser(){

        driver=new EdgeDriver();

    }
    @Test
    public void loginpositive() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        driver.manage().window().maximize();
        //WebElement alert_button=driver.findElement(By.xpath("//button[contains(text(),\"Click for JS Alert\")]"));
        List<WebElement> check_box=driver.findElements(By.xpath("//input[@type=\"checkbox\"]"));
        WebElement ch1=check_box.get(0);
        System.out.println(ch1.getText());
        ch1.click();
        Thread.sleep(5000);

    }
    @AfterTest
    public void closeBrowser()
    {
        driver.quit();
    }
}


