package com.credit.page;


import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.core.io.ConfigUtils;
import com.core.io.TextFileUtil;
import com.core.newdata.ChineseUtil;
import com.core.utils.Page;


public class RiskAuditPage extends Page{
	private static String config = System.getProperty("user.dir") + "/testresource/data/parameters.properties";
	private Properties testdata = ConfigUtils.getProperties(config);

		
	public RiskAuditPage(WebDriver driver) {
		super(driver);
	}
	
	//进入菜单--初审管理
	protected void menu_FirstAuditPack(){
		findElements2("tree-title", "信审管理").click();
//		click("进件管理");
		click("初审管理");	
	}
		
	//姓名搜索
	protected void searchName(String name){
		sendKeys("搜索姓名", name);
		click("查找");
		sleep(2000);
	}
	
	//获取初审员工编号
	protected void initialAuditPerson(){
		if (isElementPresent(2, "初审员")) {
			String staff = findElement("初审员").getText();
			findElements("panel-title", "系统管理").click();
			sleep(1000);
			click("系统设置");
			click("员工设置");
			sendKeysByJavaScript("员工姓名", staff);
			click("查找");
			sleep(4000);
			String usr=findElement("工号").getText();
			try {
				TextFileUtil.outputFile(testdata.getProperty("账号临时文件"), usr);
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}	
	}

	//员工菜单
	protected void menu_chushen(){
		findElements("tree-title", "信审管理").click();
		click("初审管理");
	}
	
	
	// 初审
	protected void riskFirstAudit(){
		click("审核");
		sleep(1000);
		switchToWindow("和信风控系统");
		sleep(1000);
		
		//三方信息
		click("三方信息查询");
		sleep(1000);
		click("工商网查询");
		sleep(1000);
		click("工商异常");
		sleep(1000);
//		click("工商无异常");
		
		findElements2("combobox-item", "无异常").click();
		sleep(1000);
		click("网络查询");
		sleep(1000);
		List<WebElement> sList =driver.findElements(By.className("combo-arrow"));
		for (Iterator iterator = sList.iterator(); iterator.hasNext();) {
			WebElement webElement = (WebElement) iterator.next();
			if (webElement.isDisplayed()) {
				webElement.click();
				findElements("combobox-item", "无异常").click();
			}
		}
		clickByJavaScript("保存");
		sleep(1000);
		click("确定");
		
		sleep(1000);
		//决策信息
		click("决策信息");
		sendKeysByJavaScript("批贷金额", testdata.getProperty("初审批准金额"));
		sleep(1000);
		sendKeysByJavaScript("内部决策描述", ChineseUtil.getRandom(100));
		sleep(1000);
		click("决策结果0");
		sleep(1000);
		findElements("combobox-item", "同意批核").click();
		sleep(1000);
		sendKeysByJavaScript("返回销售决策描述", ChineseUtil.getRandom(100));
		click("提交");
		click("确定");
		
		
	}
	
	
	//进入菜单--终审管理
	protected void menu_finalAuditPack(){
		findElements2("tree-title", "信审管理").click();
		click("终审管理");	
	}
	
	//获取终审员工编号
	protected void finalAuditPerson(){
		click("派件单选框");
		sleep(1000);
		if (isElementPresent(5, "终审员")) {
			String staff = findElement("终审员").getText();
			sleep(1000);
			findElements("panel-title", "系统管理").click();
			sleep(1000);
			click("系统设置");
			sleep(1000);
			click("员工设置");
			sleep(1000);
			sendKeysByJavaScript("员工姓名", staff);
			click("查找");
			sleep(3000);
			String usr=findElement("工号").getText();
			sleep(1000);
			try {
				TextFileUtil.outputFile(testdata.getProperty("账号临时文件"), usr);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
	
	//终审
	protected void FinalAudit() {
		click("审核");
		sleep(1000);
		switchToWindow("和信风控系统");
		sleep(1000);
		click("决策信息");
		sleep(2000);
		sendKeys("批贷金额", testdata.getProperty("初审批准金额"));
		sendKeysByJavaScript("内部决策描述", ChineseUtil.getRandom(80));
		sleep(1000);
		click("决策结果0");
		sleep(1000);
		findElements("combobox-item", "同意批核").click();
		sleep(1000);
		sendKeysByJavaScript("返回销售决策描述", ChineseUtil.getRandom(100));
		click("提交");
		sleep(1000);
		click("确定");
		sleep(1000);
	}
	
	
}
