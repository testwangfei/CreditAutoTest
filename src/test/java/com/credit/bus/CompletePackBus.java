package com.credit.bus;

import org.openqa.selenium.WebDriver;

import com.credit.page.CompletePackPage;

public class CompletePackBus extends CompletePackPage {

	public CompletePackBus(WebDriver driver) {
		super(driver);
	}
	
	public void complete(String name){
		super.menu_buchongPack();
		super.searchName(name);
		super.complete();
	}
	

}
