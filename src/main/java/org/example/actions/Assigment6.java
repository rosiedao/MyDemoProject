package org.example.actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class Assigment6 {
    public WebDriver driver;
    public By ckbOption1 = By.id("checkBoxOption1");
    public By label = By.xpath("//label[@for='bmw']");
    public By dropdown = By.id("dropdown-class-example");
    public By textbox = By.id("name");
    public By btnAlert = By.id("alertbtn");
    @BeforeTest
    public void startBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
    }
    @Test
    public void runTestcase(){
        String input = "";
        driver.findElement(ckbOption1).click();
        if(driver.findElement(ckbOption1).isSelected()){
            input = driver.findElement(label).getText();
            System.out.println(input);
            Select select = new Select(driver.findElement(dropdown));
            select.selectByVisibleText(input);
            driver.findElement(textbox).sendKeys(input);
            driver.findElement(btnAlert).click();
            String actualMsg = driver.switchTo().alert().getText();
            String expectedMsg = "Hello Option1, share this practice page and share your knowledge";
            assertEquals(expectedMsg,actualMsg);
        }
    }

    @AfterTest
    public void endTest() {
        driver.quit();
    }
}
