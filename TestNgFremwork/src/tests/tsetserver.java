package tests;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeMethod;

public class tsetserver extends TestBase {


    @BeforeMethod
    public void beforeMethod() throws IOException {


        initialize();
        driver.get(CONFIG.getProperty("testSiteURL"));


    }

    @Test(enabled = false)
    public void testjobSerch() throws IOException {
        getScreenshots("JobServeHomePAge");
        clickObjectById("IdJobsch");
        editObjectById("IdKeyword", "Qa Analist");
        editObjectById("IdLocation", "New York");
        clickObjectById("IdSchButton");
        getScreenshots("SearchResult");


    }


    @Test(priority = 2)
    public void testjobSeeker() throws IOException {

        clickObjectByxpath("xpJobSeeker");
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        clickObjectByxpath("xpIndustry");

        clickObjectByxpath("XPDeSelectall");

        clickObjectByxpath("xpSelectIT");
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        editObjectById("IdSkKEy", "Qa Analist");
        editObjectById("IdSkLoc", "Washighton DC");

        clickObjectById("btnSearch");
        getScreenshots("jobSekerResult");




    }




}