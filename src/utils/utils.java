package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class utils {
	
	public static void commonScreenshot( WebDriver driver ,String fileName) throws IOException
	{
		
		 TakesScreenshot  ss = (TakesScreenshot) driver; //typecasted 
			File src = ss.getScreenshotAs(OutputType.FILE);
		   // File Dest  = ;
		    //FileHandler.copy(src, new File("./Screenshots/img2.png"));
		    FileUtils.copyFile(src, new File("./Screenshots/"+fileName+""));
	}

}
