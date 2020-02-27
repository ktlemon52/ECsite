package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.mysql.jdbc.PreparedStatement;

public class UserListDeleteCompleteDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public int deleteUserList() throws SQLException {
		String sql = "DELETE FROM login_user_transaction where admin_flg is null or admin_flg <> '1'";
		PreparedStatement preparedStatement;
		int result =0;
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return result;
	}
}