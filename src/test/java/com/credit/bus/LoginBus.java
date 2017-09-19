package com.credit.bus;

import org.openqa.selenium.WebDriver;

import com.credit.page.LoginPage;

public class LoginBus extends LoginPage {

	public LoginBus(WebDriver driver) {
		super(driver);
	}

	//登陆
	public void login(String username,String password){
		super.signIn(username, password);
	}
	
	//退出登陆
	public void logout(){
		super.signOut();
	}
}
