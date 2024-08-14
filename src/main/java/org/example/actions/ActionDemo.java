package org.example.actions;

import org.example.basicSelenium.AddItemsToCart;
import org.example.basicSelenium.ProceedToCheckout;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionDemo {
    public String driverPath = "/Users/dungdao/Documents/Setup/chromedriver/chromedriver";
    public WebDriver driver;
    @Before
    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
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
    @After
    public void endTest() {
        driver.quit();
    }
}
