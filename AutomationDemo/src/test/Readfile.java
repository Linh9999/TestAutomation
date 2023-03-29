package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Readfile {
	 @SuppressWarnings("rawtypes")
	public Sheet readExcel(String filePath,String fileName,String sheetName) throws IOException{
		    File file =    new File(filePath+"\\"+fileName);
		    
		    FileInputStream inputStream = new FileInputStream(file);
		    Workbook fileEx = null;
		   
		    String fileExtensionName = fileName.substring(fileName.indexOf("."));
		    
		    if(fileExtensionName.equals(".xlsx")){
		    	fileEx = new XSSFWorkbook(inputStream);
		    }
		  
		    else if(fileExtensionName.equals(".xls")){
		    	fileEx = new HSSFWorkbook(inputStream);
		    }
		
		    Sheet finalfile = (Sheet) fileEx.getSheet(sheetName);
		    return finalfile;    
		    }
}
