package org.example;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class tc_002 {
    @Test
    @Description("Verify the title of testing academy")
    public void login(){
        WebDriver driver=new EdgeDriver();
        //create session-box- connect with browser via HTTP methods
        //sessionid-16 alpha digits-iowure89u2jed
        driver.get("https://thetestingacademy.com");
        System.out.println(driver.getTitle());
    }
}
