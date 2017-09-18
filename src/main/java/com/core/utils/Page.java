package com.core.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import com.core.io.ConfigUtils;

public class Page {
	private WebDriver driver;
	private Find find;
	private Log log = new Log(Page.class);

	public Page(WebDriver driver) {
		String file = System.getProperty("user.dir") + "/TestResources/location/"
				+ this.getClass().getSuperclass().getSimpleName() + ".properties";
		Properties prop = ConfigUtils.getProperties(file);
		this.find = new Find(driver, prop);
		this.driver = driver;

	}

	/**
	 * 查询页面元素的方法, 默认查询时间为10秒
	 */
	protected WebElement findElement(String locatorkey) {
		return find.findElement(locatorkey);
	}

	/**
	 * 查询页面元素的方法, 查询时间为传递的参数,单位/秒
	 */
	protected WebElement findElement(int timeOutInSeconds, String locatorkey) {
		return find.findEement(timeOutInSeconds, locatorkey);
	}

	/**
	 * 通过页面元素的类名/和文本信息来查询特定的web元素, 特别适合查询列表元素类型
	 */
	protected WebElement findElements(String clssname, String listStr) {
		return find.findElements(clssname, listStr);
	}

	/**
	 * 通过页面元素的类名/和文本信息来查询特定的web元素, 特别适合查询列表元素类型, 绝对相等才满足条件
	 */
	protected WebElement findElements2(String clssname, String listStr) {
		return find.findElements2(clssname, listStr);
	}

	/**
	 * 用于检测非必须显示的元素是否存在, 主要用于错误性校验
	 */
	protected boolean isElementPresent(int timeOutInSeconds, String key) {
		try {
			findElement(timeOutInSeconds, key);
			return true;
		} catch (NoSuchElementException | TimeoutException e) {
			log.error("没有找到该元素" + key);
			return false;
		}
	}

	/**
	 * 用于检测必需存在的元素是否存在, 主要用于正确性校验
	 */
	protected boolean isElementPresent(String key) {
		return isElementPresent(10, key);
	}

	/**
	 * 检测元素是否显示
	 */
	protected boolean isDisplayed(String key) {
		return findElement(key).isDisplayed();
	}

	/**
	 * 检测元素是否可用
	 */
	protected boolean isEnabled(String key) {
		return findElement(key).isEnabled();
	}

	/**
	 * 检测元素是否处于选中状态
	 */
	protected boolean isSelected(String key) {
		return findElement(key).isSelected();
	}

	/**
	 * web元素输入框的清空操作
	 */
	protected void clear(String key) {
		findElement(key).clear();
	}

	/**
	 * 点击事件
	 */
	protected void click(String locatorkey) {
		findElement(locatorkey).click();
	}

	/**
	 * 通过JS点击元素
	 */
	protected void clickByJavaScript(String key) {
		WebElement e = findElement(key);
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", e);
	}

	/**
	 * 点击并并保持鼠标在该元素上
	 */
	protected void clickAndHold(String key) {
		WebElement e = findElement(key);
		Actions actions = new Actions(driver);
		actions.moveToElement(e).clickAndHold(e).perform();
	}

	/**
	 * 单选按钮/单选框相关操作
	 */
	protected void radioButtion(String key) {
		WebElement e = findElement(key);
		if (!e.isSelected()) {
			e.click();
		}
	}

	/**
	 * 点击事件Keys.ENTER, 在具体元素上回车
	 */
	protected void keysEnter(String key) {
		WebElement e = findElement(key);
		e.sendKeys(Keys.ENTER);
	}

	/**
	 * 取消全部选择
	 */
	protected void deselectAll(String key) {
		Select select = new Select(findElement(key));
		select.deselectAll();
	}

	/**
	 * 通过元素属性value的值,取消选择
	 */
	protected void deselectByValue(String key, String value) {
		Select select = new Select(findElement(key));
		select.deselectByValue(value);
	}

	/**
	 * 通过可见的文本信息,取消选择
	 */
	protected void deselectByVisibleText(String key, String text) {
		Select select = new Select(findElement(key));
		select.deselectByVisibleText(text);
	}

	/**
	 * 通过可见的文本信息,取消选择
	 */
	protected void deselectByIndex(String key, int index) {
		Select select = new Select(findElement(key));
		select.deselectByIndex(index);
	}

	/**
	 * 输入事件
	 */
	protected void sendKeys(String locatorkey, String sendvalue) {
		clear(locatorkey);
		findElement(locatorkey).sendKeys(sendvalue);
	}

	/**
	 * 通过JS给输入框传入值
	 */
	protected void sendKeysByJavaScript(String key, String values) {
		WebElement e = findElement(key);
		try {
			clear(key);
		} catch (org.openqa.selenium.InvalidElementStateException e2) {
			log.info("该元素不可以执行清除操作 : " + key);
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value=\"" + values + "\"", e);
	}

	/**
	 * 通过可见的文本,进行web下拉元素的选择操作
	 */
	protected void selectByVisibleText(String key, String text) {
		isElementPresent(key);
		Select select = new Select(findElement(key));
		select.selectByVisibleText(text);
	}

