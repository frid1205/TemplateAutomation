/**
 * 
 */
package pages;

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
public class EventList {
	WebDriver driver;
	
	String varName = "test Automation";

	public EventList(WebDriver driver) {
		this.driver = driver;
	}

	//list page
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[1]/div/div/div[2]/ul/a[1]/div")
	@CacheLookup
	WebElement navigationBar;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[1]/button")
	@CacheLookup
	WebElement createNewEvent;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[1]/div/div[2]/input")
	@CacheLookup
	WebElement searchField;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[2]/table/tbody/tr/td[2]")
	@CacheLookup
	WebElement tableFirstList;
	
	public void clickNavigationBar()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(navigationBar)).click();
	}
	
	public void clickCreateButton()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(createNewEvent)).click();
	}
	
	public void typeSearch()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(searchField)).sendKeys(varName);;
	}
	
	public void clearSearch() throws InterruptedException 
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(searchField)).clear();
		Thread.sleep(1000);
	}
	
	public boolean createButtonExist()
	{
		if((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(createNewEvent)).isDisplayed()==true) {
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean searchFieldExist()
	{
		if((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(searchField)).isDisplayed()==true) {
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean firstListTableExist()
	{
		if((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(tableFirstList)).isDisplayed()==true) {
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void selectFirstListofTable()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(tableFirstList)).click();
	}

}
