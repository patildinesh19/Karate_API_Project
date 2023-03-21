package helper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.minidev.json.JSONObject;

public class SQLDatabaseConnection {

    // Connect to your database.
    // Replace server name, username, and password with your credentials
	private static String connectionUrl =
            "jdbc:sqlserver://LAPTOP-VN1CB8H2\\PATILDINESH19.database.windows.net:1433;"
            + "database=Employee_Managment;"
            + "encrypt=true;"
            + "trustServerCertificate=true;"
            + "loginTimeout=30;";
  private static   String username ="dinesh19";
	private static  String Password ="Test@123";
	
    public static void executeinserquery(String ID, String name) 
    {    
        int resultSet = 0 ;
        try (Connection connection = DriverManager.getConnection(connectionUrl,username,Password);
                Statement statement = connection.createStatement();) {
            // Create and execute a SELECT SQL statement.
            String selectSql = "INSERT INTO EMPLOYEE VALUES ("+ID+", '"+name+"', 'Pune','6787688888', '45', 'QA','2000000')";
            resultSet = statement.executeUpdate(selectSql);
            // Print results from select statement            
           }
      
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
   //below method execute query and retuen result in table formate
    public static void executeseletquery(String name) 
    {    
        ResultSet resultSet = null;
        try (Connection connection = DriverManager.getConnection(connectionUrl,username,Password);
                Statement statement = connection.createStatement();) {
            // Create and execute a SELECT SQL statement.
            String selectSql = "select * from EMPLOYEE where Emp_Name like '"+name+"'";
            resultSet = statement.executeQuery(selectSql);
            // Print results from select statement            
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1)+" " 
                					+resultSet.getString(2) + " " 
                					+ resultSet.getString(3) + " "
                					+ resultSet.getString(4)+" "
                					+ resultSet.getString(5)+" "
                					+ resultSet.getString(6)+" "
                					+ resultSet.getString(7));
            }
          }
      
        catch (SQLException e) {
            e.printStackTrace();
        }
               
    }
    //below method execute query and convert result set into JSON object format
    public static JSONObject getvaluefromqueryandconvertintojson(String name)
    {
    	JSONObject jsonobject = new JSONObject();
    	ResultSet resultSet = null;
        try (Connection connection = DriverManager.getConnection(connectionUrl,username,Password);
                Statement statement = connection.createStatement();) {
            // Create and execute a SELECT SQL statement.
            String selectSql = "select * from EMPLOYEE where Emp_Name like '"+name+"'";
            resultSet = statement.executeQuery(selectSql);
            
            while (resultSet.next())
            {
            	jsonobject.put("ID", resultSet.getString(1));
            	jsonobject.put("EMP_NAME", resultSet.getString(2));
            	jsonobject.put("EMP_Address", resultSet.getString(3));
            	jsonobject.put("EMP_PHONE", resultSet.getString(4));
            	jsonobject.put("Dept_No", resultSet.getString(5));
            	jsonobject.put("Dept_Name", resultSet.getString(6));
            	jsonobject.put("Salary", resultSet.getString(7));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        } 
        return jsonobject;
    }
}