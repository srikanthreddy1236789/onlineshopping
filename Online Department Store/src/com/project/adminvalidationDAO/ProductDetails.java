package com.project.adminvalidationDAO;
import java.util.*;
import java.util.stream.*;

import com.project.pojo.Item;
import com.project.pojo.Product;
import com.project.pojo.SortByPrice;

public class ProductDetails {
	private Scanner sc;
	double totalamount;
	double totalprofit;
	double totalprofit1;
	
	private Map<Integer,Product> proddetails;
	public ProductDetails()
	{
		sc=new Scanner(System.in);
		proddetails=new HashMap<Integer,Product>();
		
		Product p1=new Product();
		p1.setProductId(1);
		p1.setProductName("Mouse");
		p1.setAvaliableQuantity(50);
		p1.setCategory("computer");
		p1.setBuyingPrice(400);
		proddetails.put(1, p1);
		

		Product p2=new Product();
		p2.setProductId(2);
		p2.setProductName("onions");
		p2.setAvaliableQuantity(34);
		p2.setCategory("vegetables");
		p2.setBuyingPrice(40);
		proddetails.put(2, p2);
		

		Product p3=new Product();
		p3.setProductId(3);
		p3.setProductName("monitor");
		p3.setAvaliableQuantity(22);
		p3.setCategory("computer");
		p3.setBuyingPrice(40);
		proddetails.put(3, p3);
		

		Product p4=new Product();
		p4.setProductId(4);
		p4.setProductName("tissues");
		p4.setAvaliableQuantity(12);
		p4.setCategory("toilet");
		p4.setBuyingPrice(404);
		proddetails.put(4, p4);

	}
	/*Item i1=new Item("brush","toiletry", 22222);
	Product p1=new Product(101, i1.getItemname(), 22,(( i1.getBuyingPrice()*0.5)+i1.getBuyingPrice()), i1.getCategory());
	proddetails.put(1, p1);
	Item i2=new Item("onions","vegetables", 30);
	Product p2=new Product(102, i2.getItemname(), 30,(( i2.getBuyingPrice()*0.5)+i2.getBuyingPrice()), i2.getCategory());
	proddetails.put(2, p2);
	Item i3=new Item("rice","grocery", 55);
	Product p3=new Product(103, i3.getItemname(), 100,(( i3.getBuyingPrice()*0.5)+i3.getBuyingPrice()), i3.getCategory());
	proddetails.put(3, p3);
	Item i4=new Item("pen","stationary", 2);
	Product p4=new Product(104, i1.getItemname(), 100,(( i4.getBuyingPrice()*0.5)+i4.getBuyingPrice()), i4.getCategory());
	proddetails.put(4, p4);*/
		

		
		
	
	
	public void display()
	{
		Set<Map.Entry<Integer,Product>> prodd = proddetails.entrySet();
		//prodd.stream().forEach(m->
		for(Map.Entry<Integer, Product> m:prodd)
		{
			System.out.println("product name "+m.getValue().getProductName());
			System.out.println("product category "+m.getValue().getCategory());
			System.out.println("Selling price is "+m.getValue().getSellingPrice());
		}
		
	}
	
	public void adminInsert()
	{
		
		System.out.println("How many products do you insert");
		int noofproducts=sc.nextInt();
		for(int i=0;i<noofproducts;i++)
		{
			Product p=new Product();
			
			System.out.println("Enter Product Id");
			p.setProductId(sc.nextInt());
			System.out.println("Enter Product Name");
			p.setProductName(sc.next());
			System.out.println("Enter the buying price");
			p.setBuyingPrice(sc.nextDouble());
			System.out.println("enter the Quantity");
			p.setAvaliableQuantity(sc.nextInt());
			System.out.println("Enter the category");
			p.setCategory(sc.next());
			p.setSellingPrice((p.getBuyingPrice()*0.5)+p.getBuyingPrice());
			proddetails.put(p.getProductId(), p);
			
			
		}
	}
	public void searchByName()
	{
		System.out.println("Enter the item name");
		String name=sc.next();
		proddetails.entrySet().stream().filter(data->data.getValue().getProductName().equals(name)).forEach(s->
		{
			
				System.out.println("category is "+s.getValue().getCategory());
				System.out.println("Selling price is "+s.getValue().getSellingPrice());
		});
	}
	public void searchById()
	{
		System.out.println("Enter the id for search");
		int id=sc.nextInt();
		proddetails.entrySet().stream().filter(d->d.getValue().getProductId()==id).forEach(a->
		{
			
			    System.out.println("name is "+a.getValue().getProductName());
				System.out.println("category is "+a.getValue().getCategory());
				System.out.println("Selling price is "+a.getValue().getSellingPrice());
			
		});
	}
	public void totalAmount()
	{
		
		Set<Map.Entry<Integer,Product>> pro = proddetails.entrySet();
		pro.stream().map(r->r.getValue().getBuyingPrice()).forEach(j->
		{
			totalamount=totalamount+j;
		});
		System.out.println("Total Amount Spend by the Admin  "+totalamount);
	}
	public void profit()
	{
		System.out.println("Enter the category");
		String cat=sc.next();
		Set<Map.Entry<Integer, Product>> prod=proddetails.entrySet();
		prod.stream().filter(p->p.getValue().getCategory().equals(cat)).forEach(s->
		{
			totalprofit1=s.getValue().getSellingPrice()-s.getValue().getBuyingPrice();
			totalprofit=totalprofit+totalprofit1;
			
		});
		System.out.println("Total profit for Praticular category is "+totalprofit);
	}
	public void category()
	{
		System.out.println("");
		System.out.println("Enter the category");
		String cat=sc.next();
		Set<Map.Entry<Integer, Product>> prod=proddetails.entrySet();
		prod.stream().filter(p->p.getValue().getCategory().equals(cat)).forEach(o->
		{
			System.out.println("products are "+o.getValue().getProductName());
		});
	}
	public void sortByPrice()
	{
		Set<Map.Entry<Integer, Product>> prod=proddetails.entrySet();
		prod.stream().sorted(new SortByPrice()).forEach(q->
		{
			System.out.println("name is "+q.getValue().getItemname());
			System.out.println("price is "+q.getValue().getSellingPrice());
		});
		
	}

	
	

}
