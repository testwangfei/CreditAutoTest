package com.credit.test;

import org.testng.annotations.Test;
import com.credit.bus.LoginBus;
import com.credit.bus.RiskAuditBus;


public class GetFirstAuditPersionTest extends InitTest{
	LoginBus LB;
	@Test(priority=0)
	private void login() throws Exception{
		driver.get(fen_url);
		LB = new LoginBus(driver);
		LB.login(admin_feng, password_fen);
	}
	
	@Test(priority=1)
	private void getFirstAuditPersion(){
		RiskAuditBus RFA = new RiskAuditBus(driver);
		RFA.initialAuditPerson(custname);				
	}
	
	
	
	
}
