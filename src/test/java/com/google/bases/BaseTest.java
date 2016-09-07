package com.google.bases;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by barocko on 9/6/2016.
 */
public class BaseTest {

     public static WebDriver driver;
     public static WebDriverWait wait;

    @BeforeClass
    public static  void setup(){
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
