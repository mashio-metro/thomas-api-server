package com.example.value.Venue;

/**
 * @author mukai_masaki on 2014/09/18.
 *         Copyright: CYBER AGNET. INC
 */
public class Contact {
	private String phone;
	private String formattedPhone;
	private String twitter;

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getFormattedPhone() {
		return formattedPhone;
	}

	public void setFormattedPhone(String formattedPhone) {
		this.formattedPhone = formattedPhone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Contact{" +
				"phone='" + phone + '\'' +
				", formattedPhone='" + formattedPhone + '\'' +
				", twitter='" + twitter + '\'' +
				'}';
	}
}
