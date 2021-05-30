package TestCase;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Pages.HomePage;
import Utility.BrowserFactory;
import Utility.DriverFactory;
import Utility.ExcelOperation;
import Utility.ExtentTestNGReportBuilder;

public class TC_01 extends ExtentTestNGReportBuilder{
	
	ExtentTest test;
	@Test
	public void TC_01_Verify() throws IOException {
BrowserFactory browserFac = new BrowserFactory();
		
		test = extent.createTest("TC started");
		DriverFactory.getInsstance().setDriver(browserFac.launchBrowser("Chrome"));
		DriverFactory.getInsstance().getDriver().get("https://www.google.com");
		DriverFactory.getInsstance().getDriver().manage().window().maximize();
		test.log(Status.PASS, "Driver launched");
		
		ExcelOperation excelOperation = new ExcelOperation();
		List<String> myItemsList = excelOperation.read_data();
		
		HomePage homePage = new HomePage(DriverFactory.getInsstance().getDriver());
		
		for(int i=0; i<myItemsList.size(); i++) {
			System.out.println(myItemsList.get(i));
			if(i==0) {
				test.log(Status.INFO, "I Enter Search Item"+myItemsList.get(i));
				homePage.SearchTheItem(myItemsList.get(i));
				test.log(Status.PASS, "I see the result for "+myItemsList.get(i));
			}
			
			homePage.Clear_SearchArea();
			System.out.println(myItemsList.get(i+1));
			test.log(Status.INFO, "I Enter Search Item"+myItemsList.get(i+1));
			homePage.SearchTheItemFromSearchScreen(myItemsList.get(i+1));
			test.log(Status.PASS, "I see the result for "+myItemsList.get(i+1));
			if(homePage.Verify_Item_Link("iPhone")) {
				System.out.println("verified");
			}
			
			break;
		}
		extent.flush();
		DriverFactory.getInsstance().getDriver().quit();
	}
}
