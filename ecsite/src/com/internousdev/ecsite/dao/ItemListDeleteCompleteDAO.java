package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class ItemListDeleteCompleteDAO {
	private DBConnector db= new DBConnector();
	private Connection con = db.getConnection();

	public int deleteItemList() throws SQLException {
		String sql = "DELETE FROM item_info_transaction";
		PreparedStatement preparedStatement;
		int result = 0;
		try {
			preparedStatement = con.prepareStatement(sql);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return result;
	}
}
