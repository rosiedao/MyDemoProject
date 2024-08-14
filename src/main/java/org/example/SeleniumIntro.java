package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumIntro {
    public static void main(String[] args) {
        //Invoke Browser
        //Chrome - ChromeDriver -> Method close
        System.setProperty("webdriver.chrome.driver","/Users/dungdao/Documents/Setup/chromedriver/chromedriver");
        WebDriver driver = new ChromeDriver();

        /**
         * Firefox Launch (geckodriver
         * webdriver.gecko.driver
         * System.setProperty("webdriver.gecko.driver","/Users/dungdao/Documents/Setup/chromedriver/chromedriver");
         * WebDriver driver = new FirefoxDriver();
         */

        /**
         * Microsoft Edge (webdriver.edge.driver)
         * WebDriver driver = new EdgeDriver();
         */
        //1. Open the url
        driver.get("https://dictionary.cambridge.org/");
        //2. Print Title of page
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.close();
        driver.quit();
    }
}
