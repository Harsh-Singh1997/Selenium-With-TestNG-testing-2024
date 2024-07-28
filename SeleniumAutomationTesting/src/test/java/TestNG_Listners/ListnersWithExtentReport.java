package TestNG_Listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnersWithExtentReport implements ITestListener{
	
	public ExtentSparkReporter sparkreporter;
	public ExtentReports extent;
	public ExtentTest test;

	public void onStart(ITestContext context) {
	    
		//Specify new extent report file path
		sparkreporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\test-output\\MyExtentReport\\Report.html");
		sparkreporter.config().setDocumentTitle("Automation Report"); // Set Document Name
		sparkreporter.config().setReportName("Functional Report"); // Set Report Name
		sparkreporter.config().setTheme(Theme.STANDARD); // Set Theme of Report
		
		extent = new ExtentReports();
		extent.attachReporter(sparkreporter);
		extent.setSystemInfo("Computer-Name", "HP");
		extent.setSystemInfo("Report-Name", "Functional Report");
		extent.setSystemInfo("Tester-Name", "Harsh Singh");
		extent.setSystemInfo("Environment", "Automation QA");
		extent.setSystemInfo("OS-Name", "Windows11");
		extent.setSystemInfo("Browser-Name", "Google Chrome");
		
	  }
	
	public void onTestSuccess(ITestResult result) {

		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Passed test is: " + result.getName());
	  }
	
	public void onTestFailure(ITestResult result) {
	
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Failed test is: " + result.getName());
		test.log(Status.FAIL, "Reason for test fail: " + result.getThrowable());
	  }
	
	public void onTestSkipped(ITestResult result) {
	  
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Skipped test is: " + result.getName());
	  }
	
	public void onFinish(ITestContext context) {
    
		extent.flush();
	  }
	
}
