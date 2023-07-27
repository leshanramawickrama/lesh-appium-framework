package com.sample.test;

import com.sample.common.Utility;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import static com.sample.common.Utility.getAndroidDriver;
import static com.sample.common.Utility.getIsoDriver;


public class SampleTest extends BaseTest{

    @BeforeMethod
    public void setUpEnv() throws MalformedURLException {
        Utility.setAndroidDriver("device_1");
        Utility.setIosDriver("device_1");
    }

    @Test
    public void testSampleAndroidCode(){
        AndroidDriver driver = getAndroidDriver();
        driver.findElement(By.id("com.dgotlieb.automationsample:id/userName")).sendKeys("test");
    }

    @Test
    public void testSampleIOSCode(){
        IOSDriver driver = getIsoDriver();
    }


    @AfterTest
    public void tearDown() {
        Utility.appClose();
    }

}
