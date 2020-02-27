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
public class SeriesCreate {

	WebDriver driver;
	String varTitle = "test Automation";
	String varDesc = "test automation description";
	String varFriendlyId = "test friendlyId";

	public SeriesCreate(WebDriver driver) {
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
	
	//Create Page
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
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div/div[6]/div/div[1]/button")
	@CacheLookup
	WebElement createSeasonButton;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div[3]/div/div[2]/table/tbody/tr[1]/td[2]")
	@CacheLookup
	WebElement firstListSeason;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div[3]/div/div[5]/div[2]/button")
	@CacheLookup
	WebElement continueButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div/div[3]/div/div[2]/button")
	@CacheLookup
	WebElement saveButton;
	
	
	public void clickNavigationBar()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(navigationBar)).click();
	}
	
	public void uploadThumbnail()
	{
		File f = new File("/Users/fendyridwan/Desktop/picture1.png");
		thumbnail.sendKeys(f.getAbsolutePath());
	}
	
	public void uploadPoster()
	{
		File f = new File("/Users/fendyridwan/Desktop/picture2.png");
		poster.sendKeys(f.getAbsolutePath());
	}
	
	public void typeTitle()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(title)).sendKeys(varTitle);
	}
	
	public void typeDescription()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(description)).sendKeys(varDesc);
	}
	
	public void typeFriendlyId()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(friendlyId)).sendKeys(varFriendlyId);
	}
	
	public void clickCreateSeasonButton()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(createSeasonButton)).click();
	}
	
	public void selectFirstListSeason()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(firstListSeason)).click();
	}
	
	public void clickContinueButton()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(continueButton)).click();
	}
	
	public void clickSaveButton()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(saveButton)).click();
	}
}
