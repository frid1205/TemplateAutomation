/**
 * @author fendyridwan
 * Verify Authentication User Sign In
 */
package TestCases;

import bases.BaseWeb;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AuthenticationSignInPage;


public class AuthenticationUserSignIn extends BaseWeb {
	
	/*
	 * Feature	: Login with valid credential
	 * Given	: the user type registered username and password
	 * When		: user click button sign in
	 * Then		: User is signed in
	 * And		: User is cms home page
	 */
	
	@Test
	public void A_001_LoginwithValidCredential() throws InterruptedException 
	{
		AuthenticationSignInPage login = PageFactory.initElements(driver, AuthenticationSignInPage.class);
		
		login.login(validAdmin, validPassword);
		
		Assert.assertEquals(login.getURL(), "http://salt-media-cms-dev.s3-website-ap-southeast-1.amazonaws.com/app-pages");
		
	}
	
	
	/*
	 * Feature	: Sign In with Invalid Email
	 * Given	: the user type unregistered email
	 * And		: user type password
	 * When		: user click button sign in 
	 * Then		: Displayed error message
	 * And		: cannot enter the home page
	 */
	
	@Test
	public void A_002_LoginwithInvalidEmail() throws InterruptedException 
	{
		AuthenticationSignInPage login = PageFactory.initElements(driver, AuthenticationSignInPage.class);
		
		login.login("wrongEmail@gmail.com", "password");
		
		Assert.assertTrue(login.getInvalidCredential(), "Invalid credential message cannot be found");
		
		
	}
	
	
	/*
	 * Feature	: Sign In with Invalid password
	 * Given	: the user type registered email
	 * And		: user type invalid password
	 * When		: user click button sign in 
	 * Then		: Displayed error message
	 * And		: cannot enter the home page
	 */
	
	@Test
	public void A_003_LoginwithInvalidPassword() throws InterruptedException 
	{
		AuthenticationSignInPage login = PageFactory.initElements(driver, AuthenticationSignInPage.class);
		
		login.login("admin@gmail.com", "wrongpassword");
		
		Assert.assertTrue(login.getInvalidCredential(), "Invalid credential message cannot be found");
		
		
	}
	
	

}
