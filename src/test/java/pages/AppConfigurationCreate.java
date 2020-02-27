/**
 * 
 */
package pages;

import java.io.File;

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
public class AppConfigurationCreate {
	
	WebDriver driver;
	String varKey = "test Automation";
	String varValue = "test Automation";
	String varDesc = "test automation";

	public AppConfigurationCreate(WebDriver driver) {
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
	
	//Create Page
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div/div/div/div[1]/button")
	@CacheLookup
	WebElement addButton;
	
	@FindBy(how = How.NAME, using = "key")
	@CacheLookup
	WebElement key;
	
	@FindBy(how = How.NAME, using = "value")
	@CacheLookup
	WebElement value;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div/div/div/div[2]/div/div[3]/div/div/input")
	@CacheLookup
	WebElement description;
	
	public void clickAddButton()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(addButton)).click();
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
	
	public void clickNavBar()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(navigationBar)).click();
	}
	
	public void typeSearch()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(searchField)).sendKeys(varKey);
	}
	
	public boolean checkAddedConfigExist()
	{
		System.out.println("===>"+(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(tableFirstList)).getText());
		if((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(tableFirstList)).getText().contains(varKey)) {
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	

}
