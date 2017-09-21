package com.credit.test;

import org.testng.annotations.Test;
import com.core.io.TextFileUtil;
import com.credit.bus.LoginBus;
import com.credit.bus.RiskAuditBus;

public class FinalAuditTest extends InitTest{
	LoginBus LB;
	@Test(priority=0)
	private void login() throws Exception{
		operator = TextFileUtil.readline("/testresource/data/accountnumber.txt");		//获取员工账号
		driver.get(fen_url);
		LB = new LoginBus(driver);
		LB.login(operator,password_fen);
	}
	
	@Test(priority=1)
	public void  FirstAudit(){
		RiskAuditBus RFA =new RiskAuditBus(driver);
		RFA.FinalAudit(custname);
	}
	
	
	
}
