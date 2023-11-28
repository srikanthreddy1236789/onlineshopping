package com.project.service;


import java.sql.SQLException;
import java.util.*;

import com.project.adminvalidationDAO.ProductDetails;
import com.project.adminvalidationDAO.UserValidation;
import com.training.DAOdatabase.DatabaseDAO;
import com.training.DAOdatabase.Validation;

public class DatabaseService {
	Scanner sc;
	DatabaseDAO data;
	Validation uservalid;
	public DatabaseService() throws SQLException
	{
		sc=new Scanner(System.in);
		data=new DatabaseDAO();
		uservalid=new Validation();
		
		
	}
	public void admin() throws SQLException
	{
		uservalid.checkAdmin();
		String choice="y";
		int ch=0;
		while(choice.equals("y"))
		{
			System.out.println("Enter your Choice");
			System.out.println("1. Insert Product Detais");
			System.out.println("2. List of Products");
			System.out.println("3. Search By Products  Id");
			System.out.println("4. Search By ProductName");
			System.out.println("5. Search By Category");
			System.out.println("6. Total Amount Spend By admin");
			System.out.println("7. Profit for Selling");
			System.out.println("8.  exit");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				data.insert();
				break;
			case 2:
				data.display();
				break;
			case 3:
				data.searchById();
				break;
			case 4:
				data.searchByName();
				break;
			case 5:
				data.searchByCategory();
				break;
			case 6:
				data.totalAmount();
				break;
			case 7:
				data.profitByCategory();
				break;
			case 8:
				System.exit(0);
				
			}
			System.out.println("Do you want to continue(y/n)");
			choice=sc.next();
				
				
			
			}
		
		}
	public void User() throws SQLException
	{
		uservalid.userValid();
		data.display();
		String choice="y";
		int ch=0;
		while(choice.equals("y")){
			System.out.println("Enter your Choice");
			System.out.println("1. sort by Price");
			System.out.println("2. check by category");
			System.out.println("3   purchase");
			System.out.println("4. exit");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				//proddetails.sortByPrice();
				data.sortByPrice();
				break;
			case 2:
				//proddetails.category();
				data.searchByCategory();
				break;
			case 3:data.purchase();
			       break;
			case 4:data.totalPurchase();
				System.exit(0);
			
			}
			System.out.println("Do you Want to Continue(y/n)");
			choice=sc.next();
			
				}
		
		
	}
	public void Register() throws SQLException
	{
		uservalid.newRegister();
			
	/*	//proddetails.display();
		String choice="y";
		int ch=0;
		while(choice.equals("y")){
			System.out.println("Enter your Choice");
			System.out.println("1. sort by Price");
			System.out.println("2. check by category");
			System.out.println("3   purchase");
			System.out.println("3. exit");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				//proddetails.sortByPrice();
				data.sortByPrice();
				break;
			case 2:
				//proddetails.category();
				data.searchByCategory();
				break;
			case 3:data.purchase();
			       break;
			case 4:data.totalPurchase();
				System.exit(0);
			
			}
			System.out.println("Do you Want to Continue(y/n)");
			choice=sc.next();
			
				}*/
		
		
	}
	public static void main(String[] args) throws SQLException {
		DatabaseService d=new DatabaseService();
		//d.User();
		d.Register();
		
	}
	

	
	}
	
	
	



