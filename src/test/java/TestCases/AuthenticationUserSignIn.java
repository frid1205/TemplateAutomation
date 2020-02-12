/**
 * @author fendyridwan
 * Verify Authentication User Sign In
 */
package TestCases;

import bases.BaseWeb;
import org.openqa.selenium.support.PageFactory;
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
		
		// Type valid username
		login.typeEmail(validAdmin);

		// type valid password
		login.typePassword(validPassword);

		// click login button
		login.clickLoginButton();

		Thread.sleep(2000);
		
		
	}
	
	
	/*
	 * Feature	: Sign In with unregistered Username
	 * Given	: the user type registered Company username
	 * And		: user type unregistered username
	 * And		: user type valid password
	 * When		: user click button sign in 
	 * Then		: Displayed error message
	 * And		: cannot enter the home page
	 */
	
	@Test
	public void A_002_LoginwithInvalidCredential() throws InterruptedException 
	{
		AuthenticationSignInPage login = PageFactory.initElements(driver, AuthenticationSignInPage.class);
		
		// Type valid username
		login.typeEmail(validAdmin);

		// type valid password
		login.typePassword(validPassword);

		// click login button
		login.clickLoginButton();

		Thread.sleep(2000);
	}
	
	

}
