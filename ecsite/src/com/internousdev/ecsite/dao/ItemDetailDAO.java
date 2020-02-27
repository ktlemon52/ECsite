package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemDetailDAO {

	public void execute() throws SQLException {
		String itemId;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ItemInfoDTO itemInfoDTO = new ItemInfoDTO();
		String sql = "SELECT * from item_info_transaction where id = ? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, itemId);
		ResultSet rs = ps.executeQuery();

		while(rs.next()) {
			itemInfoDTO.setId(rs.getString("id"));
			itemInfoDTO.setItemName(rs.getString("item_name"));
			itemInfoDTO.setItemPrice(rs.getString("item_price"));
			itemInfoDTO.setItemStock(rs.getString("item_stock"));
			itemInfoDTO.setInsert_date(rs.getString("insert_date"));
			itemInfoDTO.setUpdate_date(rs.getString("update_date"));

		}

	}
}
