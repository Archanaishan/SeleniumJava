package org.example.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class sel05 {
    @Test
    public void vwologin() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com");
        //<a href="https://vwo.com/free-trial/?utm_medium=website&amp;utm_source=login-page&amp;utm_campaign=mof_eg_loginpage"
        // class="text-link"
        // data-qa="bericafeqo">Start a free trial</a>
        WebElement anchor_tag=driver.findElement(By.linkText("Start a free trial"));
        System.out.println(anchor_tag.getAttribute("href"));
        anchor_tag.click();
        driver.close();
    }
}