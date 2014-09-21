package com.example.Value.recommentation;

/**
 * @author mukai_masaki on 2014/09/22.
 *         Copyright: CYBER AGNET. INC
 */
public class Like {
	private int count;
	private String summary;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Override
	public String toString() {
		return "Like{" +
				"count=" + count +
				", summary='" + summary + '\'' +
				'}';
	}
}
