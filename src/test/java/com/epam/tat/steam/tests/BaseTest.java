package com.epam.tat.steam.tests;

import com.epam.tat.steam.driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public abstract class BaseTest {
    private final Logger LOGGER = LogManager.getLogger();
    private WebDriver driver;
    private SoftAssert softAssert;

    @BeforeMethod
    public void setup() {
        LOGGER.info("Create new Thread.Local WebDriver");
        softAssert = new SoftAssert();
        driver = new Driver().getDriver();

    }

    @AfterMethod
    public void tearDown() {
        LOGGER.info("Close Thread.Local WebDriver");
        driver.close();
    }
}
