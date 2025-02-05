package com.fetch.receipt.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * getPoints response bean which will hold totalPoints
 * @author Divya
 *
 */
public class PointsResponse {

	private String totalPoints ;

	@JsonProperty("totalPoints")
	public String getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(String totalPoints) {
		this.totalPoints = totalPoints;
	}
	
	
}
