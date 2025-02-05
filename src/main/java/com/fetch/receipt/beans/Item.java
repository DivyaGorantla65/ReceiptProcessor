package com.fetch.receipt.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Item Bean to hold item json elements
 * @author Divya
 *
 */
public class Item {

	private String shortDescription;
	private String price;

	@JsonProperty("shortDescription")
	public String getShortDescription() {
		return this.shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	@JsonProperty("price")
	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
