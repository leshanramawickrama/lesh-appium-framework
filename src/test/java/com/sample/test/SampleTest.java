package com.sample.test;

import com.sample.common.Utility;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static com.sample.common.Utility.getAndroidDriver;


public class SampleTest extends BaseTest{

    @BeforeMethod
    public void setUpEnv() throws MalformedURLException {
        Utility.setAndroidDriver("device_1");

    }

    @Test
    public void testSampleCode(){
        AndroidDriver driver = getAndroidDriver();
        driver.findElement(By.id("com.dgotlieb.automationsample:id/userName")).sendKeys("test");
    }


    @AfterTest
    public void tearDown() {
        Utility.appClose();
    }

}
