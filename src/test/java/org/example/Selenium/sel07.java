package org.example.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class sel07 {
    @Test
    public void curaapp(){
        WebDriver driver=new EdgeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        //<a id="btn-make-appointment"
        // href="./profile.php#login"
        // class="btn btn-dark btn-lg">
        // Make Appointment</a>
        WebElement btn=driver.findElement(By.id("btn-make-appointment"));
       // WebElement CN=driver.findElement(By.className("btn btn-dark btn-lg"));
       // WebElement LT=driver.findElement(By.linkText("Make Appointment"));
       // WebElement PLT=driver.findElement(By.partialLinkText("Make"));
       // WebElement xpth=driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        btn.click();
        //assert the url after clicking the button https://katalon-demo-cura.herokuapp.com/profile.php#login
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/profile.php#login");
        //<input
        // type="text"
        // class="form-control"
        // id="txt-username"
        // name="username"
        // placeholder="Username"
        // value=""
        // autocomplete="off">
        WebElement UNAME=driver.findElement(By.id("txt-username"));
        UNAME.sendKeys("John Doe");
        //<input type="text"
        // class="form-control"
        // placeholder="Password"
        // aria-describedby="demo_password_label"
        // value="ThisIsNotAPassword"
        // readonly="">
        WebElement PWD=driver.findElement(By.xpath("//input[@id='txt-password']"));
        PWD.sendKeys("ThisIsNotAPassword");
        driver.findElement(By.id("btn-login")).click();
    }
}
