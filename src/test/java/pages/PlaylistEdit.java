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
public class PlaylistEdit {
	

	WebDriver driver;
	String varTitle = "test Automation Edit";

	public PlaylistEdit(WebDriver driver) {
		this.driver = driver;
	}
	
	//Menu bar
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[1]/div/div/div[1]/ul/a[2]/div/div[2]")
	@CacheLookup
	WebElement navigationBar;
	
	//list page
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[1]/div/div[2]/input")
	@CacheLookup
	WebElement searchField;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[1]/div/div[2]/input")
	@CacheLookup
	List<WebElement> searchFields;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[2]")
	@CacheLookup
	WebElement tableFirstList;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[2]")
	@CacheLookup
	List<WebElement> tableFirstLists;
	
	//create page
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div/div[2]/div/div[1]/div/button[1]")
	@CacheLookup
	WebElement saveButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div/div[2]/div/div[1]/div/button[2]")
	@CacheLookup
	WebElement deleteButton;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div/div[2]/div/button[2]")
	@CacheLookup
	WebElement confirmDelete;
	
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
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div/div[3]/div/div[1]/button[3]")
	@CacheLookup
	WebElement savePlaylistButton;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div[3]/div[2]/table/tbody/tr[1]/td[2]")
	@CacheLookup
	WebElement firstListSeries;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div[3]/div[2]/table/tbody/tr[2]/td[2]")
	@CacheLookup
	WebElement secondListSeries;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div[3]/div[2]/table/tbody/tr[1]/td[2]")
	@CacheLookup
	WebElement firstListMovies;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div[3]/div[2]/table/tbody/tr[2]/td[2]")
	@CacheLookup
	WebElement secondListMovies;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div[3]/div[5]/div[2]/button")
	@CacheLookup
	WebElement continueButton;
	
	
	
	public void clickNavigationBar()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(navigationBar)).click();
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
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(confirmDelete)).click();
	}
	
	public void clearTitle()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(titleField)).clear();
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
	
	public void selectSecondListofSeries()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(secondListSeries)).click();
	}
	
	public void selectFirstListOfMovies()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(firstListMovies)).click();
	}
	
	public void selectSecondListOfMovies()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(secondListMovies)).click();
	}
	
	public void clickContinueButton()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(continueButton)).click();
	}
	
	public void clearSearch()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(searchField)).clear();
	}
	
	public void searchText()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(searchField)).sendKeys("test Automation");
	}
	
	public boolean checkEditedPlaylist()
	{
		System.out.println("===> "+(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(tableFirstList)).getText());
		if((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(tableFirstList)).getText().contains("test Automation Edit"))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

}
