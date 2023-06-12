package com.Pages;

import com.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Random;

public class PageRegistro extends BasePage {




    By buttonMiCuenta = By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a");
    By buttonRegistrarme = By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a");
    By nombre = By.name("firstname");
    By apellido = By.name("lastname");
    By correo = By.name("email");
    By telefono = By.name("telephone");
    By contrasena = By.name("password");
    By ccontrasena = By.xpath("//*[@id=\"input-confirm\"]");
    //By buttonSuscribe = By.cssSelector("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input");
    By buttonPolitica = By.xpath("//*[@id=\"content\"]/form/div/div/input[1]");
    By buttonContinuar = By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");
    By resultado = By.xpath("//*[@id=\"content\"]/p[1]");


    public PageRegistro(WebDriver driver) { super();}

    public void register () throws InterruptedException {
        oprimir(buttonMiCuenta);
        Thread.sleep(2000);
        oprimir(buttonRegistrarme);
        Thread.sleep(2000);
        teclear("testName", nombre);
        Thread.sleep(2000);
        teclear("testApellido", apellido);
        Thread.sleep(2000);
        // genera un correo nuevo cada vez que se ejecuta el test
        Random random = new Random();
        int numeroAleatorio = random.nextInt(10000);
        String correoElectronico = "test" + numeroAleatorio + "@gmail.com";
        teclear(correoElectronico, correo);

        Thread.sleep(2000);
        teclear("123456789", telefono);
        Thread.sleep(2000);
        teclear("Test12345", contrasena);
        Thread.sleep(2000);
        teclear("Test12345", ccontrasena);
        Thread.sleep(2000);
        //oprimir(buttonSuscribe);
        //Thread.sleep(2000);
        oprimir(buttonPolitica);
        Thread.sleep(2000);
        oprimir(buttonContinuar);
        Thread.sleep(2000);
        comparar(resultado, "Congratulations! Your new account has been successfully created!");
        Thread.sleep(2000);

    }

    public void registerfail() throws InterruptedException {
        oprimir(buttonMiCuenta);
        Thread.sleep(2000);
        oprimir(buttonRegistrarme);
        teclear("testName", nombre);
        Thread.sleep(2000);
        teclear("testApellido", apellido);
        Thread.sleep(2000);
        teclear("test@gmail.com", correo);
        Thread.sleep(2000);
        teclear("123456789", telefono);
        Thread.sleep(2000);
        teclear("Test12345", contrasena);
        Thread.sleep(2000);
        teclear("Juani123", ccontrasena);
        Thread.sleep(2000);
        oprimir(buttonPolitica);
        Thread.sleep(2000);
        oprimir(buttonContinuar);
        Thread.sleep(2000);
    }

}
