package com.sample.common;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Utility {
    private static AndroidDriver driver;
    private static AndroidDriver driver_1;
    private static Utility utility;
    private static Properties uiProp;
    private static Properties expectedResults;
    private static Properties testData;
    private static Map<Object, Object> cacheMap;

    public static final Utility getInstance() {
        if (utility == null) {
            utility = new Utility();
        }
        return utility;
    }

    public static void setAndroidDriver(String environment) throws MalformedURLException {
        if (environment == "device_1") {
            try {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("udid", Utility.getFrameWorkProp("1_udid"));
                capabilities.setCapability("systemPort", Integer.parseInt(Utility.getFrameWorkProp("1_systemPort")));
                capabilities.setCapability("newCommandTimeout", Integer.parseInt(Utility.getFrameWorkProp("1_newCommandTimeout")));
                capabilities.setCapability("deviceName", Utility.getFrameWorkProp("1_deviceName"));
                capabilities.setCapability("platformName", Utility.getFrameWorkProp("1_platformName"));
                capabilities.setCapability(CapabilityType.VERSION, Utility.getFrameWorkProp("1_capabilityType.VERSION"));
                capabilities.setCapability("noReset", Utility.getFrameWorkProp("1_noReset"));
                capabilities.setCapability("appPackage", Utility.getFrameWorkProp("1_appPackage"));
                capabilities.setCapability("appActivity", Utility.getFrameWorkProp("1_appActivity"));
                driver_1 = new AndroidDriver(new URL(Utility.getFrameWorkProp("1_URL")), capabilities);
                Log.info("Setup android driver - success ------------>");
            } catch (Exception e) {
                Log.info("Setup android driver - fail ------------>" + e.getMessage());
            }

        }
    }

    public static AndroidDriver getAndroidDriver() {
        driver = driver_1;
        return driver;
    }

    public static String getFrameWorkProp(String key) {
        return uiProp.getProperty(key);
    }

    public static void setFrameWorkProp() {

        uiProp = new Properties();
        try {
            uiProp.load(new FileInputStream("src/test/resources/properties/System.properties"));
            Log.info("Initialize FrameWork Property file - success ------------>");
        } catch (IOException e) {
            Log.info("Initialize FrameWork Property file - fail ------------>" + e.getMessage());
        }

    }

    public static void setTestData() {

        testData = new Properties();
        try {
            testData.load(new FileInputStream("src/test/resources/TestData/testData.properties"));
            Log.info("Initialize TestData Property file - success ------------>");
        } catch (IOException e) {
            Log.info("Initialize TestData Property file - fail ------------>" + e.getMessage());
        }

    }

    public static String getTestData(String key) {
        return testData.getProperty(key);
    }

    public static String getExpectedResults(String key) {
        return expectedResults.getProperty(key);
    }

    public static void setExpectedResults() {

        expectedResults = new Properties();
        try {
            expectedResults.load(new FileInputStream("src/test/resources/TestData/expectedResults.properties"));
            Log.info("Initialize ExpectedResults Property file - success ------------>");
        } catch (IOException e) {
            Log.info("Initialize ExpectedResults Property file - fail ------------>" + e.getMessage());
        }

    }

    public static void setCacheMap() {
        cacheMap = new HashMap<Object, Object>();
    }

    public static void appClose() {
        try {
            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
