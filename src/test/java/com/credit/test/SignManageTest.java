package com.credit.test;

import org.testng.annotations.Test;

import com.credit.bus.ContractAuditBus;
import com.credit.bus.SignManageBus;
import com.credit.bus.LoginBus;

public class SignManageTest extends InitTest {
	LoginBus LB;

	/*
	 * 登录
	 */
	@Test(priority=0)
	private void login() throws Exception{
		driver.get(credit_url);
		LB = new LoginBus(driver);
		LB.login("admin", "1111Aa");
	}
	/*
	 * 通知签约、已到店
	 */
	@Test(priority=1)
	private void Notice(){
		SignManageBus CNB=new SignManageBus(driver);
		CNB.NoticeBus("J201709121603164087Z2");
	}
	/*
	 * 签约
	 */
	@Test
	private void Sign(){
		SignManageBus SMB=new SignManageBus(driver);
		SMB.SignBus("J201709181440207558RW");
	}

	
}
