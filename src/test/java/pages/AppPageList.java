/**
 * 
 */
package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author fendyridwan
 *
 */
public class AppPageList {
	WebDriver driver;
	
	String varTitle = "test Automation";
	String varDesc = "This is just for automation purpose";
	String varFriendlyId = "test Automation";

	public AppPageList(WebDriver driver) {
		this.driver = driver;
	}

	// list page
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[1]/div/div/div[1]/ul/a[1]/div")
	@CacheLookup
	WebElement navigationBar;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[1]/button")
	@CacheLookup
	WebElement createAppPage;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[1]/button")
	@CacheLookup
	List<WebElement> createAppPages;
	
	@FindBy(how = How.XPATH, using = "//*[@class=\"MuiTableBody-root\"]")
	@CacheLookup
	WebElement tableList;

	@FindBy(how = How.XPATH, using = "//*[@class=\"MuiTableBody-root\"]")
	@CacheLookup
	List<WebElement> tableLists;

	@FindBy(how = How.XPATH, using = "//*[@class=\"MuiInputBase-input\"]")
	@CacheLookup
	WebElement searchField;

	@FindBy(how = How.XPATH, using = "//*[@class=\"MuiInputBase-input\"]")
	@CacheLookup
	List<WebElement> searchFields;
	
	//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[2]/table/tbody/tr[1]
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[2]")
	@CacheLookup
	WebElement tableFirstList;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[2]")
	@CacheLookup
	List<WebElement> tableFirstLists;

	@FindBy(how = How.XPATH, using = "//*[contains(text(), 'test Automation Edit')]")
	@CacheLookup
	WebElement editedAppPage;

	@FindBy(how = How.XPATH, using = "//*[contains(text(), 'test Automation Edit')]")
	@CacheLookup
	List<WebElement> editedAppPages;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[2]")
	@CacheLookup
	WebElement addedAppPage;
	
	@FindBy(how = How.XPATH, using = "//*[contains(text(), 'test Automation')]")
	@CacheLookup
	List<WebElement> addedAppPages;


	public void clickNavigationBar() throws InterruptedException 
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(navigationBar)).click();
		Thread.sleep(2000);
	}


	public void typeSearch(String search) throws InterruptedException {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(searchField));
		searchField.sendKeys(search);
		Thread.sleep(3000);
	}

	public boolean getTableFirstList() {
		return !tableFirstLists.isEmpty();
	}
	
	public void clickTableFirstList() throws InterruptedException
	{
		tableFirstList.click();
		Thread.sleep(1000);
	}
	
	public boolean editedAppPage() throws InterruptedException {
		Thread.sleep(1000);
		
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(tableFirstList));
		
		if(tableFirstList.getText().equals("test Automation edit"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean addedAppPage() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(addedAppPage));
		System.out.println(addedAppPage.getText());
		if(addedAppPage.getText().equals("test Automation"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public String title() {
		return varTitle;
	}
	
	public boolean searchAppPageResult()
	{
		return !addedAppPages.isEmpty();
	}
	
	public void clearSearchField()
	{
		searchField.clear();
	}
	
	public boolean getCreateAppPagesButton() {
		return !createAppPages.isEmpty();

	}
	
	public boolean getSearch() {
		return !searchFields.isEmpty();

	}

	public boolean getTableList() {
		return !tableLists.isEmpty();
	}
	
	public boolean appPageDeleted() {
		
		if((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(tableFirstList)).getText().equals("test Automation"))
		{
			return false;
		}
		else
		{
			return true;
		}
	}

}
