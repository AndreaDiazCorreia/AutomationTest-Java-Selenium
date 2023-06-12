package com.Tests;

import com.Reports.reports;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import com.Pages.PageSearch;
import com.Pages.PageRegistro;

public class TestSearch {

    WebDriver driver;
    PageSearch pageSearch;
    PageRegistro pageRegistro;
    public ExtentReports report;
    public ExtentTest test;

    @BeforeEach
    public void setUp () throws InterruptedException
    {
        pageSearch = new PageSearch(driver);
        driver = pageSearch.chromeDriverConnection();
        pageSearch.link("https://opencart.abstracta.us/index.php?route=common/home");
        report = reports.getIntance();
        Thread.sleep(200);

        pageRegistro = new PageRegistro(null);
        pageRegistro.register();
    }

    @Test
    @Tag("TestRegresion")
    public void test() throws InterruptedException
    {
        test = report.startTest("Registro y busqueda exitosos");
        test.log(LogStatus.INFO, "Se ha iniciado el test");
        pageSearch.search();
        test.log(LogStatus.PASS, "La búsqueda se ha realizado correctamente");
    }

    @AfterEach
    public void tearDown() {
        report.endTest(test);
        report.flush();
        driver.quit();
    }


}
