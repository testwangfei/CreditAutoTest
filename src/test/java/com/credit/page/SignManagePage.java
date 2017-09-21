package com.credit.page;

import org.openqa.selenium.WebDriver;

import com.core.utils.Page;

public class SignManagePage extends Page {

	public SignManagePage(WebDriver driver) {
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
		findElements("tree-title","签约管理").click();
		this.click("签约管理");
	}
	/*
	 * 搜索
	 */
	public Boolean searchSign(String ID){
		this.sendKeys("进件编号", ID);
		this.click("查找2");
		if(this.getText("通知签约列表")!= ""){
			System.out.println("显示符合条件查询列表！");
		}else{
			System.out.println("无符合条件查询数据！");
		}
		return this.getText("通知签约列表")!= "";
	}
	/*
	 * 签约
	 * 注意：
	 * 数想签约银行卡号：9558820200001323771
	 * 江西银行开通：调用线上服务必须是正常的
	 * 下一步：电子签章会验证身份证号如果第三方服务不在，可以使用已签章成功的，取值位置：db_contract库cert_request表certificate_no字段值
	 */
	public void toSign(String ID){
		this.click("签约");
		this.click("下一步");
		this.click("签约渠道");
		this.click("签约渠道_线上");
		this.click("开户银行");
		this.click("交通银行");
		this.click("省");
		this.click("北京");
		this.click("市");
		this.click("北京市");
		this.click("东城区");
		this.sendKeys("开户支行名称", "大望路");
		this.sendKeys("银行账号", "9558820200001323771");
		this.click("数想签约");
		//判断数想签约是否成功
		if(this.getText("数想签约提示")=="签约成功"){
			System.out.println("数想签约成功！");
		}else{
			System.out.println("数想签约失败！");
			return;
		}
		this.click("江西银行开户和绑卡");
		//判断江西银行开户和绑卡是否成功
		if(this.getText("江西银行开户和绑卡提示")=="开户和绑卡成功"){
			System.out.println("江西银行开户和绑卡成功！");
		}else{
			System.out.println("江西银行开户和绑卡失败！");
			return;
		}
		this.click("证件填写_下一步");
		this.click("证件填写_确定");
	}
}
