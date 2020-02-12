/**
 * @author fendyridwan
 * Creating Listener
 */
package bases;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class Listener implements ITestListener {

 @Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("---!---" + result.getName() + "------");
	}

 @Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("-Pass-");
	}

 @Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		BaseWeb bw = new BaseWeb();
		try {
			FileUtils.copyFile(bw.getscreenshot(), new File("screenshot/" + result.getName() + ".jpg"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(result.getThrowable().getMessage());
		System.out.println("-Fail-");
	}

 @Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

 @Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

 @Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

 @Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
