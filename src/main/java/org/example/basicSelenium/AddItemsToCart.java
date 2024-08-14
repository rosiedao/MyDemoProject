package org.example.basicSelenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AddItemsToCart {
    //public String driverPath = "/Users/dungdao/Documents/Setup/chromedriver/chromedriver";
    public WebDriver driver;
    By productList = By.cssSelector("h4.product-name");
    By btnAddToCart = By.xpath("//button[text()='ADD TO CART']");
    By noOfAddedItem = By.xpath("//div[@class='cart-info']//tr[1]/td[3]");
    By imgCart = By.xpath("//img[@alt='Cart']");
    By btnProceedToCheckout = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
    public AddItemsToCart(WebDriver driver){
        this.driver = driver;
    }

    public void navigateURL(){
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
    }

    public void selectItems(){
        List<String> neededItems = Arrays.asList("Cucumber", "Brocolli","Beetroot");
        List<WebElement> products = driver.findElements(productList);
        for(int i = 0; i< products.size(); i++){
            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();
            if(neededItems.contains(formattedName)){
                driver.findElements(btnAddToCart).get(i).click();
            }
        }
        assertEquals("3", driver.findElement(noOfAddedItem).getText());
    }
    public void processPayment(){
        driver.findElement(imgCart).click();
        if(driver.findElement(btnProceedToCheckout).isDisplayed()){
            driver.findElement(btnProceedToCheckout).click();
        }
    }
}
