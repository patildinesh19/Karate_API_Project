package helper;

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

import net.minidev.json.JSONObject;

public class readexcelandcreatejsonobject
{
	public static JSONObject addarticlejson() throws IOException	
	{	
		ArrayList<String>a= readexceldata(System.getProperty("user.dir")+"\\payload.xlsx","AddArticle");
	
		// create object for main pojo class to set and get data	
		Addarticlepojo ad = new Addarticlepojo();
		
		// create object for sub pojo class to set and get  data
		Articlepojo ar = new Articlepojo(); 
		
		//Array list object to create array list for nested pojo method
		List<String> mylist = new ArrayList<String>(); 
		
		/*elow are method to set values in mentioned variables in Pojo class 
		by fetching values from excel sheet */
		
		mylist.add(a.get(0));
		mylist.add(a.get(1));
		ar.setTagList(mylist); 
		ar.setBody(a.get(4));
		ar.setTitle(a.get(2));
		ar.setDescription(a.get(3));
		ad.setArticle(ar);
		JSONObject jsonobject = new JSONObject();
		jsonobject.put("title", ad.getArticle().getTitle());
		jsonobject.put("description", ad.getArticle().getDescription());
		jsonobject.put("body", ad.getArticle().getBody());
		jsonobject.put("tagList1", ad.getArticle().getTagList().get(0));
		jsonobject.put("tagList2", ad.getArticle().getTagList().get(1));		
		return jsonobject;		
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
