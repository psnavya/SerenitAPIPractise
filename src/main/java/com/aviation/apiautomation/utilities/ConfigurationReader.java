package com.aviation.apiautomation.utilities;
import com.aviation.apiautomation.helpers.KeyHelper;

import java.io.*;
import java.util.Properties;

public class ConfigurationReader {
    static FileReader reader;
    private ConfigurationReader() {

    }
    static Properties p=new Properties();

    public static String getPropertyValue(String key) throws IOException {
        loadFile("/Users/kavyaps/Intellij Projects/LeaseDigitalAPIAutomation/src/test/Config.properties");
        p.getProperty(key);
        return p.getProperty(key)+"?access_key="+p.getProperty(KeyHelper.KEY_HELPER_VALID_KEY.getKey());
    }

    private static void loadFile(String path) throws IOException {
        reader = new FileReader(path);
        p.load(reader);
    }
}
