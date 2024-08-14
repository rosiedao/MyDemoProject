package org.example.basicSelenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetupEnviroment {
    public String driverPath = "/Users/dungdao/Documents/Setup/chromedriver/chromedriver";
    public WebDriver driver;
    @Before
    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void runTestcase(){
        AddItemsToCart addItemsToCart = new AddItemsToCart(driver);
        ProceedToCheckout proceedToCheckout = new ProceedToCheckout(driver);
        addItemsToCart.navigateURL();
        addItemsToCart.selectItems();
        addItemsToCart.processPayment();
        proceedToCheckout.proceed();
    }
    @After
    public void endTest() {
        driver.quit();
    }
}
