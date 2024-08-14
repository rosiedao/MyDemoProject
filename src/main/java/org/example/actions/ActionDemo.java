package org.example.actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionDemo {
    public String driverPath = "/Users/dungdao/Documents/Setup/chromedriver/chromedriver";
    public WebDriver driver;
    @BeforeTest
    public void startBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.get("https://www.lifehack.org/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
    }
    @Test
    public void runTestcase(){
        Actions a = new Actions(driver);
        //Move to a specific element
        a.moveToElement(driver.findElement(By.linkText("Start Here"))).build().perform();
        // How to perform right click
        a.moveToElement(driver.findElement(By.linkText("The Time Flow System"))).contextClick().build().perform();
        // How to enter text "Hello" in capital letters
        /**
         * a.moveToElement(driver.findElement(element)).keyDown(Keys.SHIFT).sendKeys("Hello").build().perform();
         */

    }
    @AfterTest
    public void endTest() {
        driver.quit();
    }
}
