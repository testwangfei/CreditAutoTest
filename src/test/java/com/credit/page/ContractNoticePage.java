package com.credit.page;

import org.openqa.selenium.WebDriver;

import com.core.utils.Page;

public class ContractNoticePage extends Page {

	public ContractNoticePage(WebDriver driver) {
		super(driver);
	}
	/*
	 * 进入通知签约页面
	 */
	public void pageInNotice(){
		findElements("tree-title","签约管理").click();
		findElements("tree-title","通知签约").click();
	}
	/*
	 * 查询通知签约列表
	 */
	public Boolean searchNotice(String ID){
		this.sendKeys("进件编号", ID);
		this.click("查找");
		if(this.getText("通知签约列表")!= ""){
			System.out.println("显示符合条件查询列表！");
		}else{
			System.out.println("无符合条件查询数据！");
		}
		return this.getText("通知签约列表")!= "";
	}
	/*
	 * 通知签约
	 */
	public void notice(String ID){
		this.click("通知签约");
		this.click("通知结果");
		this.click("已通知");
		this.sendKeys("预计到店时间",currentDate() );
		this.sendKeys("备注", "通知签约备注");
		this.click("保存");
		this.click("确定");

	}
	/*
	 * 已到店
	 */
	public void beenToShop(String ID){
		this.click("已到店");
		this.click("确定1_已到店");
		this.click("确定2_已到店");
		
	}
	/*
	 * 进入签约管理页面
	 */
	public void pageInSign(){
		
	}
	/*
	 * 签约
	 */
	public void toSign(String ID){
		
	}
}
