/**
 * 
 */
package pages;

import java.awt.SecondaryLoop;

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
public class PlaylistCreate {
	
	WebDriver driver;
	String varTitle = "test Automation";

	public PlaylistCreate(WebDriver driver) {
		this.driver = driver;
	}
	
	//create page
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div/div[2]/div/div[1]/div/button")
	@CacheLookup
	WebElement saveButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div/div[2]/div/div[2]/div/div/div/input")
	@CacheLookup
	WebElement titleField;
	
	//Movies & Series Library
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div/div[3]/div/div[1]/button[1]")
	@CacheLookup
	WebElement seriesButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div/div[3]/div/div[1]/button[2]")
	@CacheLookup
	WebElement movieButton;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div[3]/div[2]/table/tbody/tr[1]/td[2]")
	@CacheLookup
	WebElement firstListSeries;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div[3]/div[2]/table/tbody/tr[1]/td[2]")
	@CacheLookup
	WebElement firstListMovies;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div[3]/div[5]/div[2]/button")
	@CacheLookup
	WebElement continueButton;
	
	public void clickSaveButton()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(saveButton)).click();
	}
	
	public void typeTitle()
	{	
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(titleField)).sendKeys(varTitle);
	}
	
	public void clickSeriesButton()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(seriesButton)).click();
	}
	
	public void clickMoviesButton()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(movieButton)).click();
	}
	
	public void selectFirstListofSeries()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(firstListSeries)).click();
	}
	
	public void selectFirstLIstOfMovies()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(firstListMovies)).click();
	}
	
	public void clickContinueButton()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(continueButton)).click();
	}

}
