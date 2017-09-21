package com.credit.page;

import org.openqa.selenium.WebDriver;

import com.core.utils.Page;

public class ContractAuditPage extends Page {
	
	public ContractAuditPage(WebDriver driver) {
		super(driver);
	}
	
	//进入合同审核页
	public void pageIn(){
		driver.navigate().refresh();
		this.click("合同管理");
		this.click("合同审核");

	}
	//查询
	public Boolean searchContract(String ID){
		this.sendKeys("申请编号", ID);
		this.click("查询");
		if(this.getText("合同列表")!= ""){
			System.out.println("显示符合条件查询列表！");
		}else{
			System.out.println("无符合条件查询数据！");
		}
		return this.getText("合同列表")!= "";
	}
	//审核
	public void audit(){
		this.click("进件编号");
		
		if(this.windowHandsGet("通过")){
			this.click("通过");
		}else{
			System.out.println("合同审核页面未打开！");
		}
		
		this.click("确定");
		
	}
}
