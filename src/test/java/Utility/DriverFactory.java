package Utility;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

		private DriverFactory() {
			
		}
	
		private static DriverFactory insstance = new DriverFactory();

		public static DriverFactory getInsstance() {
			return insstance;
		}
		
		private WebDriver driver;

		public WebDriver getDriver() {
			return driver;
		}

		public void setDriver(WebDriver driver) {
			this.driver = driver;
		}
		

		
	
}
