package co.pragra.selboot.listener;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;

import co.pragra.selboot.drivermanager.DriverManager;

public class ScreenShotListener extends DriverManager implements ITestListener  {
	
	WebDriver driver = getDriverInstance() ;

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		takeScreenShot();
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

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	

	public void takeScreenShot(){
	  Path path = Paths.get("target/screenshot");
	  try {
	  SimpleDateFormat format = new SimpleDateFormat("ddMMyyyyHHMMSS");
	
      String fileName = path.toAbsolutePath().toString()+File.separator+"ScreenShot_"+format.format(new Date())+".jpeg";
      // C:/user/atinsingh/ScreenShot_
      File capture = 	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      File screenFile = new File(fileName);
      Files.createParentDirs(screenFile);
	  Files.copy(capture,screenFile);
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
