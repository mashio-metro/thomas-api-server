package com.example.value.Venue;

import java.util.List;

/**
 * @author mukai_masaki on 2014/10/05.
 *         Copyright: CYBER AGNET. INC
 */
public class Photos {
	private int count;
	private List<PhotoGroup> groups;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<PhotoGroup> getGroups() {
		return groups;
	}

	public void setGroups(List<PhotoGroup> groups) {
		this.groups = groups;
	}

	class PhotoGroup {
		private int count;
		private List<Photo> items;
		private String name;
		private String type;

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

		public List<Photo> getItems() {
			return items;
		}

		public void setItems(List<Photo> items) {
			this.items = items;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

	}

}
