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
public class EventEdit {
	WebDriver driver;

	String varName = "test Automation edit";
	String varDesc = "This is just for automation purpose edit";
	String varStartDate = "02/25/2020, 11:38 AM";
	String varEndDate = "12/25/2020, 11:38 AM";
	String varUrl = "https://www.googleedits.com";

	public EventEdit(WebDriver driver) {
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

	// Edit Page
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div/div[3]/div/div[2]/button[1]")
	@CacheLookup
	WebElement saveButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div/div[3]/div/div[2]/button[2]")
	@CacheLookup
	WebElement deleteButton;

	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement name;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div/div[4]/div/div[2]/div/div[2]/div/div/input")
	@CacheLookup
	WebElement description;

	@FindBy(how = How.NAME, using = "startDatetime")
	@CacheLookup
	WebElement startDate;
	
	@FindBy(how = How.NAME, using = "endDatetime")
	@CacheLookup
	WebElement endDate;

	@FindBy(how = How.NAME, using = "url")
	@CacheLookup
	WebElement url;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div/div[5]/div/div[2]/div/div/div/div[2]/input")
	@CacheLookup
	WebElement potrait;

	public void clickNavigationBar() throws InterruptedException {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(navigationBar)).click();
		Thread.sleep(2000);
	}

	public void clickCreateEvent() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(createNewEvent)).click();
	}

	public void typeSearch(String search) throws InterruptedException {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(searchField)).sendKeys(varName);
		Thread.sleep(1000);
	}
	
	public void clearSearch() throws InterruptedException 
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(searchField)).clear();
		Thread.sleep(1000);
	}
	
	public void clickSaveButton()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(saveButton)).click();
	}
	
	public void clickDeleteButton()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(deleteButton)).click();
	}
	
	public void clearName() 
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(name)).clear();
	}
	
	public void typeName()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(name)).sendKeys(varName);
	}
	
	public void clearDesc() 
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(description)).clear();
	}
	
	public void typeDescription()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(description)).sendKeys(varDesc);
	}
	
	public void clearStartDate() 
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(startDate)).clear();
	}
	
	public void typeStartDate()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(startDate)).sendKeys(varStartDate);
	}
	
	public void clearEndDate() 
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(endDate)).clear();
	}
	
	public void typeEndDate()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(endDate)).sendKeys(varEndDate);
	}
	
	public void clearUrl() 
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(url)).clear();
	}
	
	public void typeUrl()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(url)).sendKeys(varUrl);
	}

	public boolean checkEditedEvent()
	{
		System.out.println("===>"+(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(tableFirstList)).getText());
		if((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(tableFirstList)).getText().contains(varName)) {
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean checkDeletedEvent()
	{
		System.out.println("===>"+(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(tableFirstList)).getText());
		if((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(tableFirstList)).getText().contains("No result found")) {
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void uploadImage()
	{
		File f = new File("/Users/fendyridwan/Desktop/picture1.png");
		potrait.sendKeys(f.getAbsolutePath());
	}
	
	public void typeSearch()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(searchField)).sendKeys(varName);;
	}

}
