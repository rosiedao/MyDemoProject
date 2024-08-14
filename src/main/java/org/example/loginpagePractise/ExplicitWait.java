package org.example.loginpagePractise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class ExplicitWait {
    public WebDriver driver;
    By txtUsername = By.id("username");
    By txtPassword = By.id("password");
    By radioBtnUserType = By.id("usertype");
    By select = By.cssSelector("select.form-control");
    By checkboxTerm = By.id("terms");
    By btnSignIn = By.id("signInBtn");
    By cardTitle = By.cssSelector("h4.card-title");
    By btnAdd = By.cssSelector("button.btn.btn-info");
    By labelHome = By.xpath("//a[contains(text(),'ProtoCommerce Home')]");
    By btnOkay = By.id("okayBtn");

    @BeforeTest
    public void startBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
        driver = new ChromeDriver(option);
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
    }

    @Test
    public void login(){
        WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofMillis(7000));
        driver.findElement(txtUsername).sendKeys("rahulshettyacademy");
        driver.findElement(txtPassword).sendKeys("learning");
        driver.findElement(radioBtnUserType).click();
        System.out.println(driver.findElement(radioBtnUserType).isSelected());
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(btnOkay));
        System.out.println(driver.findElement(btnOkay).isDisplayed());
        driver.findElement(btnOkay).click();
        Select select1 = new Select(driver.findElement(select));
        select1.selectByValue("Stud");
        driver.findElement(checkboxTerm).click();
        driver.findElement(btnSignIn).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(labelHome));
    }

    public void selectItems(){
        List<String> neededItems = Arrays.asList("iphone X", "Samsung Note 8","Nokia Edge");
        List<WebElement> products = driver.findElements(cardTitle);
        for(int i = 0; i< products.size(); i++){
            System.out.println(products.get(i).getText());
            if(neededItems.contains(products.get(i).getText())){
                driver.findElements(btnAdd).get(i).click();
            }
        }
    }

    @AfterTest
    public void endTest() {
        driver.quit();
    }
}
