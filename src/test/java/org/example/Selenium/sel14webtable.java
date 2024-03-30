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

public class sel14webtable{
    WebDriver driver;
    @BeforeTest
    public void openBrowser(){

        driver=new EdgeDriver();

    }
    @Test
    public void printwebtable() throws InterruptedException {
        driver.get("https://awesomeqa.com/webtable.html");
        driver.manage().window().maximize();
        ////table[@id="customers"]/tbody/tr[5]/td[2]/-hellen bennett
        // following-sibling::td-country
        ////table[@id='customers']/tbody/tr
        int row=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
        int column=driver.findElements(By.xpath(" //table[@id='customers']/tbody/tr[2]/td")).size();
        String firstpart="//table[@id='customers']/tbody/tr[";
        String secondpart="]/td[";
        String thirdpart="]";
        for (int i=2;i<=row;i++){
            for(int j=1;j<=column;j++)
            {
            String dynamic_xpath=firstpart+i+secondpart+j+thirdpart;
            String  data=(driver.findElement(By.xpath(dynamic_xpath))).getText();
                System.out.println(data);
                if (data.contains("Helen Bennett"))
                {
                    String country_path=dynamic_xpath+"/following-sibling::td";
                    String country_text=(driver.findElement(By.xpath(country_path))).getText();
                    System.out.println("-------------");
                    System.out.println("Hellen Bennett country is"+country_text);

                }
            }
        }
    }
    @AfterTest
    public void closeBrowser()
    {
        driver.quit();
    }
}


