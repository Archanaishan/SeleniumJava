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

public class sel15webtable{
    WebDriver driver;
    @BeforeTest
    public void openBrowser(){

        driver=new EdgeDriver();

    }
    @Test
    public void printwebtable() throws InterruptedException {
        driver.get("https://awesomeqa.com/webtable1.html");
        driver.manage().window().maximize();
       WebElement table=driver.findElement(By.xpath("//table[@summary='Sample Table']/tbody"));
       List<WebElement>row_table=table.findElements(By.tagName("tr"));
        System.out.println(row_table.size());
        for(int i=0;i<row_table.size();i++){
            List<WebElement>col=table.findElements(By.tagName("td"));
            for(WebElement e:col)
            {
                System.out.println(e.getText());
            }
        }
    }
    @AfterTest
    public void closeBrowser()
    {
        driver.quit();
    }
}


