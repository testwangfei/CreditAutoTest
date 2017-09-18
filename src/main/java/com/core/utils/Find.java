package com.core.utils;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Find {
	protected WebDriver driver;
	protected Properties prop;
	Log log = new Log(Find.class);

	protected Find(WebDriver driver, Properties prop) {
		this.driver = driver;
		this.prop = prop;
	}

	protected String[] getLocator(String locatorkey) {
		String[] locator = null;
		if (prop != null) {
			if (prop.containsKey(locatorkey)) {
				if (prop.getProperty(locatorkey).contains("<")) {
					locator = prop.getProperty(locatorkey).split("<");
				} else {
					log.error("定位信息里没有包含用于分离解析[定位方式]与[定位值]的分割符小于号 < : " + prop.getProperty(locatorkey));
				}
			} else {
				log.error("定位键为不存在: " + locatorkey);
			}
		} else {
			log.error("提示: 页面定位信息的属性文档读取为空");
		}
		return locator;
	}

	/**
	 * 通过WebDriver驱动,查找页面元素
	 */
	protected WebElement findEement(int timeOutInSeconds, String locatorkey) {
		WebElement webelement = null;
		String locatorway = getLocator(locatorkey)[0];
		String locatorvalue = getLocator(locatorkey)[1];
		try {
			webelement = (new WebDriverWait(driver, timeOutInSeconds).until(new ExpectedCondition<WebElement>() {
				@Override
				public WebElement apply(WebDriver driver) {
					WebElement e = null;
					switch (locatorway.toLowerCase()) {
					case "id":
						e = driver.findElement(By.id(locatorvalue));
						break;
					case "name":
						e = driver.findElement(By.name(locatorvalue));
						break;
					case "xpath":
						e = driver.findElement(By.xpath(locatorvalue));
						break;
					case "classname":
						e = driver.findElement(By.className(locatorvalue));
						break;
					case "partiallinktext":
						e = driver.findElement(By.partialLinkText(locatorvalue));
						break;
					case "linktext":
						e = driver.findElement(By.linkText(locatorvalue));
						break;
					case "cssselector":
						e = driver.findElement(By.cssSelector(locatorvalue));
						break;
					case "tagname":
						e = driver.findElement(By.tagName(locatorvalue));
						break;
					default:
						log.error("定位方式有误,请检查: " + locatorway);
						e = null;
						break;
					}
					return e;
				}
			}));
		} catch (org.openqa.selenium.TimeoutException e) {
			log.error("定位方式与定位置不匹配,或者定位值可能有误,导致查询元素超时");
			log.error("定位方式: " + locatorway + "   ||    定位值:" + locatorvalue);
			throw e;
		}

		return webelement;
	}

	protected WebElement findElement(String locatorkey) {
		int timeOutInSeconds = 10;
		return findEement(timeOutInSeconds, locatorkey);
	}

	/**
	 * 查询列表类名相同时,非常有效的方法啊,包含文本值即满足条件
	 */
	protected WebElement findElements(String clssname, String liststring) {
		WebElement webelement = null;
		List<WebElement> templist = driver.findElements(By.className(clssname));
		for (Iterator<WebElement> iterator = templist.iterator(); iterator.hasNext();) {
			WebElement e = iterator.next();
			if (!(e.getText().equals("")) && e.getText().contains(liststring)) {
				webelement = e;
			}
		}
		return webelement;
	}
	
	
	/**
	 * 查询列表类名相同时,非常有效的方法啊, 等于显示文本值才满足
	 */
	protected WebElement findElements2(String clssname, String liststring) {
		WebElement webelement = null;
		List<WebElement> templist = driver.findElements(By.className(clssname));
		for (Iterator<WebElement> iterator = templist.iterator(); iterator.hasNext();) {
			WebElement e = iterator.next();
			if (!(e.getText().equals("")) && e.getText().equals(liststring)) {
				webelement = e;
			}
		}
		return webelement;
	}
	
	

}
