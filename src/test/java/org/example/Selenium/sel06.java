package org.example.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import java.util.List;

public class sel06 {
    @Test
    public void vwologin() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com");
        //<a href="https://vwo.com/free-trial/?utm_medium=website&amp;utm_source=login-page&amp;utm_campaign=mof_eg_loginpage"
        // class="text-link"
        // data-qa="bericafeqo">Start a free trial</a>
        List<WebElement> anchor_tag=driver.findElements(By.tagName("a"));
        //anchor_tag.get(0).click();
       // anchor_tag.get(1).click();
        for(WebElement element:anchor_tag)
        {
            System.out.println(element.getText());
        }
        driver.close();
    }
}
