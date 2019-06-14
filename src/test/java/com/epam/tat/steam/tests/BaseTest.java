package com.epam.tat.steam.tests;

import com.epam.tat.steam.driver.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = new Driver().getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
