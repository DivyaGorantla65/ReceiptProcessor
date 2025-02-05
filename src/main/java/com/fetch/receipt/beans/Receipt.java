package com.fetch.receipt.beans;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Receipt bean to hold receipt json data
 * @author Divya
 *
 */
public class Receipt {

	private String retailer;
	private String purchaseDate;
	private String purchaseTime;
	private String total;
	private ArrayList<Item> items;

	@JsonProperty("retailer")
	public String getRetailer() {
		return this.retailer;
	}

	public void setRetailer(String retailer) {
		this.retailer = retailer;
	}

	@JsonProperty("purchaseDate")
	public String getPurchaseDate() {
		return this.purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@JsonProperty("purchaseTime")
	public String getPurchaseTime() {
		return this.purchaseTime;
	}

	public void setPurchaseTime(String purchaseTime) {
		this.purchaseTime = purchaseTime;
	}

	@JsonProperty("total")
	public String getTotal() {
		return this.total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	@JsonProperty("items")
	public ArrayList<Item> getItems() {
		return this.items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

}
