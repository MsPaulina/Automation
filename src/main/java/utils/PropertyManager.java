package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {

    private static final Object lock = new Object();
    private static PropertyManager instance;
    private static String propertyFilePath =
            System.getProperty("user.dir") + File.separator + "GlobalConfig.properties";
    private static String mainURL;

    public static PropertyManager getInstance() {
        if (instance == null) {
            synchronized (lock) {
                instance = new PropertyManager();
                instance.loadData();
            }
        }
        return instance;
    }

    public String getMainURL() {
        return mainURL;
    }

    private void loadData() {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(propertyFilePath));
        } catch (IOException ignored) {
        }

        mainURL = prop.getProperty("URL");
    }
}
