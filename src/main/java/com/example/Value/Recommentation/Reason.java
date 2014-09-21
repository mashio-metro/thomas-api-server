package com.example.Value.recommentation;

import java.util.List;

/**
 * @author mukai_masaki on 2014/09/22.
 *         Copyright: CYBER AGNET. INC
 */
public class Reason {
	private int count;
	private List<RecommendationReason> items;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<RecommendationReason> getItems() {
		return items;
	}

	public void setItems(List<RecommendationReason> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Reason{" +
				"count=" + count +
				", items=" + items +
				'}';
	}
}
