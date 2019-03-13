package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

import utilities.BaseClass;

public class LogListener extends BaseClass implements ITestListener{

/*
 * 
 
•	onStart is invoked first.
•	onTestStart is called once for each test before it is invoked.
•	onTestSuccess is invoked whenever a test passes. In our example, t1 always passes whereas, t4 passes three times.
•	onTestFailure is called for t2 as t2 will always fail. It is also called for t4 as it fails twice out of five times that it is invoked.
•	onTestSkipped is called once for t3 as it is bound to skip.
•	onTestFailedButWithinSuccessPercentage is called once for t4, the first time it fails. It is not called again as it doesn’t match the requested successPercentage of 80
•	Finally onFinish is called once when the tests are all run.

 * 
 * */
	
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("onFinish : "+context.getName());
		logger.info("onFinish : "+context.getName());
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("onStart : "+context.getName());
		logger.info("onStart : "+context.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailure(ITestResult Result) {
		// TODO Auto-generated method stub
		System.out.println("The name of the testcase failed is :"+Result.getName());
		logger.info("The name of the testcase failed is :"+Result.getName());
		test.log(LogStatus.FAIL,"Failing...");
		exRepo.endTest(test);
		exRepo.flush();
	}

	@Override
	public void onTestSkipped(ITestResult Result) {
		// TODO Auto-generated method stub
		System.out.println("The name of the testcase skipped is :"+Result.getName());
		logger.info("The name of the testcase skipped is :"+Result.getName());
		test.log(LogStatus.SKIP,"Skipping...");
		exRepo.endTest(test);
		exRepo.flush();
	}

	@Override
	public void onTestStart(ITestResult Result) {
		// TODO Auto-generated method stub
		test = exRepo.startTest(Result.getName());
		System.out.println("The name of the testcase started is :"+Result.getName());
		logger.info("The name of the testcase started is :"+Result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult Result) {
		// TODO Auto-generated method stub
		System.out.println("The name of the testcase passed is :"+Result.getName());
		logger.info("The name of the testcase passed is :"+Result.getName());
		test.log(LogStatus.PASS,"Passing...");
		exRepo.endTest(test);
		exRepo.flush();
	}
}
	
	


