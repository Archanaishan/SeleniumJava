import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class sel11wait {
    WebDriver driver;
    @BeforeTest
    public void openBrowser(){

        driver=new EdgeDriver();

    }
    @Test
    public void loginpositive(){
        driver.get("https://app.vwo.com/#/login");
        driver.manage().window().maximize();
        WebElement email=driver.findElement(By.id("login-username"));
        email.sendKeys("contact+atb5x@thetestingacademy.com");
        WebElement password=driver.findElement(By.name("password"));
        password.sendKeys("ATBx@1234");
        driver.findElement(By.id("js-login-btn")).click();
        //try {
        //   Thread.sleep(20000);
        // } catch (InterruptedException e) {
        //    throw new RuntimeException(e);
        // }
        //WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30000));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-qa='lufexuloga']")));
        //WebElement dashboard=driver.findElement(By.cssSelector("[data-qa='lufexuloga']"));
        //System.out.println("Header Text is->" +dashboard.getText());
        Wait<WebDriver> wait=new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-qa='lufexuloga']")));
        WebElement dashboard=driver.findElement(By.cssSelector("[data-qa='lufexuloga']"));
        System.out.println("Header Text is->" +dashboard.getText());

    }
    @AfterTest
    public void closeBrowser()
    {
        driver.quit();
    }
}
