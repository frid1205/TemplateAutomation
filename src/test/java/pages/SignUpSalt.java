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
public class SignUpSalt {
	WebDriver driver;
	String varTitle = "test Automation";
	String varDesc = "test automation description";
	String varFriendlyId = "test friendlyId";

	public SignUpSalt(WebDriver driver) {
		this.driver = driver;
	}

	//list page
	@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div[1]/div[1]/ul/li[3]/a/button")
	@CacheLookup
	WebElement signUpButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"name\"]")
	@CacheLookup
	WebElement name;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]")
	@CacheLookup
	WebElement email;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"password\"]")
	@CacheLookup
	WebElement password;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"confirm-password\"]")
	@CacheLookup
	WebElement confirmPassword;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/main/div/div/div[2]/div/form/div[5]/button")
	@CacheLookup
	WebElement nextButton;
	

	public void clickSignUpButton()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(signUpButton)).click();
	}
	
	public void typeName(String name)
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(this.name)).sendKeys(name);
	}
	
	public void typeEmail(String email)
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(this.email)).sendKeys(email);
	}
	
	public void typePass(String password)
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(this.password)).sendKeys(password);
	}
	
	public void typeConfPass(String confpass)
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(this.confirmPassword)).sendKeys(confpass);
	}
	
	public void clickNextButton()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(nextButton)).click();
	}
}
