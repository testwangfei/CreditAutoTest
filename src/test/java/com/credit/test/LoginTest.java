package com.credit.test;

import org.testng.annotations.Test;

import com.credit.bus.CompletePackBus;
import com.credit.bus.LoginBus;

public class LoginTest extends InitTest{
	LoginBus LB;
	CompletePackBus CPB;
	@Test(priority=0)
	private void login() throws Exception{
		driver.get(credit_url);
		LB = new LoginBus(driver);
		LB.login("021631", "1111Aa");
		LB.sleep(3000);
	}
	
	@Test(priority=1)
	public void complete(){
		
		CPB = new CompletePackBus(driver); 
		CPB.complete("杨雪琴");
	}
	
	
	
	@Test(priority=2)
	private void logout(){
		LB.logout();
	}
	
	
}
