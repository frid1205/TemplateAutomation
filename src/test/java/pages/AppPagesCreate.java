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

import bases.BaseWeb;

/**
 * @author fendyridwan
 *
 */
public class AppPagesCreate extends BaseWeb {

	WebDriver driver;

	String varTitle = "test Automation";
	String varDesc = "This is just for automation purpose";
	String varFriendlyId = "test Automation";

	public AppPagesCreate(WebDriver driver) {
		this.driver = driver;
	}
	
	// list page
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[1]/div/div/div[1]/ul/a[1]/div")
	@CacheLookup
	WebElement navigationBar;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[1]/button")
	@CacheLookup
	WebElement createAppPage;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[1]/button")
	@CacheLookup
	List<WebElement> createAppPages;

	@FindBy(how = How.XPATH, using = "//*[@class=\"MuiInputBase-input\"]")
	@CacheLookup
	WebElement searchField;

	@FindBy(how = How.XPATH, using = "//*[@class=\"MuiInputBase-input\"]")
	@CacheLookup
	WebElement searchFields;

	@FindBy(how = How.XPATH, using = "//*[@class=\"MuiTableBody-root\"]")
	@CacheLookup
	WebElement tableList;

	@FindBy(how = How.XPATH, using = "//*[@class=\"MuiTableBody-root\"]")
	@CacheLookup
	List<WebElement> tableLists;

	// Add Page
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div/div[2]/div/div[2]/button")
	@CacheLookup
	WebElement saveButton;

	@FindBy(how = How.NAME, using = "title")
	@CacheLookup
	WebElement title;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div/div[3]/div/div[2]/div/div[2]/div/div/input")
	@CacheLookup
	WebElement description;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div/div[3]/div/div[2]/div/div[2]/div/div/input")
	@CacheLookup
	List<WebElement> descriptions;

	@FindBy(how = How.NAME, using = "friendlyId")
	@CacheLookup
	WebElement friendlyId;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/form/div/div[4]/div/div[1]/button")
	@CacheLookup
	WebElement addPlaylistButton;

	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div[3]/div[2]/table/tbody/tr[1]")
	@CacheLookup
	WebElement firstPlaylist;

	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div[3]/div[5]/div[2]/button")
	@CacheLookup
	WebElement continueButton;

	@FindBy(how = How.XPATH, using = "//*[contains(text(), 'test Automation')]")
	@CacheLookup
	List<WebElement> addedAppPages;

	public String title() {
		return varTitle;
	}

	public String description() {
		return varDesc;
	}

	public String friendlyId() {
		return varFriendlyId;
	}

	public void clickNavigationBar() throws InterruptedException {
		navigationBar.click();
		Thread.sleep(2000);
	}

	public void clickCreateAppPages() {
		createAppPage.click();
	}

	public void typeSearch(String search) throws InterruptedException {
		searchField.sendKeys(search);
		Thread.sleep(1000);
	}

	public boolean getCreateAppPagesButton() {
		return !createAppPages.isEmpty();

	}

	public boolean getSearch() {
		return !addedAppPages.isEmpty();

	}

	public boolean getTableList() {
		return !tableLists.isEmpty();
	}

	public void clickSaveButton() throws InterruptedException {
		saveButton.click();
		Thread.sleep(2000);
	}

	public void typeTitle(String title) {
		this.title.sendKeys(title);
	}

	public void typeDescription(String desc) {
		this.description.sendKeys(desc);
	}

	public void typeFriendlyId(String friendlyId) {
		this.friendlyId.sendKeys(friendlyId);
	}

	public void clickAddPlaylistButton() throws InterruptedException {
		addPlaylistButton.click();
		Thread.sleep(4000);
	}

	public void selectFirstPlaylist() {
		firstPlaylist.click();
	}

	public void clickContinueButton() throws InterruptedException {
		continueButton.click();
	}

	public boolean addedAppPage() {
		return !addedAppPages.isEmpty();
	}

	public void clickListAppPage() throws InterruptedException {
		tableList.click();
		Thread.sleep(4000);
	}
	
	

}
