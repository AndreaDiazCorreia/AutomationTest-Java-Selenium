package com.Pages;

import com.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageSearch extends BasePage {

	By searchBox = By.xpath("//*[@id=\"search\"]/input");
	By bottonSearch = By.xpath("//*[@id=\"search\"]/span/button");
	By resultado = By.xpath("//*[@id=\"content\"]");
	By agregarCarrito = By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[1]");
	By resultadoCarrito = By.xpath("//*[@id=\"product-search\"]/div[1]");

	public PageSearch(WebDriver driver) {

	}

	public void search () throws InterruptedException {
		teclear("Iphone", searchBox);
		Thread.sleep(2000);
		//tecla(searchBox, "ENTER");
		//Thread.sleep(2000);
		oprimir(bottonSearch);
		Thread.sleep(2000);
		oprimir(agregarCarrito);
		Thread.sleep(2000);


	}



}