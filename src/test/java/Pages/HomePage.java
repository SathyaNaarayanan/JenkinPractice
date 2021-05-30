package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}

	@FindBy(how=How.XPATH, using="//input[@title='Search']")
	private WebElement input_search_TextField;
	
	@FindBy(how=How.XPATH, using="//input[@aria-label='Google Search']")
	private WebElement button_search;
	
	@FindBy(how=How.XPATH, using="//input[@aria-label='Search']")
	private WebElement input_searchPage_TextField;
	
	@FindBy(how=How.XPATH, using="//button[@aria-label='Google Search']")
	private WebElement button_searchPage;
	
	@FindBy(how=How.XPATH, using="(//*[@id='search']//a[text()='iPhone'])[1]")
	private WebElement link_searchPage_IPhone;
	
	public Boolean Verify_Item_Link(String ItemName) {
		
		String value= link_searchPage_IPhone.getAttribute("href");
		return value.contains(ItemName.toLowerCase());
	}
	
	public void SearchTheItem(String ItemName) {
		try {
			input_search_TextField.click();
			input_search_TextField.sendKeys(ItemName);
			button_search.click();
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.titleContains(ItemName));
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void Clear_SearchArea() {
		input_searchPage_TextField.click();
		input_searchPage_TextField.clear();
		
	}
	public void SearchTheItemFromSearchScreen(String ItemName) {
		try {
			input_searchPage_TextField.click();
			input_searchPage_TextField.sendKeys(ItemName);
			button_searchPage.click();
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.titleContains(ItemName));
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
