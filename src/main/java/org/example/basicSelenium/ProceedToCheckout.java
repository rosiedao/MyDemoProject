package org.example.basicSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProceedToCheckout {
    By inputPromoCode = By.cssSelector("input.promoCode");
    By btnApply = By.xpath("//button[contains(text(),'Apply')]");
    By msgPromoInfo = By.cssSelector("span.promoInfo");
    public WebDriver driver;
    public ProceedToCheckout(WebDriver driver){
        this.driver = driver;
    }
    public void proceed(){
        driver.findElement(inputPromoCode).sendKeys("rahulshettyacademy");
        driver.findElement(btnApply).click();
        // Explicit Wait
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofMillis(5000));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(msgPromoInfo));
        System.out.println(driver.findElement(msgPromoInfo).getText());

    }
}
