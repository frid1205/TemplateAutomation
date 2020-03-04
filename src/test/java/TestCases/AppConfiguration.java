/**
 * 
 */
package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import bases.BaseWeb;
import pages.AppConfigurationCreate;
import pages.AppConfigurationEdit;
import pages.AppConfigurationList;

/**
 * @author fendyridwan
 *
 */
public class AppConfiguration extends BaseWeb {
	
	@Test
	public void login() throws InterruptedException
	{
		signIn();
		Thread.sleep(3000);
	}
	
	@Test
	public void G_001_DisplayofPlaylistList() throws InterruptedException
	{
		AppConfigurationList appl = PageFactory.initElements(driver, AppConfigurationList.class);
		
		appl.clickNavBar();
		Thread.sleep(2000);
		Assert.assertTrue(appl.searchFieldExist(),"cannot find search field");
		Assert.assertTrue(appl.createButtonExist(), "cannot find create button");
		Assert.assertTrue(appl.firstListTableExist(), "cannot find table list");
		
	}
	
	@Test
	public void G_002_CreateNewAppConfiguration() throws InterruptedException
	{
		AppConfigurationList appl = PageFactory.initElements(driver, AppConfigurationList.class);
		AppConfigurationCreate appc = PageFactory.initElements(driver, AppConfigurationCreate.class);
		
		appl.clickNavBar();
		Thread.sleep(2000);
		appl.clickCreateButton();
		appc.typeKey();
		appc.typeValue();
		appc.typeDescription();
		appc.clickAddButton();
		//back to app configuration list
		appl.clearSearchField();
		appc.typeSearch();
		Thread.sleep(1000);
		
		//assertion
		Assert.assertTrue(appc.checkAddedConfigExist(), "no new config added");
		
	}
	
	@Test
	public void G_002_EditppConfiguration() throws InterruptedException
	{
		AppConfigurationList appl = PageFactory.initElements(driver, AppConfigurationList.class);
		AppConfigurationEdit appe = PageFactory.initElements(driver, AppConfigurationEdit.class);
		
		appl.clickNavBar();
		Thread.sleep(1000);
		appl.typeSearchField();
		appl.selectFirstListofTable();
		scrollDown();
		appe.clearKey();
		appe.typeKey();
		appe.clearValue();
		appe.typeValue();
		appe.clearDescription();
		appe.typeDescription();
		appe.clickUpdateButton();
		//back to app configuration list
		appe.clickNavBar();
		appe.clearSearchField();
		appe.typeSearch();
		Thread.sleep(1000);
		
		//assertion
		Assert.assertTrue(appe.checkAditedConfigExist(), "no new config added");
		
	}
	
	@Test
	public void G_003_DeleteAppConfiguration() throws InterruptedException
	{
		AppConfigurationList appl = PageFactory.initElements(driver, AppConfigurationList.class);
		AppConfigurationEdit appe = PageFactory.initElements(driver, AppConfigurationEdit.class);
		
		appl.clickNavBar();
		Thread.sleep(1000);
		appl.typeSearchField();
		appl.selectFirstListofTable();
		scrollDown();
		appe.clickDeleteButton();
		appe.clickConfirmDeleteButton();
		//back to list page
		appe.clearSearchField();
		appe.typeSearch();
		Thread.sleep(1000);
		
		//assertion
		Assert.assertTrue(appe.checkSearchNoFound(), "no new config added");
		
	}

}
