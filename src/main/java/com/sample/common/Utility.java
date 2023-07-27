package com.sample.common;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
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
    private static AndroidDriver androidDriver;
    private static AndroidDriver androidDriver_1;
    private static IOSDriver iosDriver;
    private static IOSDriver iosDriver_1;
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
                /*DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("udid", Utility.getFrameWorkProp("1_udid"));
                capabilities.setCapability("systemPort", Integer.parseInt(Utility.getFrameWorkProp("1_systemPort")));
                capabilities.setCapability("newCommandTimeout", Integer.parseInt(Utility.getFrameWorkProp("1_newCommandTimeout")));
                capabilities.setCapability("deviceName", Utility.getFrameWorkProp("1_deviceName"));
                capabilities.setCapability("platformName", Utility.getFrameWorkProp("1_platformName"));
                capabilities.setCapability(CapabilityType.VERSION, Utility.getFrameWorkProp("1_capabilityType.VERSION"));
                capabilities.setCapability("noReset", Utility.getFrameWorkProp("1_noReset"));
                capabilities.setCapability("appPackage", Utility.getFrameWorkProp("1_appPackage"));
                capabilities.setCapability("appActivity", Utility.getFrameWorkProp("1_appActivity"));*/
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("pCloudy_Username", "pastethevaluehere");
                capabilities.setCapability("pCloudy_ApiKey", "pastethevaluehere");
                capabilities.setCapability("pCloudy_DurationInMinutes", 10);
                capabilities.setCapability("newCommandTimeout", 600);
                capabilities.setCapability("launchTimeout", 90000);
                //capabilities.setCapability("pCloudy_DeviceManafacturer", "Samsung");
                capabilities.setCapability("pCloudy_DeviceFullName", "GOOGLE_Pixel7_Android_13.0.0_81870");
                capabilities.setCapability("platformVersion", "13.0.0");
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("automationName", "uiautomator2");
                capabilities.setCapability("pCloudy_ApplicationName", "Automation.apk");
                capabilities.setCapability("appPackage", "com.dgotlieb.automationsample");
                capabilities.setCapability("appActivity", "com.dgotlieb.automationsample.MainActivity");
                capabilities.setCapability("pCloudy_WildNet", "false");
                capabilities.setCapability("pCloudy_EnableVideo", "true");
                capabilities.setCapability("pCloudy_EnablePerformanceData", "true");
                capabilities.setCapability("pCloudy_EnableDeviceLogs", "true");
                androidDriver_1 = new AndroidDriver(new URL(Utility.getFrameWorkProp("1_URL")), capabilities);
                Log.info("Setup android driver - success ------------>");
            } catch (Exception e) {
                Log.info("Setup android driver - fail ------------>" + e.getMessage());
            }

        }
    }

    public static void setIosDriver(String environment) throws MalformedURLException {
        if (environment == "device_1") {
            try {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("pCloudy_Username", "pastethevaluehere");
                capabilities.setCapability("pCloudy_ApiKey", "pastethevaluehere");
                capabilities.setCapability("pCloudy_DurationInMinutes", 10);
                capabilities.setCapability("newCommandTimeout", 600);
                capabilities.setCapability("launchTimeout", 90000);
                //capabilities.setCapability("pCloudy_DeviceFullName", "APPLE_iPhone11_iOS_15.0.2_4414a");
                //capabilities.setCapability("platformVersion", "15.0.0");
                capabilities.setCapability("pCloudy_DeviceManafacturer", "Apple");
                capabilities.setCapability("platformName", "ios");
                capabilities.setCapability("acceptAlerts", true);
                capabilities.setCapability("automationName", "XCUITest");
                capabilities.setCapability("pCloudy_ApplicationName", "pCloudy_Appium_Demo_Resigned1679652693.ipa");
                capabilities.setCapability("bundleId", "com.pcloudy.TestmunkDemo");
                capabilities.setCapability("pCloudy_WildNet", "false");
                capabilities.setCapability("pCloudy_EnableVideo", "true");
                capabilities.setCapability("pCloudy_EnablePerformanceData", "true");
                capabilities.setCapability("pCloudy_EnableDeviceLogs", "false");
                iosDriver_1 = new IOSDriver(new URL(Utility.getFrameWorkProp("1_URL")), capabilities);
                Log.info("Setup ios driver - success ------------>");
            } catch (Exception e) {
                Log.info("Setup ios driver - fail ------------>" + e.getMessage());
            }

        }
    }

    public static AndroidDriver getAndroidDriver() {
        androidDriver = androidDriver_1;
        return androidDriver;
    }

    public static IOSDriver getIsoDriver() {
        iosDriver = iosDriver_1;
        return iosDriver;
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
            iosDriver_1.quit();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
