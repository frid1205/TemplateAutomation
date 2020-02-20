/**
 * @author fendyridwan
 * 
 * This page used for configuration settingfgg
 * dfdfdfdfdfdfd
 */
package bases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import pages.AuthenticationSignInPage;

@Listeners(bases.Listener.class)
public class BaseWeb {
	public static WebDriver driver;
	public static String validAdmin;
	public static String validPassword;
	public static String url;
	WebDriverWait wait;
	
	
	@BeforeSuite
	public void settupTestingData() {
		validAdmin 		= "admin@2359media.com";
		validPassword 	= "password";
	}
	

	@BeforeSuite
	public void deleteScreenShot() throws IOException 
	{
		File dir = new File("ScreenShot");
		File[] listFiles = dir.listFiles();

		if (dir.length() > 0) {
			for (File file : listFiles) {
				file.getName();
				file.delete();
			}
			dir.delete();
		}
	}

	@BeforeClass
	@Parameters({ "browser" , "headless"})
	public void setBaseConfig(String browser, String headless) 
	{
		url = "http://salt-media-cms-dev.s3-website-ap-southeast-1.amazonaws.com";

		WebDriver driver = BrowserFactory.startBrowser(browser, url, headless);
		BaseWeb.driver = driver;

	}

	// sign in with valid credential
	public void signIn() throws InterruptedException 
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

	// get driver of this class for screenshot
	public File getscreenshot() throws IOException 
	{
		File des = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		return des;
	}
	
	public void scrollDown()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1000)");
	}
	
	public void scrollUp()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-1000)");
	}
	

	@AfterClass
	public void quitDriver() {
		driver.quit();
	}
}
