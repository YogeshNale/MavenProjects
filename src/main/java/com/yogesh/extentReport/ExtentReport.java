package com.yogesh.extentReport;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.yogesh.pageLayer.TestBase;
import com.yogesh.utils.CaptureScreenShot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ExtentReport extends TestBase implements ITestListener {

    private ExtentReports extent;
    private ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.startTest(result.getName());
        log.info("Execution of " + result.getName() + " start");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(LogStatus.PASS, result.getName());
        log.info("Test Scenario " + result.getName() + " passed");
    }


    @Override
    public void onTestFailure(ITestResult result) {
        String capturedScreenShotPath = CaptureScreenShot.captureScreenShot(result.getName());
        String imagePath = test.addScreenCapture(capturedScreenShotPath);
        test.log(LogStatus.FAIL, result.getName(),imagePath);
        log.info("Test Scenario " + result.getName() + " failed");

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(LogStatus.SKIP, result.getName());
        log.info("Test Scenario " + result.getName() + " skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

        extent = new ExtentReports("F:/MavenProject/target/extent-report.html", true);
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.endTest(test);
        extent.flush();
        extent.close();
    }
}
