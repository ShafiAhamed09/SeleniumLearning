package AllSelenium;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class excelFetch {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options =new ChromeOptions();
		options.addArguments("--incognito");
		WebDriver driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		
		
		String src ="C:\\Users\\shafi\\OneDrive\\Documents\\ExcelTestcases.xlsx";
		FileInputStream file = new FileInputStream(src);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		String UserName = sheet.getRow(1).getCell(0).getStringCellValue();
		String Password = sheet.getRow(1).getCell(1).getStringCellValue();
		
		System.out.println(UserName);
		System.out.println(Password);
		
		WebElement  enterUserName = driver.findElement(By.id("user-name"));
		enterUserName.sendKeys(UserName);
		
		WebElement enterPassword = driver.findElement(By.id("password"));
		enterPassword.sendKeys(Password);
	
		
		Thread.sleep(3000);
		driver.quit();
		
		

	}

}
