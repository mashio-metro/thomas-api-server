package com.example.Value.Venue;

/**
 * @author mukai_masaki on 2014/09/20.
 *         Copyright: CYBER AGNET. INC
 */
public class Icon {

	private String prefix;
	private String suffix;

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	@Override
	public String toString() {
		return "Icon{" +
				"prefix='" + prefix + '\'' +
				", suffix='" + suffix + '\'' +
				'}';
	}
}
