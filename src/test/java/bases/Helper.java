/**
 * 
 */
package bases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import pages.AuthenticationSignInPage;

/**
 * @author fendyridwan
 *
 */
public class Helper extends BaseWeb{
	
	//@Test
	public void Login() throws InterruptedException 
	{
		AuthenticationSignInPage login = PageFactory.initElements(driver, AuthenticationSignInPage.class);
		
		login.login(validAdmin, validPassword);
		
		Assert.assertEquals(login.getURL(), "http://salt-media-cms-dev.s3-website-ap-southeast-1.amazonaws.com/app-pages");
		
	}
	
	

}
