/**
 * 
 */
package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import bases.BaseWeb;
import pages.AppPageList;
import pages.AppPagesEdit;
import pages.AppPagesCreate;

/**
 * @author fendyridwan
 *
 */
public class AppPages extends BaseWeb {
	
	SoftAssert sa;
	
	@Test
	public void login() throws InterruptedException
	{
		signIn();
		Thread.sleep(3000);
	}
	
	@Test
	public void B_001_displayOfListPage() throws InterruptedException
	{
		AppPageList appPage = PageFactory.initElements(driver, AppPageList.class);
		
		appPage.clickNavigationBar();
		
		System.out.println("Checking elements");
		
		//assertion
		Assert.assertTrue(appPage.getCreateAppPagesButton(), "Couldn't find Create AppPage button");
		Assert.assertTrue(appPage.getTableList(), "Couldn't find table list");
		Assert.assertTrue(appPage.getSearch(), "Couldn't find search field");
	}
	
	@Test
	public void B_002_CreateNewKeyPage() throws InterruptedException
	{
		AppPagesCreate addPage = PageFactory.initElements(driver, AppPagesCreate.class);
		
		AppPageList appPage = PageFactory.initElements(driver, AppPageList.class);
		
		Thread.sleep(2000);
		addPage.clickNavigationBar();
		
		//Create new key page
		addPage.clickCreateAppPages();
		
		addPage.typeTitle(addPage.title());
		addPage.typeDescription(addPage.description());
		addPage.typeFriendlyId(addPage.friendlyId()); 
		scrollDown();
		addPage.clickAddPlaylistButton(); 
		addPage.selectFirstPlaylist();
		scrollDown(); 
		addPage.clickContinueButton(); 
		scrollUp();
		addPage.clickSaveButton();
		Thread.sleep(3000);
		appPage.clickNavigationBar();
		appPage.typeSearch("test Automation");
		Thread.sleep(2000);
		
		//assertion
		Assert.assertTrue(appPage.addedAppPage(),"cannot find added app page");
		
	}
	
	@Test//(dependsOnMethods = { "B_002_CreateNewKeyPage" })
	public void B_003_searchAvailableAppPage() throws InterruptedException
	{
		AppPageList appPage = PageFactory.initElements(driver, AppPageList.class);
		
		appPage.clearSearchField();
		appPage.typeSearch(appPage.title());
		
		//assertion
		Assert.assertTrue(appPage.addedAppPage(), "search failed");
	}
	
	@Test//(dependsOnMethods = { "B_003_searchAvailableAppPage" })
	public void B_004_editAppPage() throws InterruptedException
	{
		AppPageList appPage = PageFactory.initElements(driver, AppPageList.class);
		
		AppPagesEdit editPage = PageFactory.initElements(driver, AppPagesEdit.class);
		 
		//back to the list
		editPage.clickNavigationBar();
		editPage.clearSearchField();
		editPage.typeSearch("test Automation");
		//sa.assertTrue(appPage.searchAppPageResult(), "Search Failed");
		
		editPage.clickTableFirstList();
		//clear all field 
		editPage.clearField();
		System.out.println("Begin to edit data");
		editPage.typeTitle();
		editPage.typeDescription();
		editPage.typeFriendlyId(); 
		scrollDown();
		editPage.clickAddPlaylistButton();
		//editPage.addPlaylistButtonElement().click();
		editPage.selectSecondPlaylist(); 
		scrollDown();
		editPage.clickContinueButton(); 
		scrollUp(); 
		editPage.clickSaveButton();
		Thread.sleep(3000);
		appPage.clickNavigationBar();
		appPage.clearSearchField();
		appPage.typeSearch("test Automation edit");
		
		//assertion
		Assert.assertTrue(appPage.editedAppPage(), "search failed");
		
	}
	
	@Test(dependsOnMethods = { "B_004_editAppPage" })
	public void B_005_deleteAppPage() throws InterruptedException
	{
		AppPagesEdit appPage = PageFactory.initElements(driver, AppPagesEdit.class);
		AppPagesEdit editPage = PageFactory.initElements(driver, AppPagesEdit.class);
		
		appPage.clickNavigationBar();
		appPage.clearSearchField();
		appPage.typeSearch("test Automation");
		appPage.clickTableFirstList();
		Thread.sleep(5000);
		//Edit page
		editPage.clickDeleteButton();
		editPage.clickConfirmDelete();
		
		//assertion
		Assert.assertTrue(editPage.appPageDeleted(),"no delete message");
		
	}

}
