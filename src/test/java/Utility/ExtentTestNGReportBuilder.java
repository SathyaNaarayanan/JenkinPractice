package Utility;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentTestNGReportBuilder {

	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	//public static ExtentTest test;
	
	@BeforeSuite
	public void setUp() {
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\Report");
		htmlReporter.config().setReportName("UI Sample automation");
		htmlReporter.config().setDocumentTitle("Automation results");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Tester", "Sathya");
	}
	
	
	/*@AfterMethod
	public void getResult(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.fail(MarkupHelper.createLabel(result.getName()+" TestCase Failed", ExtentColor.RED));
			test.fail(result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			test.pass(MarkupHelper.createLabel(result.getName()+" TestCase Passed", ExtentColor.GREEN));
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			test.skip(MarkupHelper.createLabel(result.getName()+" TestCase skipped", ExtentColor.YELLOW));
			test.skip(result.getThrowable());
		}
		test.getExtent().flush();
		//extent.flush();
	}*/
	
}
