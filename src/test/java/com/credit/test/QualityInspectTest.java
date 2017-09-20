package com.credit.test;


import org.testng.annotations.Test;
import com.credit.bus.LoginBus;
import com.credit.bus.QualityInspectBus;


public class QualityInspectTest extends InitTest{
	LoginBus LB;
	@Test(priority=0)
	private void login() throws Exception{
		driver.get(credit_url);
		LB = new LoginBus(driver);
		LB.login(admin_credit, password_credit);
	}
	
	@Test(priority=1)
	private void qualityinspect(){
		QualityInspectBus QIB = new QualityInspectBus(driver);
		QIB.inspection(custname);
	}
	
	
	
	
	
}
