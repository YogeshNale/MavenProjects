package com.yogesh.test;

import com.yogesh.pageLayer.TestBase;
import com.yogesh.utils.CaptureScreenShot;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

public class testClass extends TestBase {

    public testClass() {
        PageFactory.initElements(driver, this);
    }

    @Test
    public void test() {
        System.out.println("Browser Lunch");
        log.info("URL open on browser");


    }
}


