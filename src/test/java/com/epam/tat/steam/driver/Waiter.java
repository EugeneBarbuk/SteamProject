package com.epam.tat.steam.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Waiter {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final int WAIT_TIME_SECONDS = 10;

    public static void waitUntilSwitch(WebDriver driver, String webElement) {
        LOGGER.info("Wait frame " + webElement + " and switch to it");
        new WebDriverWait(driver, WAIT_TIME_SECONDS).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(webElement));
    }

    public static void waitUntilClickable(WebDriver driver, WebElement webElement) {
        new WebDriverWait(driver, WAIT_TIME_SECONDS).until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void waitUntilVisibilityOfElement(WebDriver driver, WebElement webElement) {
        new WebDriverWait(driver, WAIT_TIME_SECONDS).until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitListElementVisible(WebDriver driver, List<WebElement> webElements) {
        waitUntilVisibilityOfElement(driver, webElements.get(0));
    }
}
