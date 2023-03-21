package helper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.commons.lang3.StringEscapeUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class createsinglejsonwithmutipledata {

	private static String connectionurl = "jdbc:sqlserver://LAPTOP-VN1CB8H2\\PATILDINESH19.database.windows.net:1433;"
			+ "database=Employee_Managment;" + "encrypt=true;" + "trustServerCertificate=true;" + "loginTimeout=30;";
	private static  String username = "dinesh19";
	private static  String Password = "Test@123";
	
public static void main(String[] args) throws StreamWriteException, DatabindException, IOException
{
	custinoftable();
	
}
	public static void custinoftable() throws StreamWriteException, DatabindException, IOException
	{
		JSONArray js = new JSONArray();
		
		ResultSet resultSet = null;
		/*create ArryList class Object for class customerdetail and will use it for creating 
		 * multiple json file
		 */
		ArrayList<customerdetail> os= new ArrayList<customerdetail>();
		
		try {
			Connection connection = DriverManager.getConnection(connectionurl, username, Password);
			System.out.println("Coonected to MSSQL server");
			Statement statment = connection.createStatement();
			String selectquery = "select * from CustomerInfo";
			resultSet = statment.executeQuery(selectquery);
			while (resultSet.next()) {
				// below will create object for each row
				customerdetail cs = new customerdetail();
				
				cs.setCustomerID(resultSet.getInt(1));
				cs.setCustomername(resultSet.getString(2));
				cs.setPurchesdate(resultSet.getString(3));
				cs.setAmount(resultSet.getInt(4));
				cs.setLocation(resultSet.getString(5));	
				//will adding created object for each row into arraylist object of class customerdetail
				
				os.add(cs);
				
			}
			// below code will print all ArrayList object vales
			for (int i=0;i<os.size();i++)
			{
				System.out.println("CUSTOMER id:"+i+ ""+os.get(i).getCustomerID());
				System.out.println("CUSTOMER NAME:"+i+" "+os.get(i).getCustomername());
				System.out.println("PURCHES DARE:"+i+""+os.get(i).getCustomername());
				System.out.println("AMOUNT :"+i+" "+os.get(i).getAmount());
				System.out.println("lOCATION:"+i+" "+os.get(i).getLocation());	
			}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error while SQL connectivity");
			e.printStackTrace();
		}
		for(int i=0;i<os.size();i++)
		{
			ObjectMapper o = new ObjectMapper();
			o.writeValue(new File("D:\\Karate Framework\\karateframework\\src\\test\\java\\helper\\"+i+".json"),os.get(i));
			//convert Json object into String use Gson object
			Gson g = new Gson();
			String jsonstring = g.toJson(os.get(i)); // convert json aaray object into string
			js.add(jsonstring);		// add string into json array string
		}
		JSONObject jo = new JSONObject();
		jo.put("data",js); // create data as json obect with json string
		
		//below is code to modify json string with proper json format 
		// remove unescape character from string
		String unescapjsonstring= StringEscapeUtils.unescapeJava(jo.toJSONString());
		System.out.println(unescapjsonstring);
		// replace "{ into {
		String strin1 = unescapjsonstring.replace("\"{", "{");
		System.out.println(strin1);
		//replace }" into }
		String string2 = strin1.replace("}\"", "}");
		System.out.println(string2);
		//create json file using modified string
		
		try(FileWriter file = new FileWriter("D:\\Karate Framework\\karateframework\\src\\test\\java\\helper\\single.json");)
		{
			file.write(string2);
			
		}
	}

}
