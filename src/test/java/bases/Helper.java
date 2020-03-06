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
	
	@Test
	public void writeResultOnExcel(ITestResult result)
	{
		try {
			File src = new File("testSaltCMS.xlsx");
			
			fis = new FileInputStream(src);
    		
    		wb = new XSSFWorkbook(fis);
    		
    		sheet = wb.getSheetAt(0);
	     
		    int lastrownumber = sheet.getLastRowNum();
			int getLastRowFile = sheet.getLastRowNum();
			String getModuleId;
			String getCaseNumber;
			String getModuleIdFromCaseName;
			String getCaseNumberFromCaseName;
			
			for(int countRow = 1;countRow<=lastrownumber;countRow++){
				XSSFRow row = sheet.getRow(countRow);
				getModuleId = row.getCell(1).toString();
				getCaseNumber = row.getCell(2).toString();
				getModuleIdFromCaseName = result.getName().substring(0, 1);
				getCaseNumberFromCaseName = result.getName().substring(4, 5);
				
				if(getModuleIdFromCaseName.equals(getModuleId)&&getCaseNumberFromCaseName.equals(getCaseNumber)) 
				{
					row.createCell(9).setCellValue("Pass");
					System.out.println("MASUK");
				}
					 
				
				
			}
			FileOutputStream fout = new FileOutputStream(src);
			wb.write(fout);
	        fis.close();
	        fout.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
