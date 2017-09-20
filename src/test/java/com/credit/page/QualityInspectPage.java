package com.credit.page;

import org.openqa.selenium.WebDriver;

import com.core.utils.Page;

public class QualityInspectPage extends Page{

	public QualityInspectPage(WebDriver driver) {
		super(driver);
	}
	
	//进入菜单--交叉质检
	protected void menu_buchongPack(){
		findElements2("tree-title", "进件管理").click();
//		click("进件管理");
		click("交叉质检");	
	}
		
	//姓名搜索
	protected void searchName(String name){
		sendKeys("搜索姓名", name);
		click("查找");
		sleep(1000);
	}
	
	protected void inspection(){
		click("接件单选框");
		click("接件");
		sleep(2000);
		click("确定");
		sleep(2000);
		click("确定");
		sleep(2000);
		click("接件单选框");
		sleep(2000);
		click("通过");
		sleep(2000);
		click("确定");
		sleep(2000);
		click("确定");
		sleep(2000);
	}
	
	
	

}
