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

    protected void logWaitAndClickElement(WebDriver driver, WebElement elementAttr) {
        LOGGER.info("Wait until element " + elementAttr + " to be clickable and click");
        Waiter.waitUntilClickable(driver, elementAttr);
        elementAttr.click();
    }

    protected <T> void writeText(T elementAttr, String text) {
        LOGGER.info("Write text in element " + elementAttr);
        ((WebElement) elementAttr).sendKeys(text);
    }

    protected <T> String readText(T elementAttr) {
        LOGGER.info("Get text from element " + elementAttr);
        return ((WebElement) elementAttr).getText();

    }

    protected <T> String readAttribute(T elementAttr, String attribute) {
        LOGGER.info("Get attribute " + attribute + " from element " + elementAttr);
        return ((WebElement) elementAttr).getAttribute(attribute);
    }

    protected void switchToDefaulFrame(){
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

    protected void moveToElement(WebElement element) {
        LOGGER.info("Move to element " + element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
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

    private void chooseOptionFromDropDownBPropertyContains(List<WebElement> webElementList, String option) {
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
