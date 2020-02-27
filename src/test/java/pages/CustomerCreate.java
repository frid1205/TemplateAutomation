/**
 * 
 */
package pages;

import java.io.File;
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
public class CustomerCreate {
	
	WebDriver driver;

	/*
	 * String varName = "test Automation"; String varEmail =
	 * "test_automation@gmail.com"; String varUsername = "testautomation";
	 */

	public CustomerCreate(WebDriver driver) {
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
		
		@FindBy(how = How.XPATH, using = "//h5[contains(text(),\"roy\")]")
		@CacheLookup
		List<WebElement> tableFirstLists;
		
		@FindBy(how = How.NAME, using = "name")
		@CacheLookup
		WebElement name;
		
		@FindBy(how = How.NAME, using = "email")
		@CacheLookup
		WebElement email;
		
		@FindBy(how = How.NAME, using = "username")
		@CacheLookup
		WebElement username;
		
		@FindBy(how = How.XPATH, using = "//p[contains(text(),\"User Email\")]")
		@CacheLookup
		List<WebElement> userEmailtaken;
		
		
				
		@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/form/div[1]/button")
		@CacheLookup
		WebElement saveButton;
		
		public void clickNavigationBar()
		{
			(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(navigationBar)).click();
		}
		
		public void clickCreateButton()
		{
			(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(createNewButton)).click();
		}
		
		public void typeSearch(String varEmail)
		{
			(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(searchField)).sendKeys(varEmail);;
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
		
		 public void inputData(String nameCreate)
		 {
	
			 typeName(nameCreate);
			 typeEmail("createautomation"+nameCreate+"@gmail.com");
			 typeUsername(nameCreate);
			 
		 }
		
		//Create page
		 public void typeName(String varName)
		 {
			 (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(name)).clear();
			 (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(name)).sendKeys(varName);
		 }
		 
		 
		 public void typeEmail(String varEmail)
		 {
			 (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(email)).clear();
			 (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(email)).sendKeys(varEmail);
		 }
		 
		 public void typeUsername(String varUsername)
		 {
			 (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(username)).clear();
			 (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(username)).sendKeys(varUsername);
		 }

		 public void clickSaveButton(String a) throws InterruptedException
		 {
			 
			 int nameInNumber = Integer.parseInt(a);
			 String nameInString = ""; 
			 boolean c = true;
			 int i = 1;
		
			  while(c) 
			  { 
				  System.out.println("1+++"+!userEmailtaken.isEmpty());
				  nameInString = Integer.toString(nameInNumber+i);
				  inputData(nameInString); 
				  (new WebDriverWait(driver,10)).until(ExpectedConditions.visibilityOf(saveButton)).click(); 
				  
				  System.out.println("2+++"+!userEmailtaken.isEmpty());
				  if(!userEmailtaken.isEmpty()==true) {
						c = true;
					}
					else
					{
						c = false;
					}
				  System.out.println("save yang ke "+i); 
				  i++;
			  }
			 
	
		 }
		 
		 public boolean checkAddedCustomer(String varEmail)
			{
				if((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(tableFirstList)).getText().contains(varEmail)) {
					return true;
				}
				else
				{
					return false;
				}
			}
}
