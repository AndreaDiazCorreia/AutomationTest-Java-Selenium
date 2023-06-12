package com.Tests;

import com.Pages.PageRegistro;
import com.Reports.reports;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class TestRegistro {
    WebDriver driver;
    PageRegistro pageRegistro;
    public ExtentReports report;
    public ExtentTest test;

    @BeforeEach

    public void setUp () throws InterruptedException {
        pageRegistro = new PageRegistro(driver);
        driver = pageRegistro.chromeDriverConnection();
        pageRegistro.link("https://opencart.abstracta.us/index.php?route=common/home");
        report = reports.getIntance();
        Thread.sleep(200);

    }
    @AfterEach
    public void tearDown (){
        report.endTest(test);
        report.flush();
        driver.quit();
    }
    @Test
    @Tag("TestRegresion")
    public void test01 () throws InterruptedException {
        test = report.startTest("Registro exitoso");
        test.log(LogStatus.INFO, "Se ha iniciado el test");
        pageRegistro.register();
        test.log(LogStatus.PASS, "El test ha finalizado exitosamente");
    }
    @Test
    @Tag("TestRegresion")
    public void test02 () throws InterruptedException {
        test = report.startTest("Registro con correo ya registrado");
        test.log(LogStatus.INFO, "Se ha iniciado el test");
        pageRegistro.registerfail();
        test.log(LogStatus.PASS, "El test ha finalizado exitosamente");
    }



}
