package com.example.Value;

/**
 * @author mukai_masaki on 2014/09/18.
 *         Copyright: CYBER AGNET. INC
 */
public class Category {
	private String id;
	private String name;
	private String pluralName;
	private String shortName;
	private Icon icon;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPluralName() {
		return pluralName;
	}

	public void setPluralName(String pluralName) {
		this.pluralName = pluralName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public Icon getIcon() {
		return icon;
	}

	public void setIcon(Icon icon) {
		this.icon = icon;
	}

	@Override
	public String toString() {
		return "Category{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", pluralName='" + pluralName + '\'' +
				", shortName='" + shortName + '\'' +
				", icon=" + icon +
				'}';
	}
}
