package com.training.DAOdatabase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dataconnect.DataConnect;
import com.project.pojo.ProductDao;

public class DatabaseDAO {
	private Connection con;
	private java.sql.PreparedStatement stat;
	private Scanner sc;
	private List<ProductDao> list;
	private List<ProductDao>  lst;
	double profit;
	double profit1;
	String str2;
	Savepoint sp;
	public DatabaseDAO() throws SQLException
	{
		con=DataConnect.getConnect();
		sc=new Scanner(System.in);
		list=new ArrayList<ProductDao>();
		lst=new ArrayList<ProductDao>();
		
		stat=con.prepareStatement("Select * from product");
		ResultSet re=stat.executeQuery();
	    while(re.next())
	    {
	    	ProductDao p=new ProductDao();
	    	p.setProductId(re.getInt(1));
	    	p.setProductName(re.getString(2));
	    	p.setAvaliableQuantity(re.getInt(3));
	    	p.setCategory(re.getString(4));
	    	p.setBuyingprice(re.getDouble(5));
	    	p.setSellingprice(re.getDouble(6));
	    	list.add(p);
	    }
		
	}
	public void display() throws SQLException
	{
		/*stat=con.prepareStatement("select * from product");
		ResultSet r=stat.executeQuery();
		while(r.next())
		{
			System.out.println(r.getInt(1));
			System.out.println(r.getString(2));
			
			System.out.println(r.getString(4));
			System.out.println(r.getInt(3));
		}*/
		for(ProductDao pr:list)
		{
			System.out.println("product id is "+pr.getProductId());
			System.out.println("product name is  "+pr.getProductName());
			System.out.println("product Category is  "+pr.getCategory());
			System.out.println("Quantity is  "+pr.getAvaliableQuantity());
			System.out.println("Selling price is "+pr.getSellingprice());
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		}
		
	}
	
