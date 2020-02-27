package pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeriesEdit {
	WebDriver driver;
	String varTitle = "test Automation edit";
	String varDesc = "test automation description edit";
	String varFriendlyId = "test friendlyId edit";

	public SeriesEdit(WebDriver driver) {
		this.driver = driver;
	}

	//list page
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[1]/div/div/div[1]/ul/a[3]/div")
	@CacheLookup
	WebElement navigationBar;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[1]/div/div[2]/input")
	@CacheLookup
	WebElement searchField;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[1]/button")
	@CacheLookup
	WebElement createSeriesButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[2]")
	@CacheLookup
	WebElement tableFirstList;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[2]/table/tbody/tr/td")
	@CacheLookup
	WebElement notFoundElement;
	
	//Edit Page
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div/div[4]/div/div[2]/div/div[1]/div/div[2]/input")
	@CacheLookup
	WebElement thumbnail;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div/div[4]/div/div[2]/div/div[2]/div/div[2]/input")
	@CacheLookup
	WebElement poster;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div/div[5]/div/div[2]/div/div[1]/div/div/input")
	@CacheLookup
	WebElement title;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div/div[5]/div/div[2]/div/div[2]/div/div/input")
	@CacheLookup
	WebElement description;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div/div[5]/div/div[2]/div/div[3]/div/div/input")
	@CacheLookup
	WebElement friendlyId;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div/div[6]/div/div[1]/button[1]")
	@CacheLookup
	WebElement createSeasonButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div/div[6]/div/div[1]/button[2]")
	@CacheLookup
	WebElement saveSeasonButton;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div[3]/div/div[2]/table/tbody/tr[1]/td[2]")
	@CacheLookup
	WebElement firstListSeason;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div[3]/div/div[2]/table/tbody/tr[2]/td[2]")
	@CacheLookup
	WebElement secondListSeason;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div[3]/div/div[5]/div[2]/button")
	@CacheLookup
	WebElement continueButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div/div[3]/div/div[2]/button[1]")
	@CacheLookup
	WebElement saveButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div/div[3]/div/div[2]/button[2]")
	@CacheLookup
	WebElement deleteButton;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div/div[2]/div/button[2]")
	@CacheLookup
	WebElement confirmDeleteButton;
	
	
	//Action
	public void clickNavigationBar()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(navigationBar)).click();
	}
	
	public void clearSearchField()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(searchField)).clear();
	}
	
	public void typeSearch()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(searchField)).sendKeys(varTitle);
	}
	
	public void uploadThumbnail()
	{
		File f = new File("/Users/fendyridwan/Desktop/picEdit1.png");
		//(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(thumbnail)).sendKeys(f.getAbsolutePath());
		thumbnail.sendKeys(f.getAbsolutePath());
	}
	
	public void uploadPoster()
	{
		File f = new File("/Users/fendyridwan/Desktop/picEdit2.png");
		//(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(poster)).sendKeys(f.getAbsolutePath());
		poster.sendKeys(f.getAbsolutePath());
	}
	
	public void typeTitle()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(title)).sendKeys(varTitle);
	}
	
	public void clearTitle()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(title)).clear();
	}
	
	public void typeDescription()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(description)).sendKeys(varDesc);
	}
	
	public void clearDescription()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(description)).clear();
	}
	
	public void typeFriendlyId()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(friendlyId)).sendKeys(varFriendlyId);
	}
	
	public void clearFriendlyId()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(friendlyId)).clear();
	}
	
	public void clickCreateSeasonButton()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(createSeasonButton)).click();
	}
	
	public void selectFirstListSeason()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(firstListSeason)).click();
	}
	
	public void selectSecondlistSeason()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(secondListSeason)).click();
	}
	
	public void clickContinueButton()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(continueButton)).click();
	}
	
	public void clickSaveSeasonButton()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(saveSeasonButton)).click();
	}
	
	public void clickSaveButton()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(saveButton)).click();
	}
	
	public void clickDeleteButton()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(deleteButton)).click();
	}
	
	public void clickConfirmDelete()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(confirmDeleteButton)).click();
	}
	
	public boolean editedSeriesResult()
	{
		if((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(tableFirstList)).getText().contains("test Automation edit")) {
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean findNotFound()
	{
		System.out.println((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(notFoundElement)).getText());
		if((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(notFoundElement)).getText().contains("No result found")) {
			return true;
		}
		else
		{
			return false;
		}
	}

}
