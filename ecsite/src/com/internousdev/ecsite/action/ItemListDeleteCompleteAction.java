package com.internousdev.ecsite.action;

import java.sql.SQLException;

import com.internousdev.ecsite.dao.ItemListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListDeleteCompleteAction extends ActionSupport{
	private String message;

	//	商品情報の削除

	public String execute() throws SQLException {
		String result = ERROR;
		ItemListDeleteCompleteDAO itemListDeleteCompleteDAO = new ItemListDeleteCompleteDAO();
		int res = itemListDeleteCompleteDAO.deleteItemList();
		if(res > 0) {
			setMessage("商品を正しく削除しました");
		} else {
			setMessage("商品の削除に失敗しました");
		}
		result = SUCCESS;
		return result;
	}

//	getter setter -------------------------------

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}



}
