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
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
	
	@FindBy(how=How.XPATH,using="/html/body/div/div[1]/div[2]/form/div[2]/button")
	@CacheLookup
	WebElement submitButton;
	
	@FindBy(how=How.XPATH,using="//*[@class=\\\"Header_profile__1y4dl\\\"]")
	@CacheLookup
	WebElement logOutButton;
	
	@FindBy(how=How.XPATH,using="//*[@class=\\\"Login_auth_error__1sjE_\\\"]")
	@CacheLookup
	WebElement loginAuthError;
	
	
	
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
	
	public boolean getInvalidCredential()
	{
		boolean em = !driver.findElements(By.xpath("//*[@class=\"Login_auth_error__1sjE_\"]")).isEmpty();
		return em;
	}
	
	public void clearField() 
	{
		email.clear();
		password.clear();
	}
	
	public void inputLogin(String usr,String pass)
	{
		clearField();
		
		// Type username
		typeEmail(usr);

		// type password
		typePassword(pass);

		// click login button
		clickLoginButton();
	}
	
	public void login(String username,String password) throws InterruptedException 
	{
		String expectedURLLogin = "http://salt-media-cms-dev.s3-website-ap-southeast-1.amazonaws.com/login";
		
		
		//Check session, whether user is on session or not
		if(getURL().contains(expectedURLLogin))
		{
			System.out.println("User is not in session");
			
			inputLogin(username, password);

			
		}
		else if(!getURL().contains(expectedURLLogin))
		{
			//Need to hit the logout button several time, !Element Problem
			boolean elementLogoutIsDisplayed=false;
			while(!elementLogoutIsDisplayed) 
			{
				driver.findElement(By.xpath("//*[@class=\"Header_profile__1y4dl\"]")).click();
				elementLogoutIsDisplayed = driver.findElement(By.xpath("//*[@class=\"Header_profile__1y4dl\"]")).isDisplayed();
			}
			Thread.sleep(2000);
		
			inputLogin(username, password);
		}
		else
		{
			System.out.println("Login page cannot be found");
			Assert.assertTrue(false,"Login page cannot be found");
		}
		
		Thread.sleep(2000);
		
	}
	
	
}
