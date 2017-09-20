package com.core.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.IExecutionListener;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;





public class ImplTestNGListener implements IExecutionListener, ITestListener, IInvokedMethodListener {
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Log log = new Log(this.getClass());

	@Override
	public void onExecutionStart() {
		log.message("==执行开始==");
		Date start = new Date();
		log.message(sf.format(start));

	}

	@Override
	public void onExecutionFinish() {
		log.message("==执行完成==");
		Date end = new Date();
		log.message(sf.format(end));

	}

	@Override
	public void onTestStart(ITestResult result) {
		log.message("==测试开始==");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		log.message("==测试成功==\n");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		log.message("==测试失败==\n");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		log.message("==测试忽略==\n");
	}


	@Override
	public void onStart(ITestContext context) {
		Date date1 = context.getStartDate();
		log.message( sf.format(date1) );
		log.message("/n==On *** Start==");

	}

	@Override
	public void onFinish(ITestContext context) {
		Date date2 = context.getStartDate();
		log.message("==" + sf.format(date2) + " =");
		log.message("==On *** Finish ==/n");

	}

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		log.message("方法调用开始");
		ITestNGMethod methods = method.getTestMethod();

		String[] groups = methods.getGroups();
		for (String group : groups) {
			log.message("---调用测试组: ---"+group);
		}

	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		log.message("==方法调用完成==");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		log.message("onTestFailedButWithinSuccessPercentage");
		
	}

}
