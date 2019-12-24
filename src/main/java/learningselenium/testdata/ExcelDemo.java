package learningselenium.testdata;

import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDemo {
	public static void main(String[] args) throws IOException, InterruptedException {

		File src = new File("D:\\workspacedemo\\testdata\\testdata\\excelExportAndFileIO.xlsx"); // Specify the path of file
		
		// load file. Creates an input file stream to read from the specified File object.																							
		FileInputStream fis = new FileInputStream(src); 
		XSSFWorkbook workbook = new XSSFWorkbook(fis); // Load workbook
		XSSFSheet sheet = workbook.getSheetAt(0); // Load sheet- Here we are loading first sheet only

		// getRow() specify which row we want to read.
		// and getCell() specify which column to read.
		// getStringCellValue() specify that we are reading String data
		for(int i=1;i<2;i++){
			for(int j=0;j<3;j++){
		System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
		}
			}
		System.setProperty("webdriver.chrome.driver", "D:\\workspacedemo\\testdata\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String URL = sheet.getRow(1).getCell(0).getStringCellValue();
		driver.get(URL);
		driver.manage().window().maximize();

		String username = sheet.getRow(1).getCell(1).getStringCellValue();
		driver.findElement(By.id("identifierId")).sendKeys(username);
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		Thread.sleep(5000);

		String password = sheet.getRow(1).getCell(2).getStringCellValue();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		
		
	}

}
