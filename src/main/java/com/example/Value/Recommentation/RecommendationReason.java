package com.example.Value.recommentation;

/**
 * @author mukai_masaki on 2014/09/22.
 *         Copyright: CYBER AGNET. INC
 */
public class RecommendationReason {

	private String summary;
	private String type;

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "RecommendationReason{" +
				"summary='" + summary + '\'' +
				", type='" + type + '\'' +
				'}';
	}
}
