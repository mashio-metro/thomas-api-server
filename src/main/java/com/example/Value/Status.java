package com.example.value;

/**
 * @author mukai_masaki on 2014/09/22.
 *         Copyright: CYBER AGNET. INC
 */
public enum Status {

	ERROR(99), EXIST(100), NOT_EXIST(101);

	private int status;

	Status(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

}
