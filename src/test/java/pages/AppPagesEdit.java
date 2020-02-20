/**
 * 
 */
package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bases.BaseWeb;

/**
 * @author fendyridwan
 *
 */
public class AppPagesEdit extends BaseWeb {
	WebDriver driver;

	String varTitle = "test Automation edit";
	String varDesc = "This is just for automation purpose edit";
	String varFriendlyId = "test Automation edit";

	public AppPagesEdit(WebDriver driver) {
		this.driver = driver;
	}

	// list page
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[1]/div/div/div[1]/ul/a[1]/div")
	@CacheLookup
	WebElement navigationBar;

	@FindBy(how = How.XPATH, using = "//*[@class=\"MuiInputBase-input\"]")
	@CacheLookup
	WebElement searchField;

	@FindBy(how = How.XPATH, using = "//*[@class=\"MuiInputBase-input\"]")
	@CacheLookup
	WebElement searchFields;
	
	//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[2]/table/tbody/tr[1]
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[2]")
	@CacheLookup
	WebElement tableFirstList;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[2]")
	@CacheLookup
	List<WebElement> tableFirstLists;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div/div[3]/div/div[2]/button[1]")
	@CacheLookup
	WebElement saveButton;

	@FindBy(how = How.NAME, using = "title")
	@CacheLookup
	WebElement title;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div/div[4]/div/div[2]/div/div[2]/div/div/input")
	@CacheLookup
	WebElement description;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div/div[4]/div/div[2]/div/div[2]/div/div/input")
	@CacheLookup
	List<WebElement> descriptions;

	@FindBy(how = How.NAME, using = "friendlyId")
	@CacheLookup
	WebElement friendlyId;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div/div[5]/div/div[1]/button")
	@CacheLookup
	WebElement addPlaylistButton;

	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div[3]/div[2]/table/tbody/tr[1]")
	@CacheLookup
	WebElement firstPlaylist;

	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div[3]/div[2]/table/tbody/tr[2]")
	@CacheLookup
	WebElement secondPlaylist;

	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div[3]/div[5]/div[2]/button")
	@CacheLookup
	WebElement continueButton;
	
	@FindBy(how = How.XPATH, using = "//*[contains(text(), 'test Automation Edit')]")
	@CacheLookup
	WebElement editedAppPage;

	@FindBy(how = How.XPATH, using = "//*[contains(text(), 'test Automation Edit')]")
	@CacheLookup
	List<WebElement> editedAppPages;

	//*[@id="root"]/div[1]/div[2]/div[2]/form/div/div[3]/div/div[2]/button[2]
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div/div[3]/div/div[2]/button[2]")
	@CacheLookup
	WebElement deleteButton;

	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div/div[2]/div/button[2]")
	@CacheLookup
	WebElement confirmDeleteButton;

	@FindBy(how = How.XPATH, using = "//*[contains(text(), 'App Page Deleted')]")
	@CacheLookup
	List<WebElement> appPageDeleted;

	public String title() {
		return varTitle;
	}

	public String description() {
		return varDesc;
	}

	public String friendlyId() {
		return varFriendlyId;
	}

	public void clickNavigationBar() throws InterruptedException 
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement nav = wait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath("//*[@id=\"root\"]/div[1]/div[2]/div[1]/div/div/div[1]/ul/a[1]/div")));
		nav.click();
		Thread.sleep(2000);
	}


	public void typeSearch(String search) throws InterruptedException {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(searchField));
		searchField.sendKeys(search);
		Thread.sleep(3000);
	}

	public boolean getTableFirstList() {
		return !tableFirstLists.isEmpty();
	}

	public void clickSaveButton() throws InterruptedException {
		saveButton.click();
		Thread.sleep(2000);
	}
	
	public void clickTableFirstList() throws InterruptedException
	{
		tableFirstList.click();
		Thread.sleep(1000);
	}
   
	public void typeTitle() {
		this.title.sendKeys(varTitle);
	}

	public void typeDescription() throws InterruptedException {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(description));
		this.description.sendKeys(varDesc);
	}

	public void typeFriendlyId() {
		this.friendlyId.sendKeys(varFriendlyId);
	}

	public void clickAddPlaylistButton() throws InterruptedException {
		addPlaylistButton.click();
		Thread.sleep(4000);
	}

	public void selectFirstPlaylist() {
		firstPlaylist.click();
	}

	public void selectSecondPlaylist() {
		secondPlaylist.click();
	}

	public void clickContinueButton() throws InterruptedException {
		continueButton.click();
	}

	public boolean editedAppPage() throws InterruptedException {
		Thread.sleep(1000);
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(tableFirstList));
		
		if(tableFirstList.getText().equals(varTitle))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public WebElement waitElement(WebElement element)
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(element));
		return element;
	}
	
	public void clickDeleteButton() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(deleteButton)).click();
	}

	public void clickConfirmDelete() throws InterruptedException {
		confirmDeleteButton.click();
		Thread.sleep(3000);
	}

	public boolean appPageDeleted() {
		
		if((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(tableFirstList)).getText().equals("test Automation"))
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	public WebElement addPlaylistButtonElement() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement addPlaylistButtonElement = wait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath("//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div/div[4]/div/div[1]/button")));
		return addPlaylistButtonElement;
	}

	public void clearField() throws InterruptedException {
		Thread.sleep(1000);
		title.clear();
		scrollDown();
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(description));
		description.clear();
		scrollDown();
		friendlyId.clear();
		scrollUp();
		Thread.sleep(4000);
	}
	
	public void waitForVisibility() throws Error{
	       new WebDriverWait(driver, 30)
	            .until(ExpectedConditions.presenceOfElementLocated(By.name("description")));
	}
	
	public boolean isElementPresent(WebElement elementName, int timeout){
        try{
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOf(elementName));
            return true;
        }catch(Exception e){
            return false;
        }
    }
	
	public void clearSearchField()
	{
		searchField.clear();
	}
	

}
