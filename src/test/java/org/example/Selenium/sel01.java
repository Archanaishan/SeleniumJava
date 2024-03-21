package org.example.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class sel01 {
    public static void main(String[] args) {
        //driver.get("https://sdet.live");
        EdgeOptions edgeOptions=new EdgeOptions();
        //edgeOptions.addArguments("headless");
        WebDriver driver=new EdgeDriver();
        driver.get("https://youtube.com");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
