package org.example.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class sel09 {
    WebDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions options=new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver=new EdgeDriver(options);
    }
    @Test
    public void searchmacmini()
    {
        driver.get("https://www.ebay.com/b/Desktops-All-In-One-Computers/171957/bn_1643067");
        driver.manage().window().maximize();
        WebElement inputbox=driver.findElement(By.xpath("//input[@id='gh-ac']"));
        inputbox.sendKeys("Macmini");
        WebElement searchbox=driver.findElement(By.xpath("//input[@id='gh-btn']"));
        searchbox.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //<div class="s-item__title">
        // <span role="heading" aria-level="3">
        // <!--F#f_0-->Apple Mac Mini M2 8GB RAM 256GB SSD Desktop - Silver (MMFJ3LL/A)<!--F/--></span></div>
        List<WebElement>macmini=driver.findElements(By.xpath("//div[@class='s-item__title']"));
        for(WebElement e:macmini){
            System.out.println(e.getText());
        }

    }

    @AfterTest
    public void closeBrowser()
    {
        driver.quit();
    }
}
