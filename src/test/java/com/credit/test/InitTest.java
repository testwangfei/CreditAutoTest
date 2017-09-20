package com.credit.test;


import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.core.io.ConfigUtils;
import com.core.io.TextFileUtil;
import com.core.utils.Log;




@Test(groups = "Init")
public  class InitTest{
	public static WebDriver driver;			//公共的WebDriver驱动,唯一的公共浏览器
	final Log log = new Log(this.getClass());
	String config = System.getProperty("user.dir") + "/testresource/data/parameters.properties";		//( 测试网址和操作员信息 )存放的文件路径
	Properties prop;				// 存放Properties文件的对象
	String credit_url;				// 信贷测试网站的URL
	String fen_url;					// 风控网址
	String admin_feng;			// 风控管理员账号
	String password_fen;		// 风控密码
	String admin_credit; 		//信贷管理员
	String password_credit;	// 信贷密码
	String new_user; 			//信贷新增进件账号
	String chromepath;			// 谷歌浏览器
	public static String custname;	//每次新建进件等的动态的客户名称
	public static String operator;	// 操作员账号
	@BeforeSuite
	public void setUp() {		
		System.out.println(config);
		prop=ConfigUtils.getProperties(config);
		credit_url = prop.getProperty("credit_url");
		fen_url= prop.getProperty("fen_url");
		admin_feng=prop.getProperty("admin_feng");
		password_fen=prop.getProperty("password_fen");
		new_user=prop.getProperty("new_user");
		admin_credit=prop.getProperty("admin_credit");
		password_credit=prop.getProperty("password_credit");	
		chromepath =prop.getProperty("chromedriver");
		custname=TextFileUtil.readline("/testresource/data/temporary_name.txt");		//每次新建进件等的动态的客户名称
		System.setProperty("webdriver.chrome.driver", chromepath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	

	@AfterSuite
	public void tearDown() throws InterruptedException
	{
		if (driver != null)
		{
			driver.close();
			driver.quit();
		}
		log.info("关闭浏览器");
	}
}