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
public class EventCreate {
	
	WebDriver driver;

	String varName = "test Automation";
	String varDesc = "This is just for automation purpose";
	String varStartDate = "02/25/2020, 11:38 AM";
	String varEndDate = "12/25/2020, 11:38 AM";
	String varUrl = "https://www.google.com";

	public EventCreate(WebDriver driver) {
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

	// Add Page
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div/div[2]/div/div[2]/button")
	@CacheLookup
	WebElement saveButton;

	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement name;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div/div[3]/div/div[2]/div/div[2]/div/div/input")
	@CacheLookup
	WebElement description;

	@FindBy(how = How.NAME, using = "startDatetime")
	@CacheLookup
	WebElement startDate;
	
	@FindBy(how = How.NAME, using = "endDatetime")
	@CacheLookup
	WebElement endDate;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div[1]/div/div[3]/div[1]/div[1]/div")
	@CacheLookup
	WebElement getYearAndMonth;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div[1]/div/div[3]/div[1]/div[1]/div")
	@CacheLookup
	WebElement getYearAndMonth2;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div[1]/div/div[3]/div[1]/div[1]/button[2]")
	@CacheLookup
	WebElement nextMonthButton;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div[1]/div/div[3]/div[1]/div[1]/button[1]")
	@CacheLookup
	WebElement prevMonthButton;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div[1]/div/div[3]/div[2]/div/div[3]/div[2]/button")
	@CacheLookup
	WebElement pickStartDate;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div[2]/button[2]")
	@CacheLookup
	WebElement okDateButton;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div[2]/button[1]")
	@CacheLookup
	WebElement cancelDateButton;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div[1]/div/div[3]/div[2]/div/div[3]/div[2]/button")
	@CacheLookup
	WebElement pickStartDate2;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div[2]/button[2]")
	@CacheLookup
	WebElement okDateButton2;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div[2]/button[1]")
	@CacheLookup
	WebElement cancelDateButton2;
	
	@FindBy(how = How.NAME, using = "url")
	@CacheLookup
	WebElement url;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div/div[4]/div/div[2]/div/div/div/div[2]/input")
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
	
	public void clickSaveButton()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(saveButton)).click();
	}
	
	public void typeName()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(name)).sendKeys(varName);
	}
	
	public void typeDescription()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(description)).sendKeys(varDesc);
	}
	
	public void typeStartDate()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(startDate)).click();
		
		String expectMonthAndYear = "";
		while(expectMonthAndYear.contains("February 2020"))
		{
			(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(prevMonthButton)).click();
			
			expectMonthAndYear = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(getYearAndMonth)).getText();
		}
		System.out.println("month and year = "+(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(getYearAndMonth)).getText());
		
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(pickStartDate)).click();
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(okDateButton)).click();
		
	}
	
	public void typeEndDate()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(endDate)).sendKeys(varEndDate);
		
		String expectMonthAndYear = "";
		while(!expectMonthAndYear.contains("May 2020"))
		{
			(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(nextMonthButton)).click();
			
			expectMonthAndYear = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(getYearAndMonth2)).getText();
		}
		System.out.println("month and year = "+(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(getYearAndMonth2)).getText());
		
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(pickStartDate2)).click();
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(okDateButton2)).click();
	}
	
	public void typeUrl()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(url)).sendKeys(varUrl);
	}

	public boolean checkAddedEvents()
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
	
	public void uploadImage()
	{
		File f = new File("/Users/fendyridwan/Desktop/picture2.png");
		potrait.sendKeys(f.getAbsolutePath());
	}

}
