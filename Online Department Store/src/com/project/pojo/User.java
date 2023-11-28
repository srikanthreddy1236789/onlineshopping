package com.project.pojo;

public class User {
	private String username;
	private String emailId;
	private String password;
	private double superCoins;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getSuperCoins() {
		return superCoins;
	}
	public void setSuperCoins(double superCoins) {
		this.superCoins = superCoins;
	}
	public User()
	{
		
	}
	public User(String username,String password,String emailId,double superCoins)
	{
		this.emailId=emailId;
		this.password=password;
		this.username=username;
		this.superCoins=superCoins;
		
		
	}

}
