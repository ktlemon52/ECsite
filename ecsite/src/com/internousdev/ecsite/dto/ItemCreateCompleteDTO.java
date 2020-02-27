package com.internousdev.ecsite.dto;

public class ItemCreateCompleteDTO {

	private String itemName;
	private String itemPrice;
	private String itemStock;
	private String dateUtil;


	public String getDateUtil() {
		return dateUtil;
	}
	public void setDateUtil(String dateUtil) {
		this.dateUtil = dateUtil;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemStock() {
		return itemStock;
	}
	public void setItemStock(String itemStock) {
		this.itemStock = itemStock;
	}
}
