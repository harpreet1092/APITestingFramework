package excel.utilities;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import BaseFile.BaseSetup;

public class Datautil extends BaseSetup {

	
		@DataProvider(name="data",parallel=true)// running test cases parallely
		
		public Object[][] getData(Method m){
			
			String sheetName= m.getName();// maps with the current sheet name
			int rows=excel.getRowCount(sheetName); 
			int cols=excel.getColumnCount(sheetName);
			System.out.println("row count is.."+rows); 
			System.out.println("col count is.."+cols);
			
			Object[][] data= new Object[rows][cols]; 
			
			for(int rowNum=2;rowNum<=rows;rowNum++)
			{
				for(int colNum=0;colNum<cols;colNum++)
				{
					data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum);
				}
			}
			return data;
			
		}
		

	}


