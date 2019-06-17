package com.epam.tat.steam.utils;

import com.epam.tat.steam.driver.Driver;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener {
    private final Logger LOGGER = LogManager.getLogger();

    @Override
    public void onTestStart(ITestResult iTestResult) {

        LOGGER.info("Start testing");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        LOGGER.error("Step failed. See screenshots.");
        saveScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        LOGGER.info("Test finished");
    }

    private void saveScreenshot(){
        File screenCapture = ((TakesScreenshot) new Driver()
                .getDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(
                    ".//target/screenshots/"
                            +
                            ".png"));
        } catch (IOException e) {
            LOGGER.error("Failed to save screenshot: " + e.getLocalizedMessage());
        }
    }
}
