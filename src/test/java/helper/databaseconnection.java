package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class databaseconnection
{
	private static String coonectinurl = "jdbc:sqlserver://LAPTOP-VN1CB8H2//MSSQLSERVER01;"
			+ "databse=Employee_Managment;user=LAPTOP-VN1CB8H2\\Dinesh";
	
	public static void addnewjobwithname(String jobname)
	{
		try(Connection connect = DriverManager.getConnection(coonectinurl))
		{
			connect.createStatement().execute(
					"INSERT INTO EMPLOYEE VALUES (0008, 'Chaman', 'BSBS','9856723465', '7634', 'D10','215000')");
		}
		catch (SQLException e)
		{
			e.fillInStackTrace();
		}
	}
}
