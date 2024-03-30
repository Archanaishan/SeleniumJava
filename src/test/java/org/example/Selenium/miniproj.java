package org.example.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class miniproj {
    WebDriver driver;
    @BeforeTest
    public void openBrowser(){

        driver=new EdgeDriver();

    }
    @Test
    public void print() throws InterruptedException {
    driver.get("https://katalon-demo-cura.herokuapp.com/");
        WebElement mkap_btn=driver.findElement(By.id("btn-make-appointment"));
        mkap_btn.click();
        WebElement username=driver.findElement(By.id("txt-username"));
        WebElement password=driver.findElement(By.id("txt-password"));
        username.sendKeys("John Doe");
        password.sendKeys("ThisIsNotAPassword");
        WebElement login=driver.findElement(By.id("btn-login"));
        login.click();
        List<WebElement> facility=driver.findElements(By.xpath(" //select[@id=\"combo_facility\"]/option"));
        WebElement select=facility.get(2);
        select.click();
        WebElement chk=driver.findElement(By.id("chk_hospotal_readmission"));
        chk.click();
        List<WebElement> radio=driver.findElements(By.xpath(" //div[@class=\"col-sm-4\"]/label"));
        WebElement radio_select=radio.get(2);
        radio_select.click();
        WebElement date=driver.findElement(By.name("visit_date"));
        date.sendKeys("30/03/2024");
        WebElement comment=driver.findElement(By.id("txt_comment"));
        comment.sendKeys("Hello Automation123");

        WebElement book_apmt=driver.findElement(By.id("btn-book-appointment"));
        book_apmt.click();

        WebElement as_comment=driver.findElement(By.xpath(" //p[@id='comment']"));
        String op=as_comment.getText();
        Assert.assertEquals(op,"Hello Automation123");

    }
    @AfterTest
    public void closeBrowser()
    {
        driver.quit();
    }
}
