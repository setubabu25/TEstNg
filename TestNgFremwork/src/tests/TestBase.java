package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class TestBase {
    public static Properties CONFIG = null;
    public static WebDriver dr = null;
    public static EventFiringWebDriver driver = null;
    public static Properties OR = null;


    //Method for verify initialize

    public static void initialize() throws IOException {


        if (driver == null) {
            //load Config property file

            CONFIG = new Properties();

            FileInputStream fsi = new FileInputStream(System.getProperty("user.dir") + "//src//config//config.properties");
            CONFIG.load(fsi); //Load Config.property file

            //Load OR Property File
            OR = new Properties();
            FileInputStream fsi2 = new FileInputStream(System.getProperty("user.dir") + "//src//config//OR.Properties");
            OR.load(fsi2); //Load Config.property file



            //Initialize the browser

            if (CONFIG.getProperty("browser").equals("Firefox")) {
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\Md Rashid\\Desktop\\geckodriver.exe");
                dr = new FirefoxDriver();



            } else if (CONFIG.getProperty("browser").equals("Chorme")) {
                System.setProperty("webdriver.chorme.driver", "C:\\Users\\Md Rashid\\Desktop\\chromedriver.exe");
                dr = new ChromeDriver();



            } else if (CONFIG.getProperty("browser").equals("IE")) {
                System.out.println("We are not Testing this with IE");
                driver = new EventFiringWebDriver(dr);
                driver.manage().window().maximize();
            }

            driver = new EventFiringWebDriver(dr);
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        }


    }




    //method 1;click obj by id
    public void clickObjectById(String objLoc) {

        try {
            WebElement objWe = driver.findElement(By.id(OR.getProperty(objLoc)));
            objWe.click();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        } catch (Throwable t) {
            t.getCause();
        }


    }
    //method 2;Editobj by id	

    public void editObjectById(String objLoc, String objData) {

        try {
            //driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
            WebElement objWe = driver.findElement(By.id(OR.getProperty(objLoc)));
            objWe.clear();
            objWe.sendKeys(objData);
        } catch (Throwable t) {
            t.getLocalizedMessage();


        }
    }

    //method 3;select obj by id
    public void selectObjectById(String objLoc, String objData) {

        try {
            //driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
            WebElement objWe = driver.findElement(By.id(OR.getProperty(objLoc)));
            objWe.clear();
            objWe.sendKeys(objData);
        } catch (Throwable t) {
            t.getLocalizedMessage();



        }
    }
    //method 1;click obj by xpath
    public void clickObjectByxpath(String objLoc) {

        try {
            //driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
            WebElement objWe = driver.findElement(By.xpath(OR.getProperty(objLoc)));
            objWe.click();
            driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        } catch (Throwable t) {
            t.getCause();
        }


    }


    //Method for taking Screenshot
    public void getScreenshots(String tcName) throws IOException {


        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        DateFormat df = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date date = new Date();
        String dfp = df.format(date);
        FileUtils.copyFile(scrFile, new File(CONFIG.getProperty("screenShotPath") + tcName + dfp + "test.png"));




    }

    //method 3;select obj by id
    public void editObjectByxpath(String objLoc, String objData) {

        try {
            //driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
            WebElement objWe = driver.findElement(By.xpath(OR.getProperty(objLoc)));
            objWe.clear();
            objWe.sendKeys(objData);
        } catch (Throwable t) {
            t.getLocalizedMessage();



        }

    }
}