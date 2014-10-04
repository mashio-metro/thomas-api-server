package com.example.route;

import com.example.FoursquareClient;
import com.example.VenueSearchResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.Optional;

/**
 * @author mukai_masaki on 2014/10/05.
 *         Copyright: CYBER AGNET. INC
 */
public class SearchRoute implements Route {

	private static Logger log = LoggerFactory.getLogger(SearchRoute.class);

	@Override
	public Object handle(Request req, Response res) {
		FoursquareClient foursquareClient = new FoursquareClient();
		VenueSearchResponse venueSearchResponse;
		double lat = 0;
		double lng = 0;
		double rad = 0;
		try {
			lat = Double.parseDouble(Optional.ofNullable(req.queryParams("lat")).orElse(""));
			lng = Double.parseDouble(Optional.ofNullable(req.queryParams("lng")).orElse(""));
			rad = Double.parseDouble(Optional.ofNullable(req.queryParams("rad")).orElse(""));
			venueSearchResponse = foursquareClient.searchVenue(lat, lng, rad);
		} catch (Exception e) {
			log.error("lat = " + lat + ", lng = " + lng + ", rad = " + rad, e);
			venueSearchResponse = new VenueSearchResponse();
			venueSearchResponse.setStatus(99);
			return venueSearchResponse;
		}
		return venueSearchResponse;
	}

}
