package com.core.driver;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.core.io.PropertiesUtil;
import com.core.utils.Log;

public class BrowerDriver {
	WebDriver driver;
	String chromepath=System.getProperty("user.dir");
	String firefoxpath=System.getProperty("user.dir");
	public static BrowerDriver browserdriver;
	private Properties p = null;
	private String config = System.getProperty("user.dir") + "/testresource/data/config.properties";
	private String systemType = System.getProperty("os.name");
	Log log = new Log(this.getClass());

	// ~~~~~~启动谷歌浏览器~~~~~~~~~
	public WebDriver startChrome(String urlString) {
		log.info(config);
		p = PropertiesUtil.getProperties(config);
		if (p != null) {
			if (!systemType.contains("Mac")) {
				chromepath = p.getProperty("chromedriver");
			} else {
				chromepath = p.getProperty("MAC_chromedriver");
			}
		}
		log.info("chrome driver path is : " + chromepath);
		System.setProperty("webdriver.chrome.driver", chromepath);
		log.info(" 开始启动浏览器");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(urlString);
		log.info(" 启动谷歌浏览器成功");
		return driver;
	}

	public WebDriver startFirfox(String urlString) throws IOException {
		// 如果火狐不是在默认目录下，需要这样设置一下火狐的路径，不然会报找不到火狐的错误
		p = PropertiesUtil.getProperties(config);
		firefoxpath = p.getProperty("firefox");
		System.setProperty("webdriver.firefox.marionette", firefoxpath);
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(urlString);
		log.info(" 启动火狐浏览器成功");
		return driver;
	}

	public static BrowerDriver getInstance() {
		if (browserdriver == null) {
			synchronized (BrowerDriver.class) {
				browserdriver = new BrowerDriver();
			}
		}
		return browserdriver;
	}

	public WebDriver getDriver() {
		return driver;
	}

}
