package com.dataconnect;
import java.sql.*;

import com.mysql.jdbc.Driver;

public class DataConnect {
	private static Connection con;
	private DataConnect()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			//it will load driver class dynamically in your java program
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinestore","root","root");
			System.out.println("Connection Established");
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	public static Connection getConnect()
	{
		DataConnect d=new DataConnect();
		return con;
	}
	

}
