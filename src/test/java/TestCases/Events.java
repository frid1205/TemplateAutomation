/**
 * 
 */
package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import bases.BaseWeb;
import pages.EventCreate;
import pages.EventEdit;
import pages.EventList;

/**
 * @author fendyridwan
 *
 */
public class Events extends BaseWeb{
	
	@Test
	public void login() throws InterruptedException
	{
		signIn();
		Thread.sleep(3000);
	}
	
	@Test
	public void E_001_CheckEventList() throws InterruptedException
	{
		EventList el = PageFactory.initElements(driver, EventList.class);
		
		el.clickNavigationBar();
		Thread.sleep(2000);
		Assert.assertTrue(el.searchFieldExist(),"cannot find search field");
		Assert.assertTrue(el.createButtonExist(), "cannot find create button");
		Assert.assertTrue(el.firstListTableExist(), "cannot find table list");
		
	}
	
	@Test
	public void E_002_CreateNew() throws InterruptedException
	{
		EventList el = PageFactory.initElements(driver, EventList.class);
		EventCreate ec = PageFactory.initElements(driver, EventCreate.class);
		
		el.clickNavigationBar();
		Thread.sleep(2000);
		el.clickCreateButton();
		scrollDown();
		ec.typeName();
		ec.typeDescription();
		ec.typeStartDate();
		Thread.sleep(1000);
		ec.typeEndDate();
		ec.typeUrl();
		ec.uploadImage();
		scrollUp();
		ec.clickSaveButton();
		Thread.sleep(1000);
		
		Assert.assertTrue(ec.checkAddedEvents(), "Event not found");
	}
	
	@Test(dependsOnMethods = { "E_002_CreateNew" })
	public void E_003_EditEvent() throws InterruptedException
	{
		EventList el = PageFactory.initElements(driver, EventList.class);
		EventEdit ed = PageFactory.initElements(driver, EventEdit.class);
		
		el.clickNavigationBar();
		Thread.sleep(2000);
		el.clearSearch();
		el.typeSearch();
		el.selectFirstListofTable();
		scrollDown();
		ed.clearName();
		ed.typeName();
		ed.clearDesc();
		ed.typeDescription();
		
		ed.clearUrl();
		ed.typeUrl();
		ed.uploadImage();
		scrollUp();
		ed.clickSaveButton();
		Thread.sleep(2000);
		
		ed.typeSearch();
		Thread.sleep(1000);
		
		Assert.assertTrue(ed.checkEditedEvent(), "edited event not found");
	}
	
	@Test(dependsOnMethods = { "E_003_EditEvent" })
	public void E_004_DeleteEvent() throws InterruptedException
	{
		EventList el = PageFactory.initElements(driver, EventList.class);
		EventEdit ed = PageFactory.initElements(driver, EventEdit.class);
		
		el.clickNavigationBar();
		Thread.sleep(2000);
		el.clearSearch();
		el.typeSearch();
		el.selectFirstListofTable();
		ed.clickDeleteButton();
		Thread.sleep(2000);
		
		ed.typeSearch();
		Thread.sleep(1000);
		
		Assert.assertTrue(ed.checkDeletedEvent(), "edited event not found");
	}

}
