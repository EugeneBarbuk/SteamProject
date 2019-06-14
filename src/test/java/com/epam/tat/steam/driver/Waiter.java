package com.epam.tat.steam.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Waiter {

    private static final int WAIT_TIME = 10;

    public static void waitUntilClickable(WebDriver driver, WebElement webElement) {
        new WebDriverWait(driver, WAIT_TIME).until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void waitUntilVisibilityOfElement(WebDriver driver, WebElement webElement) {
        new WebDriverWait(driver, WAIT_TIME).until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitListElementVisible(WebDriver driver, List<WebElement> webElements) {
        waitUntilVisibilityOfElement(driver, webElements.get(0));
    }
}
