package com.example.Value;

import java.util.List;

/**
 * @author mukai_masaki on 2014/09/18.
 *         Copyright: CYBER AGNET. INC
 */
public class Venue {
	private String id;
	private String name;
	private Contact contact;
	private Location location;
	private List<Category> categories;
	private Stats stats;

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

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Stats getStats() {
		return stats;
	}

	public void setStats(Stats stats) {
		this.stats = stats;
	}

	@Override
	public String toString() {
		return "Venue{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", contact=" + contact +
				", location=" + location +
				", categories=" + categories +
				", stats=" + stats +
				'}';
	}
}
