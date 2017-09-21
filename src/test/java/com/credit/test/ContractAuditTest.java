package com.credit.test;

import org.testng.annotations.Test;

import com.credit.bus.CompletePackBus;
import com.credit.bus.ContractAuditBus;
import com.credit.bus.LoginBus;

public class ContractAuditTest extends InitTest {
	LoginBus LB;
	ContractAuditBus CA;

	/*
	 * 登录
	 */
	@Test(priority=0)
	private void login() throws Exception{
		driver.get(credit_url);
		LB = new LoginBus(driver);
		LB.login("admin", "1111Aa");
		LB.sleep(3000);
	}
	/*
	 * 合同审核
	 */
	@Test(priority=1)
	public void AuditTest(){
		CA=new ContractAuditBus(driver);
		CA.AuditBus("J20170904160839575PH2");
	}
}
