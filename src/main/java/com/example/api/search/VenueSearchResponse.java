package com.example.api.search;

import com.example.value.Venue.Venue;

import java.util.List;

/**
 * @author mukai_masaki on 2014/09/20.
 *         Copyright: CYBER AGNET. INC
 */
public class VenueSearchResponse {

	private int status;
	private List<Venue> venues;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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
				"status=" + status +
				", venues=" + venues +
				'}';
	}
}