	public void insert() throws SQLException
	{
		stat=con.prepareStatement("insert into product values(?,?,?,?,?,?)");
		System.out.println("Enter the Product id");
		stat.setInt(1, sc.nextInt());
		System.out.println("Enter the product NAme");
		stat.setString(2, sc.next());
		System.out.println("Enter the Quability");
		stat.setInt(3, sc.nextInt());
		System.out.println("Enter the Category");
		stat.setString(4, sc.next());
		System.out.println("Enter the Buying price");
		double bp=sc.nextDouble();
		stat.setDouble(5, bp);
	    stat.setDouble(6, (bp*0.5)+bp);
	    int res=stat.executeUpdate();
	    if(res>0)
	    {
	    	System.out.println("Successfully Inserted");
	    }
	    else
	    {
	    	System.out.println("NOT Inserted");
	    }
		
		
	}
	public  void searchById() 
	{
		System.out.println("Enter the ID");
		int id=sc.nextInt();
		list.stream().filter(d->d.getProductId()==id).forEach(a->
		{
			System.out.println("Product name is "+a.getProductName());
			System.out.println("Selling price is "+a.getSellingprice());
			System.out.println("Buying price is "+a.getBuyingprice());
		}
		);	
	}
	public void searchByName()
	{
		System.out.println("Enter the name");
		String str=sc.next();
		list.stream().filter(r->r.getProductName().equals(str)).forEach(b->
		{
			System.out.println("Prouct name is "+b.getProductName());
			System.out.println("Quanity is "+b.getAvaliableQuantity());
			System.out.println("Selling price is  "+b.getSellingprice());
			System.out.println("category is "+b.getCategory());
		});
	}
	public void searchByCategory()
	{
		boolean value=false;
		System.out.println("Enter the Category");
		String str=sc.next();
		list.stream().filter(r->r.getCategory().equals(str)).forEach(b->
		{
			System.out.println("Prouct name is "+b.getProductName());
			System.out.println("Quanity is "+b.getAvaliableQuantity());
			System.out.println("Selling price is  "+b.getSellingprice());
			System.out.println("category is "+b.getCategory());
			
		});
	}
	public void totalAmount()
	{
		double totalamount=0;
		for(ProductDao e:list)
		{
			totalamount=totalamount+e.getBuyingprice();
		}
		System.out.println("Total Amount is "+totalamount);
	}
	public void profitByCategory()
	{
		System.out.println("Enter the Category");
		String cat=sc.next();
		
		list.stream().filter(s-> s.getCategory().equals(cat)).forEach(l->
		{
			profit=l.getSellingprice()-l.getBuyingprice();
			profit1=profit+profit1;
			 str2=l.getCategory();
			
			
			
		});
		
		if(profit1>0)
		{
			System.out.println("profit for "+str2+"  is " +profit1);
		}
		else
		{
			System.out.println("no such type of category");
		}
	}
	public void sortByPrice() throws SQLException
	{
		stat=con.prepareStatement("select * from product order by sellingPrice");
		ResultSet rs=stat.executeQuery();
		while(rs.next())
		{
			System.out.println("product id is "+rs.getInt(1));
			System.out.println("product name is "+rs.getString(2));
			System.out.println("Selling Price is "+rs.getDouble(6));
		}
	}
	public void purchase() throws SQLException
	{
		con.setAutoCommit(false);
		sp=con.setSavepoint();
		String choice="y";
		int ch=0;
		while(choice.equalsIgnoreCase("y"))
		{
		System.out.println("1.purchase product by using id");
		System.out.println("2.purchase product by using name");
		System.out.println("3.    exit");
		ch=sc.nextInt();
		switch(ch)
		{
		case 1:System.out.println("Enter How Many products do you want to purchase");
		       int c=sc.nextInt();
		       for(int i=0;i<c;i++)
		       {
			   System.out.println("enter the product id   ");
		       int id=sc.nextInt();
		       stat=con.prepareStatement("update product set avaliableQuantity=avaliableQuantity-1 where productid=?");
		       stat.setInt(1, id);
		       stat.executeUpdate();
		      
		       stat=con.prepareStatement("select * from product where productid=?");
		       stat.setInt(1, id);
		       ProductDao p1=new ProductDao();
		       ResultSet wr=stat.executeQuery();
		       if(wr.next())
		       {
		    	   p1.setProductId(wr.getInt(1));
		    	   p1.setProductName(wr.getString(2));
		    	   p1.setAvaliableQuantity(wr.getInt(3));
		    	   p1.setSellingprice(wr.getDouble(6));
		    	   lst.add(p1);
		    	   System.out.println("Added to cart");
		       }
		       else
		       {
		    	   System.out.println("Wrong id");
		       }
		       }
		       break;
		case 2:System.out.println("Enter How Many products do you want to purchase");
	       int cc=sc.nextInt();
	       for(int i=0;i<cc;i++)
	       {
			System.out.println("enter the product name   ");
	       String itr=sc.next();
	       stat=con.prepareStatement("update product set avaliableQuantity=avaliableQuantity-1 where productname=?");
	       stat.setString(1, itr);
	       stat.executeUpdate();
	       stat=con.prepareStatement("select * from product where productname=?");
	       stat.setString(1, itr);
	       ProductDao p2=new ProductDao();
	       ResultSet rw=stat.executeQuery();
	       if(rw.next())
	       {
	    	   p2.setProductId(rw.getInt(1));
	    	   p2.setProductName(rw.getString(2));
	    	   p2.setAvaliableQuantity(rw.getInt(3));
	    	   p2.setSellingprice(rw.getDouble(6));
	    	   lst.add(p2);
	    	   System.out.println("added to cart");
	       }
	       else
	       {
	    	   System.out.println("Wrong Name");
	       }
	       }
	       break;
		case 3:totalPurchase();
		       System.exit(0);
		    	   
		
		}
		System.out.println("Do you want to continue(y/n)");
		choice=sc.next();
		}
	}
	public void totalPurchase() throws SQLException
	{
		double purchaseAmount=0;
		for(ProductDao l:lst)
		{
			purchaseAmount=purchaseAmount+l.getSellingprice();
		}
		System.out.println("TOTAL AMOUNT IS "+purchaseAmount);
		System.out.println("you have "+Validation.supercoins+" supercoins");
		System.out.println("How many Super coins do you wnt to use");
		double s=sc.nextDouble();
		if(s<=Validation.supercoins)
		{
			
			double left=(Validation.supercoins-s);
			System.out.println("Supercoins left   "+left);
			stat=con.prepareStatement("update user set supercoins=? where username=? and password=?");
			stat.setDouble(1, left);
			System.out.println(Validation.namee);
		     stat.setString(2, Validation.namee);
			 stat.setString(3, Validation.pass);
			int result=stat.executeUpdate();
			double discount=(s/100)*5;
			double total=purchaseAmount-discount;
			System.out.println("Amount after discount  is "+total);
			con.commit();
			
		}
		else
		{
			System.out.println("You dont have that much of coins");
			con.rollback();
		}
		
	}
	
	

}
