package com.epam.tat.steam.service;

import com.epam.tat.steam.model.User;
import com.epam.tat.steam.utils.PropertyReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserDataCreator {
    private final Logger LOGGER = LogManager.getLogger();

    private static final String PROFILE_NAME = "user.profileName";
    private static final String NAME = "user.name";
    private static final String COUNTRY = "user.country";
    private static final String CITY = "user.city";

    public User getDataProperties() {
        LOGGER.info("Create new user with parameters from property file");
        return new User(PropertyReader.getTestData(PROFILE_NAME),
                PropertyReader.getTestData(NAME),
                PropertyReader.getTestData(COUNTRY),
                PropertyReader.getTestData(CITY));
    }
}
