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
public class AppConfigurationEdit {
	WebDriver driver;
	String varKey = "test Automation edit";
	String varValue = "test Automation edit";
	String varDesc = "test automation edit";
	String varNoFound = "No result found";

	public AppConfigurationEdit(WebDriver driver) {
		this.driver = driver;
	}

	//list page
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[1]/div/div/div[2]/ul/a[3]/div")
	@CacheLookup
	WebElement navigationBar;
	

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[1]/button")
	@CacheLookup
	WebElement createConfigButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[1]/div/div[2]/input")
	@CacheLookup
	WebElement searchField;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[2]")
	@CacheLookup
	WebElement tableFirstList;
	
	//edit Page
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div/div[2]/div/div[1]/button[1]")
	@CacheLookup
	WebElement deleteButton;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div/div[2]/div/button[2]")
	@CacheLookup
	WebElement confirmDeleteButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div/div[2]/div/div[1]/button[2]")
	@CacheLookup
	WebElement updateButton;
	
	@FindBy(how = How.NAME, using = "key")
	@CacheLookup
	WebElement key;
	
	@FindBy(how = How.NAME, using = "value")
	@CacheLookup
	WebElement value;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div/div[2]/div/div[2]/div/div[3]/div/div/input")
	@CacheLookup
	WebElement description;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[2]/table/tbody/tr/td")
	@CacheLookup
	WebElement searchNoFound;
	
	public void clickUpdateButton()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(updateButton)).click();
	}
	
	public void clickDeleteButton()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(deleteButton)).click();
	}
	
	public void clickConfirmDeleteButton()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(confirmDeleteButton)).click();
	}
	
	public void typeKey()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(key)).sendKeys(varKey);
	}
	
	public void typeValue()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(value)).sendKeys(varValue);
	}
	
	public void typeDescription()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(description)).sendKeys(varDesc);
	}
	
	public void clearKey()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(key)).clear();
	}
	
	public void clearValue()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(value)).clear();
	}
	
	public void clearDescription()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(description)).clear();
	}
	
	public void clickNavBar()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(navigationBar)).click();
	}
	
	public void typeSearch()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(searchField)).sendKeys(varKey);
	}
	
	public boolean checkAditedConfigExist()
	{
		if((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(tableFirstList)).getText().contains(varKey)) {
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void clearSearchField()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(searchField)).clear();;
	}
	
	public boolean checkSearchNoFound()
	{
		if((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(searchNoFound)).getText().contains(varNoFound)) {
			return true;
		}
		else
		{
			return false;
		}
	}

}
