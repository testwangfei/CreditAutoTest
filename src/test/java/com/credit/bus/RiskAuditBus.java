package com.credit.bus;

import org.openqa.selenium.WebDriver;

import com.credit.page.RiskAuditPage;

public class RiskAuditBus extends RiskAuditPage {

	public RiskAuditBus(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//获取初审员工编号
	public void initialAuditPerson(String name){
		menu_FirstAuditPack();
		searchName(name);
		initialAuditPerson();		
	}
	
	//获取终审员工编号
	public void finalAuditPerson(String name){
		super.menu_finalAuditPack();
		super.searchName(name);
		super.finalAuditPerson();		
	}
	
	//初审
	public void FirstAudit(String name){
		super.menu_chushen();
		super.searchName(name);
		super.riskFirstAudit();
	}
	
	//终审
	public void FinalAudit(String name){
		super.menu_finalAuditPack();
		super.searchName(name);
		super.FinalAudit();
	}
	
	

}
