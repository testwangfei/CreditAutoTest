package com.credit.test;


import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.core.io.ConfigUtils;
import com.core.utils.Log;



@Test(groups = "Init")
public  class InitTest{
	public static WebDriver driver;			//公共的WebDriver驱动,唯一的公共浏览器
	final Log log = new Log(this.getClass());
	String config = System.getProperty("user.dir") + "/testresource/data/parameters.properties";		//( 测试网址和操作员信息 )存放的文件路径
	Properties prop;								//存放Properties文件的对象
	String credit_url;											// 信贷测试网站的URL
	String fen_url;
	String chromepath;
	
	@BeforeSuite
	public void setUp() {		
		System.out.println(config);
		prop=ConfigUtils.getProperties(config);
		credit_url = prop.getProperty("credit_url");
		fen_url= prop.getProperty("credit_url");
		chromepath =prop.getProperty("chromedriver");
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