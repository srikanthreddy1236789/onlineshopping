package com.training.DAOdatabase;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.dataconnect.DataConnect;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class Validation {
	private Connection con;
	private java.sql.PreparedStatement stat;
	private Scanner sc;
	static double supercoins;
	static String namee;
	static String pass;
	public Validation()
	{
		con=DataConnect.getConnect();
		sc=new Scanner(System.in);
	}
	public void userValid() throws SQLException
	{
		System.out.println("Enter the User Name");
		String name=sc.next();
		namee=name;
		System.out.println("Enter the Password");
		String Passs=sc.next();
		pass=Passs;
		stat=con.prepareStatement("select * from user where username=? and password=?");
		stat.setString(1, name);
		stat.setString(2, Passs);
		java.sql.ResultSet res=stat.executeQuery();
		if(res.next())
		{
			//name=res.getString(1);
			//pass=res.getString(2);
			supercoins=res.getDouble(4);
			System.out.println("Welcome to User Page");
		}
		else
		{
			System.out.println("Invalid Details");
			System.exit(0);
		}
	}
	public void checkAdmin()
	{

		System.out.println("Enter Your Username");
		String uname=sc.next();
		System.out.println("Enter Your Password");
		String pass=sc.next();
		if(uname.equals("admin") && pass.equals("admin"))
		{
			System.out.println("Welcome to admin page");
			
		}
		else
		{
			System.out.println("Invalid Details");
			System.exit(0);
		}
	}
	public void newRegister() throws SQLException
	{
		System.out.println("Enter the Username");
		String nuser=sc.next();
		System.out.println("Enter the passWord");
		String npass=sc.next();
		System.out.println("Enter the Email");
		String nmail=sc.next();
		stat=con.prepareStatement("select * from user where username=? and password=?");
		stat.setString(1, nuser);
		stat.setString(2, npass);
		java.sql.ResultSet r=stat.executeQuery();
		if(r.next())
		{
			System.out.println("Already Register");
			
		}
		else
		{
			stat=con.prepareStatement("insert into user values(?,?,?,?)");
			stat.setString(1, nuser);
			stat.setString(2, npass);
			stat.setString(3, nmail);
			stat.setDouble(4, 100);
			int re=stat.executeUpdate();
			if(re>0) 
			{
				System.out.println("Sucessfully added and You got 100 SuperCoins");
				
			}
			
		}
	}
	
	
	

}
