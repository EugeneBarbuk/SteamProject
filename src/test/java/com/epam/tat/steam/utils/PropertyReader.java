package com.epam.tat.steam.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.spi.LoggerRegistry;

import java.util.ResourceBundle;

public class PropertyReader {

    private static final ResourceBundle dataResourceBundle = ResourceBundle.getBundle(System.getProperty("datalist"));

    public static String getTestData(String key) {
        return dataResourceBundle.getString(key);
    }

}
