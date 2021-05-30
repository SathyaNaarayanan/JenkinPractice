package TestCase;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import Pages.HomePage;
import Utility.BrowserFactory;
import Utility.DriverFactory;
import Utility.ExcelOperation;

public class TC_01 {
	
	@Test
	public void TC_01_Verify() throws IOException {
BrowserFactory browserFac = new BrowserFactory();
		
		DriverFactory.getInsstance().setDriver(browserFac.launchBrowser("Chrome"));
		DriverFactory.getInsstance().getDriver().get("https://www.google.com");
		DriverFactory.getInsstance().getDriver().manage().window().maximize();
		
		
		ExcelOperation excelOperation = new ExcelOperation();
		List<String> myItemsList = excelOperation.read_data();
		
		HomePage homePage = new HomePage(DriverFactory.getInsstance().getDriver());
		
		for(int i=0; i<myItemsList.size(); i++) {
			System.out.println(myItemsList.get(i));
			if(i==0) {
				homePage.SearchTheItem(myItemsList.get(i));
			}
			
			homePage.Clear_SearchArea();
			System.out.println(myItemsList.get(i+1));
			homePage.SearchTheItemFromSearchScreen(myItemsList.get(i+1));
			//DriverFactory.getInsstance().getDriver().navigate().back();
			if(homePage.Verify_Item_Link("iPhone")) {
				System.out.println("verified");
			}
			
			break;
		}
		
		DriverFactory.getInsstance().getDriver().quit();
	}
}
