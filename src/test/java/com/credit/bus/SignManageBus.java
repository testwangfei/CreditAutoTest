package com.credit.bus;

import org.openqa.selenium.WebDriver;

import com.credit.page.SignManagePage;

public class SignManageBus extends SignManagePage {

	public SignManageBus(WebDriver driver) {
		super(driver);
	}
	/*
	 * 通知签约\已到店
	 * @see com.credit.page.ContractNoticePage#Notice()
	 */
	public void NoticeBus(String ID){
		super.pageInNotice();
		sleep(3000);
		if(super.searchNotice(ID)){
			super.notice(ID);
			if(!searchNotice(ID)){
				System.out.println("列表中有通知签约记录！");
				if(this.getText("通知结果状态")=="已通知"){
					System.out.println("通知签约成功！");
					super.beenToShop(ID);
					if(!searchNotice(ID)){
						System.out.println("已到店成功！");
					}else{
						System.out.println("已到店失败！");
					}
				}else{
					System.out.println("通知签约失败！");
				}
			}else{
				System.out.println("列表中无通知签约记录！");
			}
		}else{
			System.out.println("未找到需要签约数据！");
		}

	}


}
