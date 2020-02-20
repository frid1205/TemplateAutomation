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
public class PlaylistList {
WebDriver driver;

	public PlaylistList(WebDriver driver) {
		this.driver = driver;
	}

	//list page
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[1]/div/div/div[1]/ul/a[2]/div/div[2]")
	@CacheLookup
	WebElement navigationBar;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[1]/div/div[2]/input")
	@CacheLookup
	WebElement searchField;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[1]/div/div[2]/input")
	@CacheLookup
	List<WebElement> searchFields;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[1]/button")
	@CacheLookup
	WebElement createPlaylistButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[1]/button")
	@CacheLookup
	List<WebElement> createPlaylistButtons;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[2]")
	@CacheLookup
	WebElement tableFirstList;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[2]")
	@CacheLookup
	List<WebElement> tableFirstLists;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[2]/table/tbody/tr/td")
	@CacheLookup
	WebElement searchNotFound;
	
	
	
	public void clickNavigationBar()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(navigationBar)).click();
	}
	
	public void typeSearchField(String type)
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(searchField)).sendKeys(type);
	}
	
	public boolean searchFieldExist()
	{
		
		return !searchFields.isEmpty();
	}
	
	public void clickCreateButton()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(createPlaylistButton)).click();
	}
	
	public boolean createButtonExist()
	{
		return !createPlaylistButtons.isEmpty();
	}
	
	public void clearSearch()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(searchField)).clear();
	}
	
	public void searchText()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(searchField)).sendKeys("test Automation");
	}
	
	public boolean searchResultFound()
	{
		if((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(searchField)).getText().equals("test Automation"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean searchResultnotFound()
	{
		System.out.println("get text = >"+(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(searchNotFound)).getText());
		if((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(searchNotFound)).getText().equals("No result found"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void selectFirstTableList()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(tableFirstList)).click();
	}
	
	public boolean checkAddedPlaylist()
	{
		if((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(tableFirstList)).getText().contains("test Automation"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean checkEditedPlaylist()
	{
		if((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(tableFirstList)).getText().contains("test Automation edit"))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public boolean tableExist()
	{
		return !tableFirstLists.isEmpty();
	}
	
	
}
