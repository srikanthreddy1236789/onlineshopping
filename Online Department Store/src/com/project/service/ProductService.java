package com.project.service;
import java.util.*;

import com.project.adminvalidationDAO.ProductDetails;
import com.project.adminvalidationDAO.UserValidation;

public class ProductService {
	Scanner sc;
	ProductDetails proddetails;
	UserValidation uservalid;
	public ProductService()
	{
		sc=new Scanner(System.in);
		proddetails=new ProductDetails();
		uservalid=new UserValidation();
		
		
	}
	public void admin()
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
				proddetails.adminInsert();
				break;
			case 2:
				proddetails.display();
				break;
			case 3:
				proddetails.searchById();
				break;
			case 4:
				proddetails.searchByName();
				break;
			case 5:
				proddetails.category();
				break;
			case 6:
				proddetails.totalAmount();
				break;
			case 7:
				proddetails.profit();
				break;
			case 8:
				System.exit(0);
				
			}
			System.out.println("Do you want to continue(y/n)");
			choice=sc.next();
				
				
			
			}
		
		}
	public void User()
	{
		uservalid.checkUser();
		proddetails.display();
		String choice="y";
		int ch=0;
		while(choice.equals("y")){
			System.out.println("Enter your Choice");
			System.out.println("1. sort by Price");
			System.out.println("2. check by category");
			System.out.println("3. exit");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				proddetails.sortByPrice();
				break;
			case 2:
				proddetails.category();
				break;
			case 3:System.exit(0);
			
			}
			System.out.println("Do you Want to Continue(y/n)");
			choice=sc.next();
			
				}
		
		
	}
	public void Register()
	{
		uservalid.register();
			
		//proddetails.display();
		String choice="y";
		int ch=0;
		while(choice.equals("y")){
			System.out.println("Enter your Choice");
			System.out.println("1. sort by Price");
			System.out.println("2. check by category");
			System.out.println("3. exit");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				proddetails.sortByPrice();
				break;
			case 2:
				proddetails.category();
				break;
			case 3:System.exit(0);
			
			}
			System.out.println("Do you Want to Continue(y/n)");
			choice=sc.next();
			
				}
		
		
	}
	

	
	}
	
	
	


