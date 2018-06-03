package com.connexion;

import java.sql.Connection;
import java.sql.DriverManager;



public class Connexion {
	
	public static Connection connection(){
		String url = "jdbc:mysql://localhost/mtp-db";
		String user ="root";
		String password = "";
		Connection con;
		try {
			//charger driver
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("driver ok");
		//Etablir connexion
		con = DriverManager.getConnection(url,user,password);
		System.out.println("connexion ok");
		return con;
	}catch(Exception e) {
		e.printStackTrace();
	}
		return null;

}
}
