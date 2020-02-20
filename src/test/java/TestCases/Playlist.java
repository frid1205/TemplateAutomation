/**
 * 
 */
package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import bases.BaseWeb;
import pages.PlaylistCreate;
import pages.PlaylistEdit;
import pages.PlaylistList;

/**
 * @author fendyridwan
 *
 */
public class Playlist extends BaseWeb {
	
	@Test
	public void login() throws InterruptedException
	{
		signIn();
		Thread.sleep(3000);
	}
	
	@Test
	public void C_001_DisplayofPlaylistList() throws InterruptedException
	{
		PlaylistList pl = PageFactory.initElements(driver, PlaylistList.class);
		
		pl.clickNavigationBar();
		Thread.sleep(2000);
		Assert.assertTrue(pl.searchFieldExist(),"cannot find search field");
		Assert.assertTrue(pl.createButtonExist(), "cannot find create button");
		Assert.assertTrue(pl.tableExist(), "cannot find table list");
		
	}
	
	@Test
	public void C_002_CreateNewSeriesPlaylist()
	{
		PlaylistList pl = PageFactory.initElements(driver, PlaylistList.class);
		PlaylistCreate cn = PageFactory.initElements(driver, PlaylistCreate.class);
		
		pl.clickNavigationBar();
		pl.clickCreateButton();
		cn.typeTitle();
		cn.clickSeriesButton();
		cn.selectFirstListofSeries();
		cn.clickContinueButton();
		cn.clickSaveButton();
		
		pl.clearSearch();
		pl.searchText();
		Assert.assertTrue(pl.checkAddedPlaylist(), "new playlist cannot be found");
		
		
	}
	
	@Test(dependsOnMethods = { "C_002_CreateNewSeriesPlaylist" })
	public void C_003_EditSeriesPlaylist()
	{
		PlaylistList pl = PageFactory.initElements(driver, PlaylistList.class);
		PlaylistEdit ed = PageFactory.initElements(driver, PlaylistEdit.class);
		
		pl.clickNavigationBar();
		pl.clearSearch();
		pl.searchText();
		pl.selectFirstTableList();
		ed.clearTitle();
		ed.typeTitle();
		ed.clickSeriesButton();
		ed.selectSecondListofSeries();
		ed.clickContinueButton();
		scrollUp();
		ed.clickSaveButton();
		ed.clickNavigationBar();
		ed.clearSearch();
		ed.searchText();
		
		Assert.assertTrue(ed.checkEditedPlaylist(), "cannot find edited playlist");
		
		
	}
	
	@Test(dependsOnMethods = { "C_003_EditSeriesPlaylist" })
	public void C_004_DeleteSeriesPlaylist() throws InterruptedException
	{
		PlaylistList pl = PageFactory.initElements(driver, PlaylistList.class);
		PlaylistEdit ed = PageFactory.initElements(driver, PlaylistEdit.class);
		
		pl.clickNavigationBar();
		pl.clearSearch();
		pl.searchText();
		pl.selectFirstTableList();
		ed.clickDeleteButton();
		ed.clickConfirmDelete();
		//ed.clickNavigationBar();
		ed.clearSearch();
		ed.searchText();
		Thread.sleep(3000);
		
		Assert.assertTrue(pl.searchResultnotFound(), "Playlist is not deleted");
		
		
	}
	
	@Test(dependsOnMethods = { "C_004_DeleteSeriesPlaylist" })
	public void C_005_CreateNewMoviesPlaylist()
	{
		PlaylistList pl = PageFactory.initElements(driver, PlaylistList.class);
		PlaylistCreate cn = PageFactory.initElements(driver, PlaylistCreate.class);
		
		pl.clickNavigationBar();
		pl.clickCreateButton();
		cn.typeTitle();
		cn.clickMoviesButton();
		cn.selectFirstLIstOfMovies();
		cn.clickContinueButton();
		cn.clickSaveButton();
		
		pl.clearSearch();
		pl.searchText();
		Assert.assertTrue(pl.checkAddedPlaylist(), "new playlist cannot be found");
		
		
	}
	
	@Test(dependsOnMethods = { "C_005_CreateNewMoviesPlaylist" })
	public void C_006_EditMoviesPlaylist()
	{
		PlaylistList pl = PageFactory.initElements(driver, PlaylistList.class);
		PlaylistEdit ed = PageFactory.initElements(driver, PlaylistEdit.class);
		
		pl.clickNavigationBar();
		pl.clearSearch();
		pl.searchText();
		pl.selectFirstTableList();
		ed.clearTitle();
		ed.typeTitle();
		ed.clickMoviesButton();
		ed.selectSecondListOfMovies();
		ed.clickContinueButton();
		scrollUp();
		ed.clickSaveButton();
		ed.clickNavigationBar();
		ed.clearSearch();
		ed.searchText();
		
		Assert.assertTrue(ed.checkEditedPlaylist(), "cannot find edited playlist");
		
		
	}
	
	@Test(dependsOnMethods = { "C_006_EditMoviesPlaylist" })
	public void C_007_DeleteMoviesPlaylist() throws InterruptedException
	{
		PlaylistList pl = PageFactory.initElements(driver, PlaylistList.class);
		PlaylistEdit ed = PageFactory.initElements(driver, PlaylistEdit.class);
		
		pl.clickNavigationBar();
		pl.clearSearch();
		pl.searchText();
		pl.selectFirstTableList();
		ed.clickDeleteButton();
		ed.clickConfirmDelete();
		//ed.clickNavigationBar();
		ed.clearSearch();
		ed.searchText();
		Thread.sleep(3000);
		
		Assert.assertTrue(pl.searchResultnotFound(), "Playlist is not deleted");
		
		
	}
	

}
