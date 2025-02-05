package com.fetch.receipt.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ReceiptResponse bean which will return id value.
 * @author Divya
 *
 */
public class ReceiptResponse {
	private String id;

	@JsonProperty("id")
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
