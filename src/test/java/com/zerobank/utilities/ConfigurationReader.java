package com.zerobank.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    //this class will be responsible for loading properties file and will provide access
    //to values based on key names
    //we use Properties class to load custom .properties files
    private static Properties configFile;
    static {
        try {
            //provides access to file
            //try/catch block stands for handling exceptions
            //if exception occurs, code inside a catch block will be executed
            FileInputStream fileInputStream = new FileInputStream("configuration.properties");
            configFile = new Properties();
            configFile.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            System.out.println("Failed to load properties file!");
            e.printStackTrace();
        }
    }
    public static String getProperty(String key) {
        return configFile.getProperty(key);
    }



}
