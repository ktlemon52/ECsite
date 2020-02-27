package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware {
	private String message;
	private Map<String, Object> session;
	private BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();

	public String execute() throws SQLException {
//			在庫数 - 購ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
		if (buyItemCompleteDAO.stockUpdate(session.get("id").toString(), session.get("count").toString()) >= 0) {
			System.out.println();
			buyItemCompleteDAO.itemStockUpdate(session.get("id").toString(), buyItemCompleteDAO.stockUpdate(session.get("id").toString(), session.get("count").toString()));
			buyItemCompleteDAO.buyItemInfo(
					session.get("id").toString(),
					session.get("total_price").toString(),
					session.get("count").toString(),
					session.get("login_user_id").toString(),
					session.get("pay").toString());
			String result = SUCCESS;
			return result;
		} else {
			String result = ERROR;
			result = ERROR;
			return result;
		}
	}

	public Map<String, Object> getSession() {
		return this.session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
