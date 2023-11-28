package com.project.adminvalidationDAO;
import java.util.*;
import java.util.stream.*;

import com.project.pojo.User;

public class UserValidation {
	private Scanner sc;
	private List<User> listuser;
	public UserValidation()
	{
		sc=new Scanner(System.in);
		listuser=new ArrayList<>();
		User u1=new User("venu","venu007","venu@gmail.com",200);
		User u2=new User("pandu","pandu007","pandu@gmail.com",300);
		listuser.add(u1);
		listuser.add(u2);
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
		
	
	public void checkUser()
	{
	
		System.out.println("Enter Your Username");
		String uname=sc.next();
		System.out.println("Enter Your Password");
		String pass=sc.next();
		
		boolean y=listuser.stream().anyMatch(data->data.getUsername().equals(uname) && data.getPassword().equals(pass));
		if(y)
		{
			System.out.println("Welcome to Userpage");
		}
		
		else
		{
			System.out.println("Check Details.........");
			System.exit(0);
		}
		}
	
	public void register()
	{
		System.out.println("Enter your username");
		String newname=sc.next();
		System.out.println("Enter your password");
		String newpass=sc.next();
		System.out.println("Enter your email");
		String newemail=sc.next();
		boolean y=listuser.stream().anyMatch(s->s.getUsername().equals(newname) && s.getUsername().equals(newpass));
		if(y)
		{
			System.out.println("User already exits");
		}
		else
		{
		      User u3=new User(newname,newpass,newemail,100);
		      listuser.add(u3);
		      System.out.println("Sucessfully registered..");
		      System.out.println("100 Supercoins is addedv");
		}
		
	}
	
	
		
	}
	
	
	


