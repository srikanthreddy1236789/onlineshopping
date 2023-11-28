package com.project.pojo;

public class Product extends Item{
	private int productId;
	private String productName;
	private double sellingPrice;
	private int avaliableQuantity;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getSellingPrice() {
		this.sellingPrice=(this.getBuyingPrice()*0.05)+this.getBuyingPrice();
		return sellingPrice;
	}
	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public int getAvaliableQuantity() {
		return avaliableQuantity;
	}
	public void setAvaliableQuantity(int avaliableQuantity) {
		this.avaliableQuantity = avaliableQuantity;
	}
	public Product()
	{
		
	}
	
	public Product(int productId,String productName,int avaliableQuantity,double buyingPrice,double sellingPrice,String category)
	{
		this.productId=productId;
		this.productName=productName;
		this.avaliableQuantity=avaliableQuantity;
		this.buyingPrice=buyingPrice;
		this.sellingPrice=sellingPrice;
		this.category=category;
	}
	

}
