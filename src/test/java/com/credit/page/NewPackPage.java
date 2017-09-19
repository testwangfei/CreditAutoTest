package com.credit.page;

import org.openqa.selenium.WebDriver;

import com.core.utils.Page;

public class NewPackPage extends Page {

	public NewPackPage(WebDriver driver) {
		super(driver);
	}
	
	protected void intent_menu(){
		findElements("tree-title", "进件管理").clear();
		click("意向客户");
	}
	
	
	
	
	protected void addItent(){
		click("新增");
		click("借款期限");
		findElements("combobox-item", "12").clear();//12参数化
		
		
		
	}
	

}
