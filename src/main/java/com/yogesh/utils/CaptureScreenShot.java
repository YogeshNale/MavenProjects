package com.yogesh.utils;

import com.yogesh.pageLayer.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class CaptureScreenShot extends TestBase {

    public static String getCurrentDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd-HH-mm-ss");
        Date date = new Date();
        return dateFormat.format(date);

    }
    public static String captureScreenShot(String fileName) {

        String destination = System.getProperty("user.dir")+"\\src\\test\\resources\\"+CaptureScreenShot.getCurrentDateTime()+"-"+fileName+".png"; ;
        TakesScreenshot screenShot = (TakesScreenshot) driver;
        File srcFile = screenShot.getScreenshotAs(OutputType.FILE);
        try {
            File destFile = new File(destination);
            FileUtils.copyFile(srcFile, destFile);
        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return destination;
    }
}
