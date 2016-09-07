package com.google;

import com.google.bases.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


import static helpers.CustomConditions.minimumSizeOf;
import static helpers.CustomConditions.sizeOf;
import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlToBe;

/**
 * Created by barocko on 8/17/2016.
 */
public class GoogleSearchTest extends BaseTest {

    @Test
    public void testSearch() {

        driver.get("https://google.com");

        search("Selenium automates browsers");

        assertResultsCount(10);
        wait.until(textToBePresentInElementLocated(results, "Selenium automates browsers"));
    }

    @Test
    public void testFollowLink() {

        driver.get("https://google.com");

        search("Selenium automates browsers");

        followLink(0);

        wait.until(urlToBe("http://www.seleniumhq.org/"));
    }

    By results = By.cssSelector(".srg>.g");

    public void search(String text) {
        driver.findElement(By.name("q")).sendKeys(text, Keys.ENTER);
    }

    public void assertResultsCount(int count) {
        wait.until(sizeOf(results, count));
    }

    public void followLink(int index) {
        wait.until(minimumSizeOf(results, index+1));
        driver.findElements(results).get(index).findElement(By.cssSelector("h3>a")).click();
    }
}


