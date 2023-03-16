package com.sample.test;

import com.sample.common.Log;
import com.sample.common.Utility;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.util.Map;

/*
 * Before and After methods
 */

public class BaseTest {

    public static Map<Integer, Object[]> TestNGResults;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuiteMethod() throws MalformedURLException, Exception {
        try {
            DOMConfigurator.configure("log4j.xml");
            Utility.setFrameWorkProp();
            Utility.setTestData();
            Utility.setExpectedResults();
            Utility.setCacheMap();
            System.setProperty("org.uncommons.reportng.escape-output", "false");
            Log.info("Setup test configuration success------------>");

        } catch (Exception e) {
            Log.info("Setup test configuration fail------------>" + e.getMessage());

        }

    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws InterruptedException, Exception {
        try {
            Utility.getAndroidDriver().quit();
            Log.info("Kill android driver success------------>");
        } catch (Exception e) {
            Log.info("Kill android driver fail------------>" + e.getMessage());
        }

    }
}