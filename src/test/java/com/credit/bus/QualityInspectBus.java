package com.credit.bus;

import org.openqa.selenium.WebDriver;

import com.credit.page.QualityInspectPage;

public class QualityInspectBus extends QualityInspectPage {

	public QualityInspectBus(WebDriver driver) {
		super(driver);
	}
	
	public void inspection(String name){
		menu_buchongPack();
		searchName(name);
		inspection();		
	}
	
	

}
