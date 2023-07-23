package com.agi.shopforhome.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.agi.shopforhome.entity.Products;

/**
 * @author Soumyadeep MAji
 * Modified Date: 29/08/2022
 * Description: Bulk upload implementation
 *
 */

public class Helper {
	
	public static boolean checkExelFormat(MultipartFile file) {
		String contentType = file.getContentType();
		if(contentType=="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet") {
			return true;
		}
		else
			return true;
	}
		
	//Converts excel to list of products
	 public static List<Products> convertExcelToListOfProducts(InputStream is){
		 List<Products> list = new ArrayList<Products>();
		 try {
			 
			@SuppressWarnings("resource")
			XSSFWorkbook workbook= new XSSFWorkbook(is);
			XSSFSheet sheet= workbook.getSheet("Sheet1");
			
			int rowNumber=0;
			Iterator<Row> iterator = sheet.iterator();
			while(iterator.hasNext()) {
				Row row = iterator.next();
				if(rowNumber==0)
				{
					rowNumber++;
					continue;
				}
				
				Iterator<Cell> cells = row.iterator();
				int cid=0;
				Products pdt =new Products();
				
				while(cells.hasNext()) {
					Cell cell = cells.next();
					
					switch(cid)
					{
					case 0:
						pdt.setName(cell.getStringCellValue());
						break;
					
					case 1:
						pdt.setPrice(cell.getNumericCellValue());
						break;
					case 2:
						pdt.setUrl(cell.getStringCellValue());
						break;
					case 3:
						pdt.setQuantity((int)cell.getNumericCellValue());
						break;
					case 4:
						pdt.setCatagory(cell.getStringCellValue());
						break;
					default :
						break;
					}
					cid++;
				}
				list.add(pdt);
				
			}
			
			 
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		 return list;
	 }

}
