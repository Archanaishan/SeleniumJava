package org.example.Selenium;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class sel02 {
    public static void main(String[] args) {
        EdgeOptions edgeOptions=new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver=new EdgeDriver();
        driver.get("https://youtube.com");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
