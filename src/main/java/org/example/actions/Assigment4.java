package org.example.actions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Assigment4 {
    public String driverPath = "/Users/dungdao/Documents/Setup/chromedriver/chromedriver";
    public WebDriver driver;
    @Before
    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
    }
    @Test
    public void runTestcase(){
        driver.findElement(By.cssSelector(".blinkingText")).click();
        //Using when click link and open the new tab
        Set<String> windows = driver.getWindowHandles();//parentId, childId, subchildId
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
        System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
    }
    @After
    public void endTest() {
        driver.quit();
    }
}
