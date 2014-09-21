package com.example;

import com.example.Value.Status;
import com.example.Value.recommentation.RecommendedGroup;

import java.util.List;

/**
 * @author mukai_masaki on 2014/09/22.
 *         Copyright: CYBER AGNET. INC
 */
public class VenueExploreResponse {
	private Status status;
	private List<RecommendedGroup> groups;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<RecommendedGroup> getGroups() {
		return groups;
	}

	public void setGroups(List<RecommendedGroup> groups) {
		this.groups = groups;
	}

	@Override
	public String toString() {
		return "VenueExploreResponse{" +
				"status=" + status +
				", groups=" + groups +
				'}';
	}
}
