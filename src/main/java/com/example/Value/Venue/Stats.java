package com.example.Value.Venue;

/**
 * @author mukai_masaki on 2014/09/18.
 *         Copyright: CYBER AGNET. INC
 */
public class Stats {
	private int checkinsCount;
	private int usersCount;
	private int tipCount;

	public int getCheckinsCount() {
		return checkinsCount;
	}

	public void setCheckinsCount(int checkinsCount) {
		this.checkinsCount = checkinsCount;
	}

	public int getUsersCount() {
		return usersCount;
	}

	public void setUsersCount(int usersCount) {
		this.usersCount = usersCount;
	}

	public int getTipCount() {
		return tipCount;
	}

	public void setTipCount(int tipCount) {
		this.tipCount = tipCount;
	}

	@Override
	public String toString() {
		return "Stat{" +
				"checkinsCount=" + checkinsCount +
				", usersCount=" + usersCount +
				", tipCount=" + tipCount +
				'}';
	}
}
