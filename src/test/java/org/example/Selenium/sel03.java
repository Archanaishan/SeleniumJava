package org.example.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.net.URL;

public class sel03 {
    public static void main(String[] args) {
        WebDriver driver=new EdgeDriver();
        driver.get("https://bing.com");
        driver.navigate().to("https://youtube.com");
        driver.navigate().to("https://google.com");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }
}
