package learningselenium.testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class ReadFileData {
	
  public static void main(String[] args) throws InterruptedException, IOException  {
		File file = new File("C:\\Users\\swathi.goudar\\Desktop\\testdata\\testdata\\dataFile.properties"); // Specify the path of file
		
		// load file. Creates an input file stream to read from the specified File object.									
		FileInputStream fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput); // load properties file

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\swathi.goudar\\Desktop\\testdata\\drivers\\IEDriverServer.exe");
		WebDriver driver = new ChromeDriver();

		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		
		driver.findElement(By.id("identifierId")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();

		System.out.println("URL :" + prop.getProperty("URL"));
		System.out.println("User name:" + prop.getProperty("username"));
		System.out.println("Password:" + prop.getProperty("password"));
	}
}