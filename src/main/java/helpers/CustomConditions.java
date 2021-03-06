package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;

/**
 * Created by barocko on 9/3/2016.
 */
public class CustomConditions {

    public static ExpectedCondition<Boolean> sizeOf(final By elementsLocator, final int expectedSize) {
        return new ExpectedCondition<Boolean>() {
            private int listSize;
            private List<WebElement> elements;

            public Boolean apply(WebDriver driver) {
                elements = driver.findElements(elementsLocator);
                listSize = elements.size();
                return listSize == expectedSize;
            }

            public String toString() {
                return String.format("\nsize of list: %s\n to be: %s\n while actual size is: %s\n", elements, expectedSize, listSize);
            }
        };
    }
    public static ExpectedCondition<Boolean> minimumSizeOf(final By elementsLocator, final int minimumSize){
        return new ExpectedCondition<Boolean>() {
            private int listSize;
            private List<WebElement> elements;

            public Boolean apply(WebDriver driver) {
                elements = driver.findElements(elementsLocator);
                listSize = elements.size();
                return  listSize >= minimumSize;
            }

            public String toString() {
                return String.format("\nminimum size of list: %s\n should be: %s\n but actual size is: %s\n", elements, minimumSize, listSize);
            }
        };
    }

}
