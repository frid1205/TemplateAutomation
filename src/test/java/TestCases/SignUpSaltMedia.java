/**
 * 
 */
package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import bases.BaseWeb;
import pages.SeriesList;
import pages.SignUpSalt;

/**
 * @author fendyridwan
 *
 */
public class SignUpSaltMedia extends BaseWeb {
	
	@Test
	public void login() throws InterruptedException
	{
		SignUpSalt su = PageFactory.initElements(driver, SignUpSalt.class);
		int i = 0;
		//for(i=1;i<=99;i++)
		//{
			//try {
			su.clickSignUpButton();
			su.typeName("test");
			su.typeEmail("test001@gmail.com");
			su.typePass("12345678");
			su.typeConfPass("12345678");
			su.clickNextButton();
			
			
			Actions action = new Actions(driver);
			WebElement we = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div/div/div[4]/div/div/div/div/div[3]/div[2]/button"));
			action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[1]/ul/li[2]/span"))).click().build().perform();
			
			driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/ul/li[5]")).click();
			driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div/button[1]")).click();
			Thread.sleep(2000);
			System.out.println("running for user :"+i);
			
				
			
		//}
	}

}
