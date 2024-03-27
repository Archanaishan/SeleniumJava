package org.example.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class sel08 {
    WebDriver driver;
    @BeforeTest
    public void openBrowser(){
        driver=new EdgeDriver();
    }
    @Test
    public void login()
    {
        driver.get("https://app.vwo.com/#/login");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Login - VWO");
    }
    @Test
    public void login_negative(){
        driver.get("https://app.vwo.com/#/login");
        driver.manage().window().maximize();
        WebElement email=driver.findElement(By.id("login-username"));
        email.sendKeys("admin@admin.com");
        WebElement password=driver.findElement(By.name("password"));
        password.sendKeys("admin");
        driver.findElement(By.id("js-login-btn")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement error_message=driver.findElement(By.className("notification-box-description"));
        String Error_Message_Text=error_message.getText();
        Assert.assertEquals(Error_Message_Text,"Your email, password, IP address or location did not match");
    }
    @AfterTest
    public void closeBrowser()
    {
        driver.quit();
    }
}
