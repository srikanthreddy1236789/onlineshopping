package com.project.pojo;

public class ProductDao {
	private int productId;
	private String productName;
	
	private int avaliableQuantity;
	private String category;
	private double buyingprice;
	private double sellingprice;
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
	public int getAvaliableQuantity() {
		return avaliableQuantity;
	}
	public void setAvaliableQuantity(int avaliableQuantity) {
		this.avaliableQuantity = avaliableQuantity;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getBuyingprice() {
		return buyingprice;
	}
	public void setBuyingprice(double buyingprice) {
		this.buyingprice = buyingprice;
	}
	public double getSellingprice() {
		return sellingprice;
	}
	public void setSellingprice(double sellingprice) {
		this.sellingprice = sellingprice;
	}
	
	
}
