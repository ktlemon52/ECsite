package com.internousdev.ecsite.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
//	privateは同一クラスのみのアクセス
//	名前
	private static String driverName = "com.mysql.jdbc.Driver";
//	場所
	private static String url = "jdbc:mysql://localhost/ecsite";

//	ログイン情報
	private static String  user ="root";
	private static String password = "mysql";


	public Connection getConnection() {
		Connection con = null;

		try {
			Class.forName(driverName);
			con = (Connection) DriverManager.getConnection(url,user,password);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}

		return con;
	}
}