	/**
	 * 通过索引数值,进行web下拉元素的选择操作
	 */
	protected void selectByIndex(String key, int index) {
		isElementPresent(key);
		Select select = new Select(findElement(key));
		select.selectByIndex(index);
	}

	/**
	 * 通过元素属性value的值,进行web下拉元素的选择操作
	 */
	protected void selectByValue(String key, String value) {
		isElementPresent(key);
		Select select = new Select(findElement(key));
		select.selectByValue(value);
	}

	/**
	 * 如果此当前元素是窗体或表单中的元素，则将其提交给远程服务器。
	 */
	protected void submit(String key) {
		findElement(key).submit();
	}

	/**
	 * 滚动页面,将原始显示到页面中心
	 */
	protected void scrollToElement(String key) {
		WebElement e = findElement(key);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", e);
	}

	/**
	 * 切换浏览器窗口
	 */
	protected boolean switchToWindow(String windowTitle) {
		this.sleep(2000);
		boolean flag = false;
		try {
			String currentHandle = driver.getWindowHandle();
			Set<String> handles = driver.getWindowHandles();
			for (String s : handles) {
				if (s.equals(currentHandle)) {
					continue;
				} else {
					driver.switchTo().window(s);
					if (getTitle().contains(windowTitle)) {
						flag = true;
						log.info("成功切换windows窗口到: " + windowTitle);
					}
				}
			}
		} catch (NoSuchWindowException e) {
			log.info("没有找到窗口:" + windowTitle);
			flag = false;
		}
		return flag;
	}

	/**
	 * 切换到Frame框架上
	 */
	protected void switchFrame(String key) {
		driver.switchTo().frame(findElement(key));
	}

	/**
	 * 切换回到父Frame框架上
	 */
	protected void switchParentFrame() {
		driver.switchTo().parentFrame();
	}

	/**
	 * 给富文本框传入值
	 */
	protected void setRichTextBox(String key, String text) {
		WebElement e = findElement(key);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].innerHTML = \"" + text + "\"", e);
	}

	/**
	 * 获取web元素的文本值
	 */
	protected String getText(String key) {
		return findElement(key).getText();
	}

	/**
	 * 该方法将返回具有给定名称的属性的值（如果存在）
	 */
	protected String getAttribute(String key, String name) {
		return findElement(key).getAttribute(name);
	}

	/**
	 * 获取富文本框的值
	 */
	protected String getRichTextBox(String key) {
		WebElement e = findElement(key);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (String) js.executeScript("var result=arguments[0].innerHTML;return result ", e);
	}

	/**
	 * 鼠标点击, 先移动到元素上,在执行点击操作
	 */
	protected void mouseClick(String key) {
		WebElement e = findElement(key);
		Actions action = new Actions(driver);
		action.moveToElement(e);
		action.click();

	}

	/**
	 * 鼠标移到元素上悬停,通过JavaScript
	 */
	protected void mouseHoverByJavaScript(String key) {
		WebElement e = findElement(key);
		String mouseHoverjs = "var evObj = document.createEvent('MouseEvents');"
				+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
				+ "arguments[0].dispatchEvent(evObj);";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(mouseHoverjs, e);
	}

	/**
	 * 最大化windows窗口
	 */
	protected void maxwindows() {
		driver.manage().window().maximize();
	}

	/**
	 * 获取标题
	 */
	protected String getTitle() {
		return this.driver.getTitle();
	}

	/**
	 * 刷新浏览器
	 */
	protected void refresh() {
		driver.navigate().refresh();
	}

	/**
	 * 回车事件,直接回车,
	 */
	protected void enter() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}

	/**
	 * 模拟浏览器后退
	 */
	protected void navigateBack() {
		driver.navigate().back();
	}

	/**
	 * 模拟浏览器前进
	 */
	protected void navigateForward() {
		driver.navigate().forward();
	}

	/**
	 * 在当前窗口加载新的网页
	 */
	protected void navagateTo(String url) {
		driver.navigate().to(url);
	}

	/**
	 * 截图工具
	 */
	protected void getScreenshotAs() {
		String time = new SimpleDateFormat("yyyymmdd-hhmmss").format(new Date());
		String filename = File.separator + time + ".png";
		String currentPath = System.getProperty("user.dir") + "/calendar/screenshot/";
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(currentPath + filename));
		} catch (IOException e) {
			log.error("无法保存屏幕截图\n" + 4);
		} finally {
			log.info("屏幕截图完成");
		}
	}

	/**
	 * 判断是否存在警告弹窗
	 */
	protected boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	/**
	 * 点击弹窗确认,并获取其文本值
	 */
	protected String alertCloseAndGetItsText(boolean accept) {
		sleep(500);
		boolean acceptNextAlert = accept;
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		if (acceptNextAlert) {
			alert.accept();
		} else {
			alert.dismiss();
		}
		return alertText;
	}

	/**
	 * 等待函数
	 */
	protected void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			log.error("等待期间被中止" + e.toString());
		}
	}

}
