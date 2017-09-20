package com.credit.page;

import org.openqa.selenium.WebDriver;

import com.core.utils.Page;

public class LoginPage extends Page{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	//登陆
	protected void signIn(String username,String password){
		sendKeys("用户名", username);
		sendKeys("密码", password);
		click("登陆");
		if (isElementPresent(2, "确定")) {
			click("确定");
		}
		
		
	}
	
	//退出登陆
	protected void signOut(){
		click("您好");
		click("退出登陆");
	}
	
}
