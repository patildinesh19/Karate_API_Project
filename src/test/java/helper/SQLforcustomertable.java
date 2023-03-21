package helper;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SQLforcustomertable {

	private static String connectionurl = "jdbc:sqlserver://LAPTOP-VN1CB8H2\\PATILDINESH19.database.windows.net:1433;"
			+ "database=Employee_Managment;" + "encrypt=true;" + "trustServerCertificate=true;" + "loginTimeout=30;";
	private static  String username = "dinesh19";
	private static  String Password = "Dinesh@123";
	
public static void main(String[] args) throws StreamWriteException, DatabindException, IOException
{
	custinoftable();
	
}
	public static void custinoftable() throws StreamWriteException, DatabindException, IOException
	{
		ResultSet resultSet = null;
		//below object will use when query returning only one record and will create one json file
		customerdetail cs= new customerdetail();
		
		try {
			Connection connection = DriverManager.getConnection(connectionurl, username, Password);
			System.out.println("Coonected to MSSQL server");
			Statement statment = connection.createStatement();
			String selectquery = "select TOP 1 * from CustomerInfo";
			resultSet = statment.executeQuery(selectquery);
			while (resultSet.next()) {
				
				cs.setCustomerID(resultSet.getInt(1));
				cs.setCustomername(resultSet.getString(2));
				cs.setPurchesdate(resultSet.getString(3));
				cs.setAmount(resultSet.getInt(4));
				cs.setLocation(resultSet.getString(5));				
			}
			
			System.out.println("CUSTOMER id: "+cs.getCustomerID());
			System.out.println("CUSTOMER NAME: "+cs.getCustomername());
			System.out.println("PURCHES DARE: "+cs.getCustomername());
			System.out.println("AMOUNT : "+cs.getAmount());
			System.out.println("lOCATION: "+cs.getLocation());	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error while SQL connectivity");
			e.printStackTrace();
		}
		ObjectMapper o = new ObjectMapper();
		o.writeValue(new File("D:\\Karate Framework\\karateframework\\src\\test\\java\\helper\\data1.json"),cs);
	}

}
