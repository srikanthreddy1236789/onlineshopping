package com.project.cilent;

import java.sql.SQLException;

import com.project.menu.ProductMenu;

public class appMain  extends Thread{
	public void run()
	{   
		ProductMenu p;
		try {
			p = new ProductMenu();
			Thread.sleep(2000);
			
			p.displayMenu();
		} catch (SQLException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) throws SQLException {
		appMain app=new appMain();
		app.run();
		
		
	}

}
