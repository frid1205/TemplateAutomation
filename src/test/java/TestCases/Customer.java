/**
 * 
 */
package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import bases.BaseWeb;
import pages.CustomerCreate;
import pages.CustomerEdit;
import pages.CustomerList;
import pages.EventCreate;
import pages.EventList;

/**
 * @author fendyridwan
 *
 */
public class Customer extends BaseWeb {
	
	@Test
	public void login() throws InterruptedException
	{
		
		signIn();
		Thread.sleep(3000);
	}
	
	@Test
	public void H_001_CheckPageList() throws InterruptedException
	{
		CustomerList el = PageFactory.initElements(driver, CustomerList.class);
		
		el.clickNavigationBar();
		Thread.sleep(2000);
		Assert.assertTrue(el.searchFieldExist(),"cannot find search field");
		Assert.assertTrue(el.createButtonExist(), "cannot find create button");
		Assert.assertTrue(el.firstListTableExist(), "cannot find table list");
	}
	
	
	/*
	 * still under develop
	 */
	@Test
	public void H_002_CreateNewCustomer() throws InterruptedException
	{
		SoftAssert sa = new SoftAssert();
		
		CustomerList cl = PageFactory.initElements(driver, CustomerList.class);
		CustomerCreate cc = PageFactory.initElements(driver, CustomerCreate.class);
		
		cl.clickNavigationBar();
		Thread.sleep(1000);
		
		cl.clickCreateButton();
		//cc.inputData(a);
		cc.clickSaveButton("1010");
		Thread.sleep(1000);
		cc.clearSearch();
		cc.typeSearch("1010");
		
		sa.assertTrue(cc.checkAddedCustomer("createautomation"), "New customer not found");
		
		
	}
	
	@Test
	public void H_003_EditCustomer() throws InterruptedException
	{
		CustomerList cl = PageFactory.initElements(driver, CustomerList.class);
		CustomerEdit ce = PageFactory.initElements(driver, CustomerEdit.class);
		
		cl.clickNavigationBar();
		Thread.sleep(2000);
		cl.clearSearch();
		cl.typeSearch("testautomation");
		Thread.sleep(1000);
		String a = cl.getTextFirstTable();
		cl.selectFirstListofTable();
		System.out.println(a);
		ce.inputData(a);
		ce.clickSaveButton();
		Thread.sleep(1000);
		ce.clickNavigationBar();
		Thread.sleep(2000);
		
		
		//Assert.assertTrue(cc.checkAddedCustomer(), "New customer not found");
	}

}
