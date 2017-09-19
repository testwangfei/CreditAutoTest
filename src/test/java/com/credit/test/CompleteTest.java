package com.credit.test;

import com.credit.bus.CompletePackBus;

public class CompleteTest extends InitTest {
	CompletePackBus CPB;
	public void complete(){
		
		CPB = new CompletePackBus(driver); 
		CPB.complete("  ///  ");
	}

}
