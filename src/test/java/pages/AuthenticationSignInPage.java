/**
 * @author fendyridwan
 *
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AuthenticationSignInPage 
{
	
	WebDriver driver;
	
	public AuthenticationSignInPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	@FindBy(name="email")
	@CacheLookup
	WebElement email;
	
	@FindBy(how=How.NAME,using="password")
	@CacheLookup
	WebElement password;
	
	@FindBy(how=How.XPATH,using="//*[@id='root']/div[1]/div[2]/form/div[2]/button")
	@CacheLookup
	WebElement submitButton;
	
	
	public void typeEmail(String email)
	{
		this.email.sendKeys(email);
	}
	
	public void typePassword(String pass)
	{
		this.password.sendKeys(pass);
	}
	
	public void clickLoginButton(){
		submitButton.click();
	}
	
	public String getURL(){
		return driver.getCurrentUrl();
	}

	public String expectedURL(){
		return "http://salt-media-cms-dev.s3-website-ap-southeast-1.amazonaws.com/app-pages/";
	}
	
	public boolean getErrorMessage()
	{
		boolean em = !driver.findElements(By.xpath("//*[contains(text(), 'UserNotFound')]")).isEmpty();
		return em;
	}
	
	public boolean getMandatoryMessage()
	{
		boolean em = !driver.findElements(By.xpath("//*[contains(text(), 'This field is mandatory.')]")).isEmpty();
		return em;
	}
	
	public void clearField() 
	{
		email.clear();
		password.clear();
	}
	
	
}
