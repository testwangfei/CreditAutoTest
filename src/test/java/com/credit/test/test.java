package com.credit.test;

import org.testng.annotations.Test;

import com.core.driver.BrowerDriver;

public class test {
	
	@Test
	public void testone(){
		BrowerDriver dd= new BrowerDriver();
		dd.startChrome("http://www.baidu.com/");
		
		
	}

}
