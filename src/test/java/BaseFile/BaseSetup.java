package BaseFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import excel.utilities.ExcelReader;
import io.restassured.RestAssured;

public class BaseSetup {
	public Properties config=new Properties();
	public FileInputStream fis;
	public ExcelReader excel = new ExcelReader(".\\src\\test\\java\\excel\\testData.xlsx");
			
		@BeforeSuite
		public void setup()
		{
			try {
				fis= new FileInputStream(".\\src\\test\\java\\Resources\\config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RestAssured.baseURI=config.getProperty("BaseUri");
			RestAssured.basePath=config.getProperty("BasePath");
		}
		
		
		@AfterSuite
		public void tearDown()
		{
			
		}
		
		

	}


