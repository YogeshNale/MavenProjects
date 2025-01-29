package com.yogesh.pageLayer;

import com.yogesh.utils.ReadExcelData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.logging.Logger;


public class TestBase {

    public static WebDriver driver;
    public static Logger log=null;
//another some changes
    // code for create pull request
    
    //some changes done in development1 branch

    @Parameters({"Br", "URL"})

    @BeforeTest
    public void setUp(String br, String url) {

       log= Logger.getLogger(this.getClass().getName());
        try {
            switch (br) {
                case "Chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                   log.info("Chrome Browser Launched Success.");
                    break;
                case "Firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    log.info("FireFox; Browser Launched Successfully.");
                    break;
                case "Edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    log.info("Edge Browser Launched Successfully.");
                    break;
                default:
                    System.out.println("Invalid Browser");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(url);


    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
