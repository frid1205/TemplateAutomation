/**
 * 
 */
package pages;

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
public class CustomerEdit {

	WebDriver driver;

	String varName = "test Automation";
	String varEmail = "test002@gmail.com";
	String varUsername = "testautomation";

	public CustomerEdit(WebDriver driver) {
		this.driver = driver;
	}
	
	//list page
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[1]/div/div/div[3]/ul/a[1]/div")
	@CacheLookup
	WebElement navigationBar;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[1]/button")
	@CacheLookup
	WebElement createNewButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[1]/div/div[2]/input")
	@CacheLookup
	WebElement searchField;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[3]")
	@CacheLookup
	WebElement tableFirstList;
	
	//Edit Page
	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement name;
	
	@FindBy(how = How.NAME, using = "email")
	@CacheLookup
	WebElement email;
	
	@FindBy(how = How.NAME, using = "username")
	@CacheLookup
	WebElement username;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[3]/div/div[2]/button[1]")
	@CacheLookup
	WebElement deactivateButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[3]/div/div[2]/button[2]")
	@CacheLookup
	WebElement resetPasswordButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[4]/div/form/div[1]/button")
	@CacheLookup
	WebElement saveButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[5]/div/div[1]/button")
	@CacheLookup
	WebElement packageButton;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div[2]/div[2]/table/tbody/tr[1]/td[2]")
	@CacheLookup
	WebElement firstListPackage;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div[2]/div[5]/div[2]/button")
	@CacheLookup
	WebElement continuePackageButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[5]/div/div[1]/button[2]")
	@CacheLookup
	WebElement savePackageButton;
	
	public void clickNavigationBar()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(navigationBar)).click();
	}
	
	public void clickCreateButton()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(createNewButton)).click();
	}
	
	public void typeSearch()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(searchField)).sendKeys(varName);;
	}
	
	public void clearSearch() throws InterruptedException 
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(searchField)).clear();
		Thread.sleep(1000);
	}
	
	public boolean createButtonExist()
	{
		if((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(createNewButton)).isDisplayed()==true) {
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean searchFieldExist()
	{
		if((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(searchField)).isDisplayed()==true) {
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean firstListTableExist()
	{
		if((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(tableFirstList)).isDisplayed()==true) {
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void selectFirstListofTable()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(tableFirstList)).click();
	}
	
	//Create page
	 
	 public void inputData(String nameEdit)
	 {
		 int nameInNumber = Integer.parseInt(nameEdit);
		 String nameInString = Integer.toString(nameInNumber+1); 
		 (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(name)).clear();
		 (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(name)).sendKeys(nameInString);
		 (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(email)).clear();
		 (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(email)).sendKeys("testautomation"+nameInString+"@gmail.com");
		 (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(username)).clear();
		 (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(username)).sendKeys(nameInString);
	 }

	 public void clickSaveButton()
	 {
		 (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(saveButton)).click();
	 }
	 
	 public boolean checkAddedCustomer()
	 {
		if((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(tableFirstList)).getText().contains(varEmail)) {
			return true;
		}
		else
		{
			return false;
		}
	 }
	 
	public String getTextName()
	{
		return (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(name)).getText();
	}
	 
}
