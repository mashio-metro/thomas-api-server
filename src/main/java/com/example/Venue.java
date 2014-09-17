package com.example;

import com.example.Value.Category;
import com.example.Value.Location;
import com.example.Value.Stat;
import fi.foyt.foursquare.api.entities.Contact;

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
	private Stat stat;
}
