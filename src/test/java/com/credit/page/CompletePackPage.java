package com.credit.page;

import org.openqa.selenium.WebDriver;

import com.core.newdata.ChineseUtil;
import com.core.newdata.NumberUtil;
import com.core.utils.Page;

public class CompletePackPage extends Page{

	public CompletePackPage(WebDriver driver) {
		super(driver);
	}
	
	//进入菜单--补充进件
	protected void menu_buchongPack(){
		findElements("tree-title", "进件管理").click();
		click("补充进件");	
	}
	
	//姓名搜索
	protected void searchName(String name){
		sendKeys("搜索姓名", name);
		click("查找");
		sleep(2000);
	}
	
	protected void complete(){
		click("编辑");
		selectByIndex("详细借款用途", 1);
		click("客户符合何种产品");
		findElements("combobox-item", "公积金贷").click();//参数化
		sendKeysByJavaScript("申请借款额度", "50000");//参数化
		sendKeysByJavaScript("可接受月最高还款额", "10000"); //参数化
		selectByVisibleText("可申请最长还款期限", "12"); //参数化
		//个人资料信息
		selectByVisibleText("客户类型", "新客户");
		selectByVisibleText("婚姻状况", "已婚");
		click("有无子女");
		sendKeysByJavaScript("供养人数", "3");
		sendKeysByJavaScript("住宅电话", "010-8735850");
		selectByVisibleText("学历", "本科");
		sendKeys("邮箱", NumberUtil.email());
		sendKeys("微信号", "59548");
		selectByIndex("户口省", 1);
		selectByIndex("户口市", 1);
		selectByIndex("户口区", 1);
		sendKeysByJavaScript("户口详细", ChineseUtil.getRandom(6));
		sendKeysByJavaScript("户口邮编", NumberUtil.postCode());
		selectByIndex("住宅省", 1);
		selectByIndex("住宅市", 1);
		selectByIndex("住宅区", 1);
		sendKeysByJavaScript("住宅详细", ChineseUtil.getRandom(6));
		sendKeysByJavaScript("住宅邮编", NumberUtil.postCode());
		selectByIndex("住房状况", 1);
		sendKeysByJavaScript("起始居住时间","2012-12-12");
		selectByIndex("共同居住者", 1);
		selectByIndex("户口性质", 1);
		sendKeysByJavaScript("银行卡号", "6217000180000738739");
		sendKeysByJavaScript("公积金卡号", "65489858");
		sendKeysByJavaScript("公积金密码", "110120");
		//工作信息
		selectByIndex("职业类型", 1);
		sendKeysByJavaScript("工作单位","和信电子商务有限公司");
		selectByIndex("单位性质", 1);
		sendKeysByJavaScript("单位电话","010-8735850");
		selectByIndex("所属行业", 1);
		selectByIndex("职务", 1);
		sendKeysByJavaScript("进入该单位时间","2012-12-12");
		sendKeysByJavaScript("成立时间","2010-10-10");
		sendKeysByJavaScript("所在部门","运维部");
		selectByIndex("单位省", 1);
		selectByIndex("单位市", 1);
		selectByIndex("单位区", 1);
		sendKeysByJavaScript("单位详细",ChineseUtil.getRandom(6));
		sendKeysByJavaScript("邮政编码",NumberUtil.postCode());
		sendKeysByJavaScript("每月基本薪金","50000");
		radioButtion("发薪方式");
		sendKeysByJavaScript("每月发薪日", "15");
		sendKeysByJavaScript("其他收入", "10000");
		//资产信息
		//房子
		selectByIndex("房产状况", 1);
		sendKeysByJavaScript("贷款总金额", "50000");
		sendKeysByJavaScript("贷款总年限", "15");
		sendKeysByJavaScript("已还年限", "10");
		sendKeysByJavaScript("房产数量", "5");
		sendKeysByJavaScript("房产总价值", "50000000");
		sendKeysByJavaScript("购买时间", "2012-12-22");
		sendKeysByJavaScript("购买价格", "500000");
		sendKeysByJavaScript("建筑面积", "100");
		sendKeysByJavaScript("房贷月还款额", "10000");
		selectByIndex("房产地址省", 1);
		selectByIndex("房产地址市", 1);
		selectByIndex("房产地址区", 1);
		sendKeysByJavaScript("房产地址详细",ChineseUtil.getRandom(6));
		sendKeysByJavaScript("房产地邮政编码",ChineseUtil.getRandom(6));
		//车辆
		selectByIndex("购车方式", 1);
		sendKeysByJavaScript("交强险保险费","100");
		sendKeysByJavaScript("商业保险费","100");
		sendKeysByJavaScript("车牌号","18700");
		sendKeysByJavaScript("车辆型号","15400");
		sendKeysByJavaScript("车辆购置价","1000000");
		sendKeysByJavaScript("登记日期","2012-12-12");
		radioButtion("是否通过年检");
		radioButtion("是否非营运");
		radioButtion("车辆已购保险");
		sendKeysByJavaScript("交强险保险止日期","2020-12-20");
		sendKeysByJavaScript("商业险保险止日期","2025-12-20");
		//保单
		selectByIndex("保险公司", 1);
		selectByIndex("投保地点省", 1);
		selectByIndex("投保地点市", 1);
		selectByIndex("投保地点区", 1);
		sendKeysByJavaScript("投保地点详细", ChineseUtil.getRandom(6));
		sendKeysByJavaScript("生效日期", "2012-12-12");
		sendKeysByJavaScript("需缴费年数", "12");
		sendKeysByJavaScript("已缴费年数", "5");
		radioButtion("缴费方式");
		selectByIndex("缴费类别", 1);
		sendKeysByJavaScript("期缴保费", "60000");
		sendKeysByJavaScript("总保额", "500000");
		selectByIndex("险种类型", 1);
		sendKeysByJavaScript("被保险人姓名", findElement("姓名").getAttribute("value"));
		sendKeysByJavaScript("联系电话", NumberUtil.phoneNumber());
		
		//家庭联系人
		//联系人1
		sendKeysByJavaScript("家人姓名", ChineseUtil.getRandomName());
		selectByIndex("家人和本人关系", 1);
		sendKeysByJavaScript("家人工作单位", ChineseUtil.getRandom(6));
		selectByIndex("家人职位", 1);
		selectByIndex("家人工作省", 1);
		selectByIndex("家人工作市", 1);
		selectByIndex("家人工作区", 1);
		sendKeysByJavaScript("家人工作详细", ChineseUtil.getRandom(6));
		sendKeysByJavaScript("家人联系电话", NumberUtil.phoneNumber());
		//联系人2
		sendKeysByJavaScript("家人姓名2", ChineseUtil.getRandomName());
		selectByIndex("家人和本人关系2", 1);
		sendKeysByJavaScript("家人工作单位2", ChineseUtil.getRandom(6));
		selectByIndex("家人职位2", 1);
		selectByIndex("家人工作省2", 1);
		selectByIndex("家人工作市2", 1);
		selectByIndex("家人工作区2", 1);
		sendKeysByJavaScript("家人工作详细2", ChineseUtil.getRandom(6));
		sendKeysByJavaScript("家人联系电话2", NumberUtil.phoneNumber());
		
		//工作证明人
		//同事1	
		sendKeysByJavaScript("同事姓名", ChineseUtil.getRandomName());
		selectByIndex("同事和本人关系", 1);
		sendKeysByJavaScript("同事工作单位", ChineseUtil.getRandom(6));
		selectByIndex("同事职位", 1);
		selectByIndex("同事工作省", 2);
		selectByIndex("同事工作市", 1);
		selectByIndex("同事工作区", 1);
		sendKeysByJavaScript("同事工作详细", ChineseUtil.getRandom(6));
		sendKeysByJavaScript("同事联系电话", NumberUtil.phoneNumber());
		//同事2
		sendKeysByJavaScript("同事姓名2", ChineseUtil.getRandomName());
		selectByIndex("同事和本人关系2", 1);
		sendKeysByJavaScript("同事工作单位2", ChineseUtil.getRandom(6));
		selectByIndex("同事职位2", 1);
		selectByIndex("同事工作省2",2);
		selectByIndex("同事工作市2", 1);
		selectByIndex("同事工作区2", 1);
		sendKeysByJavaScript("同事工作详细2", ChineseUtil.getRandom(6));
		sendKeysByJavaScript("同事联系电话2", NumberUtil.phoneNumber());
		
		//紧急联系人
		//紧急1
		sendKeysByJavaScript("紧急人姓名", ChineseUtil.getRandomName());
		selectByIndex("紧急人和本人关系", 2);
		sendKeysByJavaScript("紧急人工作单位", ChineseUtil.getRandom(6));
		selectByIndex("紧急人职位", 1);
		selectByIndex("紧急人工作省", 3);
		selectByIndex("紧急人工作市", 1);
		selectByIndex("紧急人工作区", 1);
		sendKeysByJavaScript("紧急人工作详细", ChineseUtil.getRandom(6));
		sendKeysByJavaScript("紧急人联系电话", NumberUtil.phoneNumber());
		
		//紧急2
		sendKeysByJavaScript("紧急人姓名2", ChineseUtil.getRandomName());
		selectByIndex("紧急人和本人关系2", 2);
		sendKeysByJavaScript("紧急人工作单位2", ChineseUtil.getRandom(6));
		selectByIndex("紧急人职位2", 1);
		selectByIndex("紧急人工作省2", 3);
		selectByIndex("紧急人工作市2", 1);
		selectByIndex("紧急人工作区2", 1);
		sendKeysByJavaScript("紧急人工作详细2", ChineseUtil.getRandom(6));
		sendKeysByJavaScript("紧急人联系电话2", NumberUtil.phoneNumber());
		
		//工商网信息
		sendKeysByJavaScript("企业名称","和信贷");
		sendKeysByJavaScript("统一社会信用代码","784461644558");
		sendKeysByJavaScript("注册号","110120119");
		sendKeysByJavaScript("公司类型","国有企业");
		sendKeysByJavaScript("法定代表人",findElement("姓名").getAttribute("value"));
		sendKeysByJavaScript("企业地址",ChineseUtil.getRandom(6));
		sendKeysByJavaScript("组成形式","股份制");
		sendKeysByJavaScript("注册日期","2005-05-05");
		sendKeysByJavaScript("注册资本","500");
		sendKeysByJavaScript("经营范围","电子技术,信息技术,金融");
		sendKeysByJavaScript("营业期限","2025-05-15");
		sendKeysByJavaScript("登记机关","中国工商局");
		sendKeysByJavaScript("核准日期","2010-10-10");
		sendKeysByJavaScript("登记状态","正常营业中");
		//备注信息
		radioButtion("家人是否知晓此项借款");
		radioButtion("工作证明人是否知晓此项借款");
		radioButtion("紧急联系人是否知晓此项借款");
		radioButtion("是否加急");
		selectByIndex("客户从何获知", 1);
		scrollToElement("备注信息");
		sendKeysByJavaScript("备注信息", ChineseUtil.getRandom(300));
//		click("保存草稿");
		click("提交");
		click("确定");
		System.out.println("补充资料完成");
	}
}
