package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.dto.BuyItemCompleteDTO;
import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class BuyItemCompleteDAO {

	DBConnector db = new DBConnector();
	Connection con = db.getConnection();
	DateUtil dateUtil = new DateUtil();
	public String itemCount;
	boolean itemFlg;
	int newCount;

	//		処理ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー-------------------------------------

	public int stockUpdate(String item_id, String usercount) throws SQLException {
		try {
			String subsql = " SELECT item_stock FROM  item_info_transaction  "
					+ "  WHERE id =  ?";
			PreparedStatement subps = con.prepareStatement(subsql);
			subps.setInt(1, Integer.parseInt(item_id));
			ResultSet rs = subps.executeQuery();
			BuyItemCompleteDTO dto = new BuyItemCompleteDTO();
			while (rs.next()) {
				dto.setCount(rs.getString("item_stock"));
			}

			int newCount = Integer.parseInt(dto.getCount().toString()) - Integer.parseInt(usercount);

			return newCount;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return newCount;
	}

	//		アップデートメソーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
	public void itemStockUpdate(String item_transaction_id, int newCount) throws SQLException {
		try {
			String sqlCount = " UPDATE item_info_transaction  SET item_stock = ?"
					+ " WHERE id = ?";

			PreparedStatement psCount = con.prepareStatement(sqlCount);
			psCount.setString(1, String.valueOf(newCount));
			psCount.setString(2, item_transaction_id);
			psCount.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//		ユーザーの購入情報格納ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー

	public boolean buyItemInfo(String item_transaction_id, String total_price,
			String total_count, String user_master_id, String pay) throws SQLException {
		try {
			String sql = "INSERT INTO user_buy_item_transaction "
					+ " (item_transaction_id, total_price, total_count, user_master_id,pay, insert_date) "
					+ " VALUES(?,?,?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, total_price);
			ps.setString(3, total_count);
			ps.setString(4, user_master_id);
			ps.setString(5, pay);
			ps.setString(6, dateUtil.getDate());
			ps.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		boolean userInfoInsert = true;
		return userInfoInsert;
	}
}
