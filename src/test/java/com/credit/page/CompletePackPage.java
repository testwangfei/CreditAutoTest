package com.credit.page;

import org.openqa.selenium.WebDriver;

import com.core.newdata.ChineseUtil;
import com.core.newdata.NumberUtil;
import com.core.newdata.RandomStringUtils;
import com.core.utils.Page;

public class CompletePackPage extends Page{

	public CompletePackPage(WebDriver driver) {
		super(driver);
	}
	
	//进入菜单--补充进件
	protected void menu_buchongPack(){
		findElements("tree-title", "进件管理").click();
		click("补充进件");	
	}
	
	protected void searchName(String name){
		sendKeys("搜索姓名", name);
		click("查找");
		sleep(2000);
	}
	
	protected void complete(){
		click("编辑");
		selectByIndex("详细借款用途", 1);
		click("客户符合何种产品");
		findElements("combobox-item", "公积金贷").click();;//参数化
		sendKeys("申请借款额度", "50000");//参数化
		sendKeys("可接受月最高还款额", "10000"); //参数化
		sendKeys("可申请最长还款期限", "12"); //参数化
		selectByVisibleText("客户类型", "新客户");
		selectByVisibleText("婚姻状况", "已婚");
		click("有无子女");
		sendKeys("供养人数", "3");
		sendKeys("住宅电话", "010-8735850");
		selectByVisibleText("学历", "本科");
		sendKeys("邮箱", NumberUtil.email());
		sendKeys("微信号", "59548");
		selectByIndex("户口省", 1);
		selectByIndex("户口市", 1);
		selectByIndex("户口区", 1);
		sendKeysByJavaScript("户口详细", ChineseUtil.getRandom(6));
		sendKeysByJavaScript("户口邮编", NumberUtil.postCode());
		selectByIndex("住宅省", 1);
		selectByIndex("住宅市", 1);
		selectByIndex("住宅区", 1);
		sendKeysByJavaScript("住宅详细", ChineseUtil.getRandom(6));
		sendKeysByJavaScript("住宅邮编", NumberUtil.postCode());

	}
	

}
