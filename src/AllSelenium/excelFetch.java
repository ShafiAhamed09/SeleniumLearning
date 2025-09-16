package AllSelenium;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class excelFetch {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");

		String src = "C:\\Users\\shafi\\OneDrive\\Documents\\ExcelTestcases.xlsx";
		FileInputStream file = new FileInputStream(src);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		/*
		 * String UserName = sheet.getRow(1).getCell(0).getStringCellValue(); String
		 * Password = sheet.getRow(1).getCell(1).getStringCellValue();
		 */

		int rowCount = sheet.getPhysicalNumberOfRows();
		for (int i=0;i<rowCount;i++)
		{
			XSSFRow row = sheet.getRow(i);
			int cellCount=row.getPhysicalNumberOfCells();
			for(int j=0;j<cellCount;j++)
			{
				XSSFCell cell= row.getCell(j);
				String cellValue = getCellValue(cell);
				System.out.print("||"+cellValue);
				
			}
			System.out.println();
			
			
		}
		
	/*	System.out.println(UserName);
		System.out.println(Password);

		WebElement enterUserName = driver.findElement(By.id("user-name"));
		enterUserName.sendKeys(UserName);

		WebElement enterPassword = driver.findElement(By.id("password"));
		enterPassword.sendKeys(Password);

		Thread.sleep(3000);
		driver.quit();*/

	}

	private static String getCellValue(XSSFCell cell) {
		
		switch(cell.getCellType()) {
		case NUMERIC:
			return String.valueOf(cell.getNumericCellValue());
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case STRING:
			return cell.getStringCellValue();
		default:
			return cell.getStringCellValue();
		}
		// TODO Auto-generated method stub
		
	}

}
