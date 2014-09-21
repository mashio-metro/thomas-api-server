package com.example.Value.recommentation;

import com.example.Value.Venue.Venue;

import java.util.List;

/**
 * @author mukai_masaki on 2014/09/22.
 *         Copyright: CYBER AGNET. INC
 */
public class Recommendation {

	private Reason reasons;
	private Venue venue;
	private List<Tip> tips;

	public Reason getReasons() {
		return reasons;
	}

	public void setReasons(Reason reasons) {
		this.reasons = reasons;
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	public List<Tip> getTips() {
		return tips;
	}

	public void setTips(List<Tip> tips) {
		this.tips = tips;
	}

	@Override
	public String toString() {
		return "Recommendation{" +
				"reason=" + reasons +
				", venue=" + venue +
				", tips=" + tips +
				'}';
	}
}
