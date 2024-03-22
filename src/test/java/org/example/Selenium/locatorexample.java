package org.example.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class locatorexample {
    @Test
    public void vwologin() {
        WebDriver driver=new EdgeDriver();
        driver.get("https://app.vwo.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(),"Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");
        //Find the web element username.Enter the value admin in that
        //<input type="email"
        // class="text-input W(100%)"
        // name="username"
        // id="login-username"
        // data-qa="hocewoqisi">
        WebElement email=driver.findElement(By.id("login-username"));
        email.sendKeys("admin@admin.com");
        //<input type="password"
        // class="text-input W(100%)"
        // name="password"
        // id="login-password"
        // data-qa="jobodapuxe"
        // aria-autocomplete="list">
        WebElement password=driver.findElement(By.name("password"));
        password.sendKeys("admin");
        //<button type="submit"
        // id="js-login-btn"
        // class="btn btn--positive btn--inverted W(100%) H(48px) Fz(16px)"
        // onclick="login.login(event)"
        // data-qa="sibequkica">
        //<span class="icon loader hidden" data-qa="zuyezasugu"></span>
        //<span data-qa="ezazsuguuy">Sign in</span>
        //</button>
        driver.findElement(By.id("js-login-btn")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //<div class="notification-box-description"
        // id="js-notification-box-msg"
        // data-qa="rixawilomi">
        // Your email, password, IP address or location did not match
        // </div>
        WebElement error_message=driver.findElement(By.className("notification-box-description"));
        String Error_Message_Text=error_message.getText();
        Assert.assertEquals(Error_Message_Text,"Your email, password, IP address or location did not match");
        driver.quit();
    }

}
