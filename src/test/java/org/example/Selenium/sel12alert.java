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

public class sel12alert{
    WebDriver driver;
    @BeforeTest
    public void openBrowser(){

        driver=new EdgeDriver();

    }
    @Test
    public void loginpositive() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        //WebElement alert_button=driver.findElement(By.xpath("//button[contains(text(),\"Click for JS Alert\")]"));
        WebElement alert_button=driver.findElement(By.xpath("//button[contains(text(),\"Click for JS Prompt\")]"));
        alert_button.click();
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("Archana");
        alert.accept();
        String result=(driver.findElement(By.id("result"))).getText();
        Assert.assertEquals(result,"You entered: Archana");

    }
    @AfterTest
    public void closeBrowser()
    {
        driver.quit();
    }
}


