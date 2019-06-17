package com.epam.tat.steam.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {
    private final Logger LOGGER = LogManager.getLogger();
    public ThreadLocal<RemoteWebDriver> driver = null;

    public WebDriver getDriver() {
        if (driver == null) {
            switch (System.getProperty("browser")) {
                case "opera" -> {
                    WebDriverManager.operadriver().setup();
                    LOGGER.info("Set up driver for Opera");
                }
                case "firefox" -> {
                    WebDriverManager.firefoxdriver().setup();
                    LOGGER.info("Set up driver for FireFox");
                }
                case "edge" -> {
                    WebDriverManager.edgedriver().setup();
                    LOGGER.info("Set up driver for Edge");
                }
                default -> {
                    ChromeOptions options = new ChromeOptions();
                    options.setCapability("platformName", Platform.WINDOWS);
                    WebDriverManager.chromedriver().setup();
                    try {
                        driver = new ThreadLocal<>();
                        driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options));
                        LOGGER.info("Set up driver for Chrome");
                    } catch (MalformedURLException e) {
                        LOGGER.error("Error getting driver for Chrome" + e);
                    }
                }
            }
            driver.get().manage().window().maximize();
        }
        return driver.get();
    }

    public void closeDriver() {
        driver.get().quit();
        LOGGER.info("Close driver");
        driver = null;
    }
}
