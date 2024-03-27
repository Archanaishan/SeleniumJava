package org.example.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class sel10wait {
    WebDriver driver;
    @BeforeTest
    public void openBrowser(){

        driver=new EdgeDriver();

    }
    @Test
    public void loginpositive(){
        driver.get("https://app.vwo.com/#/login");
        driver.manage().window().maximize();
        WebElement email=driver.findElement(By.id("login-username"));
        email.sendKeys("contact+atb5x@thetestingacademy.com");
        WebElement password=driver.findElement(By.name("password"));
        password.sendKeys("ATBx@1234");
        driver.findElement(By.id("js-login-btn")).click();
        //try {
         //   Thread.sleep(20000);
       // } catch (InterruptedException e) {
        //    throw new RuntimeException(e);
       // }
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30000));
        //WebElement dashboard=driver.findElement(By.cssSelector("[data-qa='lufexuloga']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-qa='lufexuloga']")));
        WebElement dashboard=driver.findElement(By.cssSelector("[data-qa='lufexuloga']"));
        System.out.println("Header Text is->" +dashboard.getText());


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
        WebElement error_message=driver.findElement(By.className("notification-box-description"));
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3000));
        wait.until(ExpectedConditions.textToBePresentInElement(error_message,"Your email, password, IP address or location did not match" ));
        String Error_Message_Text=error_message.getText();
        Assert.assertEquals(Error_Message_Text,"Your email, password, IP address or location did not match");
    }@AfterTest
    public void closeBrowser()
    {
        driver.quit();
    }
}
