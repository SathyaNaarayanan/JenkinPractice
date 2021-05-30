package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {

	public WebDriver launchBrowser(String BrowserName) {

		WebDriver driver = null;
		switch(BrowserName) {

		case "Chrome":
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}

		return driver;
	}



}
