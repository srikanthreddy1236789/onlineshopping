package com.project.menu;
import java.sql.SQLException;
import java.util.*;

import com.project.service.DatabaseService;
import com.project.service.ProductService;

public class ProductMenu {
	Scanner sc;
	//ProductService prodsc;
	DatabaseService service;
	public ProductMenu() throws SQLException
	{
		sc=new Scanner(System.in);
		//prodsc=new ProductService();
		service=new DatabaseService();
		
	}
	public void displayMenu() throws SQLException
	{
		String choice="y";
		int ch=0;
		while(choice.equals("y")){
			System.out.println("Enter Your Choice");
			System.out.println("1. Admin Account");
			System.out.println("2. User Account");
			System.out.println("3. New Register");
			System.out.println("4. Exit");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				//prodsc.admin();
				service.admin();
				break;
			case 2:
				//prodsc.User();
				service.User();
				break;
			case 3:
				//prodsc.Register();
				service.Register();
				 break;
			case 4:
				System.exit(0);
			
			}
			System.out.println("Do you Want to continue(y/n)");
			choice=sc.next();
			
				}
	}
	}
