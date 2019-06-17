package com.epam.tat.steam.pages;

import com.epam.tat.steam.driver.Waiter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseActions {
    private final Logger LOGGER = LogManager.getLogger();
    protected final WebDriver driver;

    protected BaseActions(WebDriver driver) {
        LOGGER.info("Get WebDriver ");
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void logWaitAndClickElement(WebDriver driver, WebElement webElement) {
        LOGGER.info("Wait until element " + webElement + " to be clickable and click");
        Waiter.waitUntilClickable(driver, webElement);
        webElement.click();
    }

    protected void writeText(WebElement webElement, String text) {
        LOGGER.info("Write text in element " + webElement);
        webElement.sendKeys(text);
    }

    protected String readText(WebElement webElement) {
        LOGGER.info("Get text from element " + webElement);
        return webElement.getText();

    }

    protected String readAttribute(WebElement webElement, String attribute) {
        LOGGER.info("Get attribute " + attribute + " from element " + webElement);
        return webElement.getAttribute(attribute);
    }

    protected void switchToDefaulFrame() {
        LOGGER.info("Switch to default frame");
        driver.switchTo().defaultContent();
    }

    protected void openNewTab() {
        LOGGER.info("Open new tab");
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }

    protected void tabSwitchPreviousTab() {
        LOGGER.info("Switch to previous tab");
        ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 2));
    }

    protected void moveToElement(WebElement webElement) {
        LOGGER.info("Move to element " + webElement);
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).perform();
    }

    private void chooseOptionFromDropDownByPropertyEquals(List<WebElement> webElementsList, String option) {
        LOGGER.info("Choose equal " + option + " option from drop down menu");
        for (WebElement webElement : webElementsList) {
            moveToElement(webElement);
            if (webElement.getText().equals(option)) {
                webElement.click();
                break;
            }
        }
    }

    private void chooseOptionFromDropDownByPropertyContains(List<WebElement> webElementList, String option) {
        LOGGER.info("Choose option that contains " + option + " from drop down menu");
        for (WebElement webElement : webElementList) {
            moveToElement(webElement);
            if (webElement.getText().contains(option)) {
                webElement.click();
                break;
            }
        }
    }
}
