package com.credit.bus;

import org.openqa.selenium.WebDriver;

import com.credit.page.ContractAuditPage;

public class ContractAuditBus extends ContractAuditPage {

	public ContractAuditBus(WebDriver driver) {
		super(driver);
	}
	public void AuditBus(String ID){
		super.PageIn();
		if(super.SearchContract(ID)){
			super.Audit();
			if(!super.SearchContract(ID)){
				System.out.println("合同审核成功！");
			}else{
				System.out.println("合同审核失败！");
			}
		}else{
			System.out.println("未找可审核数据！");
		}
		
	}
}
