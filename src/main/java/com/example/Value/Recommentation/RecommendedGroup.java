package com.example.value.recommentation;

import java.util.List;

/**
 * @author mukai_masaki on 2014/09/22.
 *         Copyright: CYBER AGNET. INC
 */
public class RecommendedGroup {
	private String type;
	private String name;
	private List<Recommendation> items;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Recommendation> getItems() {
		return items;
	}

	public void setItems(List<Recommendation> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "RecommendedGroup{" +
				"type='" + type + '\'' +
				", name='" + name + '\'' +
				", items=" + items +
				'}';
	}
}
