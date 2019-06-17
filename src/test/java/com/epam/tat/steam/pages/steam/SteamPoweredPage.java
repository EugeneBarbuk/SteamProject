package com.epam.tat.steam.pages.steam;

import com.epam.tat.steam.pages.BaseActions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class SteamPoweredPage extends BaseActions {

    private final Logger LOGGER = LogManager.getLogger();
    private static final String STEAM_PAGE_URL = "https://store.steampowered.com";

    protected SteamPoweredPage(WebDriver driver) {
        super(driver);
    }

    public SteamPoweredPage open() {
        driver.get(STEAM_PAGE_URL);
        LOGGER.info("Main Steam page is opened.");
        return this;
    }
}
