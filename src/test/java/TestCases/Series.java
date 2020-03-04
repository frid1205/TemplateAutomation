/**
 * 
 */
package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import bases.BaseWeb;
import pages.SeriesCreate;
import pages.SeriesEdit;
import pages.SeriesList;

/**
 * @author fendyridwan
 *
 */
public class Series extends BaseWeb {
	
	@Test
	public void login() throws InterruptedException
	{
		signIn();
		Thread.sleep(3000);
	}
	
	@Test
	public void D_001_DisplayofPlaylistList() throws InterruptedException
	{
		SeriesList sl = PageFactory.initElements(driver, SeriesList.class);
		
		sl.clickNavigationBar();
		Thread.sleep(2000);
		Assert.assertTrue(sl.searchFieldExist(),"cannot find search field");
		Assert.assertTrue(sl.createButtonExist(), "cannot find create button");
		Assert.assertTrue(sl.tableExist(), "cannot find table list");
		
	}
	
	@Test
	public void D_002_CreateNewSeries() throws InterruptedException
	{
		SeriesList sl = PageFactory.initElements(driver, SeriesList.class);
		SeriesCreate sc = PageFactory.initElements(driver, SeriesCreate.class);
		
		sl.clickNavigationBar();
		sl.clickNewSeriesButton();
		sc.uploadThumbnail();
		sc.uploadPoster();
		scrollDown();
		sc.typeTitle();
		sc.typeDescription();
		sc.typeFriendlyId();
		sc.clickCreateSeasonButton();
		sc.selectFirstListSeason();
		sc.clickContinueButton();
		scrollUp();
		sc.clickSaveButton();
		//back to list page
		sl.clearSearchField();
		sl.typeSearch();
		
		Assert.assertTrue(sl.addedSeriesResult(), "new series is not added");
		
		
	}
	
	@Test
	public void D_003_EditSeries() throws InterruptedException
	{
		SeriesList sl = PageFactory.initElements(driver, SeriesList.class);
		SeriesEdit se = PageFactory.initElements(driver, SeriesEdit.class);
		
		sl.clickNavigationBar();
		sl.typeSearch();
		sl.selectFirstTableList();
		Thread.sleep(2000);
		se.uploadThumbnail();
		se.uploadPoster();
		scrollDown();
		se.clearTitle();
		se.typeTitle();
		se.clearDescription();
		se.typeDescription();
		se.clearFriendlyId();
		se.typeFriendlyId();
		se.clickCreateSeasonButton();
		se.selectSecondlistSeason();
		se.clickContinueButton();
		se.clickSaveSeasonButton();
		scrollUp();
		se.clickSaveButton();
		//back to list page
		se.clickNavigationBar();
		se.clearSearchField();
		se.typeSearch();
		
		Assert.assertTrue(se.editedSeriesResult(), "edited series is not found");
	}
	
	@Test
	public void D_004_DeleteSeries() throws InterruptedException
	{
		SeriesList sl = PageFactory.initElements(driver, SeriesList.class);
		SeriesEdit se = PageFactory.initElements(driver, SeriesEdit.class);
		
		sl.clickNavigationBar();
		sl.typeSearch();
		sl.selectFirstTableList();
		Thread.sleep(2000);
		//Edit page
		se.clickDeleteButton();
		se.clickConfirmDelete();
		//back to list page
		Thread.sleep(2000);
		se.clickNavigationBar();
		se.clearSearchField();
		se.typeSearch();
		Thread.sleep(2000);
		
		Assert.assertTrue(se.findNotFound(), "edited series is not found");
		
		
	}

}
