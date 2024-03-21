package org.example.Selenium;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class sel04{

    @Test
    public void test() {
        EdgeDriver driver=new EdgeDriver();
        driver.get("https://app.vwo.com");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");
    }
}
