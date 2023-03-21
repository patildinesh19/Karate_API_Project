package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.minidev.json.JSONObject;

public class readexcelandcreatejsonfile 
{
	public static void addarticlejson() throws IOException, InterruptedException	
	{	
		ArrayList<String>a= readexceldata(System.getProperty("user.dir")+"\\payload.xlsx","AddArticle");
	
		// create object for main pojo class to set and get data	
		Addarticlepojo ad = new Addarticlepojo();
		
		// create object for sub pojo class to set and get  data
		Articlepojo ar = new Articlepojo(); 
		
		//Array list object to create array list for nested pojo method which required array list
		List<String> mylist = new ArrayList<String>(); 
		
		/*below is code to set values in mentioned variables in Pojo class 
		by fetching values from excel sheet */
		
		mylist.add(a.get(0));
		mylist.add(a.get(1));
		ar.setTagList(mylist); 
		ar.setBody(a.get(4));
		ar.setTitle(a.get(2));
		ar.setDescription(a.get(3));
		ad.setArticle(ar);
		ObjectMapper o = new ObjectMapper();
		o.writeValue(new File(System.getProperty("user.dir")+"\\src\\test\\java\\helper\\addarticle_1.json"),ad);
		Thread.sleep(5000);
	}
	public  static ArrayList<String> readexceldata(String filepath, String Sheetname) throws IOException
	{
		//XSSFSheet sheet;
		ArrayList<String> ap=new ArrayList<String> ();
		FileInputStream fi= new FileInputStream(filepath);
		XSSFWorkbook workbook = new XSSFWorkbook(fi); ;
		XSSFSheet sheet=workbook.getSheet(Sheetname);
		Iterator<Row> rowiterator= sheet.iterator();
		Row firstrow=rowiterator.next();
		while(rowiterator.hasNext())
		{
			
			Row row= rowiterator.next();
			Iterator <Cell> celliterator=row.cellIterator();
			while(celliterator.hasNext())
			{
				Cell cell=celliterator.next();
				if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
				{
					String numericstr = NumberToTextConverter.toText(cell.getNumericCellValue());
					ap.add(numericstr);
				}
				ap.add(cell.getStringCellValue());
				
			}
				
		}
		
		return ap;	
	}

}
