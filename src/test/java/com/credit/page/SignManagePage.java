package com.credit.page;

import org.openqa.selenium.WebDriver;

import com.core.utils.Page;

public class SignManagePage extends Page {

	public SignManagePage(WebDriver driver) {
		super(driver);
	}
	/*
	 * 进入通知签约页面
	 */
	public void pageInNotice(){
		findElements("tree-title","签约管理").click();
		findElements("tree-title","通知签约").click();
	}
	/*
	 * 查询通知签约列表
	 */
	public Boolean searchNotice(String ID){
		this.sendKeys("进件编号", ID);
		this.click("查找");
		if(this.getText("通知签约列表")!= ""){
			System.out.println("显示符合条件查询列表！");
		}else{
			System.out.println("无符合条件查询数据！");
		}
		return this.getText("通知签约列表")!= "";
	}
	/*
	 * 通知签约
	 */
	public void notice(String ID){
		this.click("通知签约");
		this.click("通知结果");
		this.click("已通知");
		this.sendKeys("预计到店时间",currentDate() );
		this.sendKeys("备注", "通知签约备注");
		this.click("保存");
		this.click("确定");

	}
	/*
	 * 已到店
	 */
	public void beenToShop(String ID){
		this.click("已到店");
		this.click("确定1_已到店");
		this.click("确定2_已到店");
		
	}
	/*
	 * 进入签约管理页面
	 */
	public void pageInSign(){
		findElements("tree-title","签约管理").click();
		this.click("签约管理");
	}
	/*
	 * 搜索
	 */
	public Boolean searchSign(String ID){
		this.sendKeys("进件编号", ID);
		this.click("查找2");
		if(this.getText("通知签约列表")!= ""){
			System.out.println("显示符合条件查询列表！");
		}else{
			System.out.println("无符合条件查询数据！");
		}
		return this.getText("通知签约列表")!= "";
	}
	/*
	 * 操作：签约
	 * 注意
	 * 江西银行开户和绑卡：调用线上服务，注意是否服务正常
	 * 下一步，验证电子签章，第三方服务不通时，可使用本地已签章成功的身份证db_contract库cer_request表certificate_no字段
	 * 信贷需修改：信贷库，AuditingInfo表idCode字段
	 */
	public void toSign(){
		if(this.isDisplayed("签约")){
			this.click("签约");
			this.click("下一步");
			this.click("签约渠道");
			this.click("");
			this.click("开户银行");
			this.click("");
			this.click("省");
			this.click("");
			this.click("市");
			this.click("");
			this.click("地区");
			this.click("");
			this.sendKeys("开户支行名称", "大望路");
			this.sendKeys("银行账号", "");
			this.click("数想签约");
			if(this.getText("数想签约提示")=="签约成功"){
				System.out.println(this.getText("数想签约提示"));
				this.click("江西银行开户和绑卡");
				if(this.getText("江西银行开户和绑卡提示")=="开户和绑卡成功"){
					System.out.println(this.getText("江西银行开户和绑卡提示"));
					this.click("证件填写_下一步");
					System.out.println(this.getText("提示"));
					this.click("确定");
					this.click("合同签约_下一步");
					this.click("批量选择文件");
					//auto上传文件？？？？
					this.click("开始上传");
					this.click("提交");
					System.out.println(this.getText("提示"));
					this.click("确定");

				}else{
					System.out.println(this.getText("江西银行开户和绑卡提示"));
				}
				
			}else{
				System.out.println(this.getText("数想签约提示"));
			}
		}else{
			System.out.println("此数据无签约按钮");
		}
		
	}
		
}
