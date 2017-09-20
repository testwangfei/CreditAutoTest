package com.credit.test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.core.utils.TestNGListener;
import com.credit.bus.CompletePackBus;
import com.credit.bus.LoginBus;

@Listeners(TestNGListener.class)
public class CompleteTest extends InitTest {	
		LoginBus LB;
		CompletePackBus CPB;
		@Test(priority=0)
		private void login() throws Exception{
			driver.get(credit_url);
			LB = new LoginBus(driver);
			LB.login(new_user, password_credit);
			LB.sleep(3000);
		}
		
		@Test(priority=1)
		public void complete(){
			
			CPB = new CompletePackBus(driver); 
			CPB.complete(custname);
		}
		
		@Test(priority=2)
		private void logout(){
			LB.logout();
		}
}
