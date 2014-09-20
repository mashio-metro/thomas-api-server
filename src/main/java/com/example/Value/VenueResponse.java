package com.example.Value;

import java.util.List;

/**
 * @author mukai_masaki on 2014/09/20.
 *         Copyright: CYBER AGNET. INC
 */
public class VenueResponse {

	private int responseCode;
	private List<Venue> venues;

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public List<Venue> getVenues() {
		return venues;
	}

	public void setVenues(List<Venue> venues) {
		this.venues = venues;
	}

	@Override
	public String toString() {
		return "VenueResponse{" +
				"responseCode=" + responseCode +
				", venues=" + venues +
				'}';
	}
}
