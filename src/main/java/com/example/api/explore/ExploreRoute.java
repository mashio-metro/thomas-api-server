package com.example.api.explore;

import com.example.api.FoursquareClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.Optional;

import static com.example.value.Status.ERROR;

/**
 * @author mukai_masaki on 2014/10/05.
 *         Copyright: CYBER AGNET. INC
 */
public class ExploreRoute implements Route {

	private static Logger log = LoggerFactory.getLogger(ExploreRoute.class);

	@Override
	public Object handle(Request req, Response res) {
		FoursquareClient foursquareClient = new FoursquareClient();
		VenueExploreResponse venueExploreResponse;
		double lat = 0;
		double lng = 0;
		double rad = 0;
		try {
			lat = Double.parseDouble(Optional.ofNullable(req.queryParams("lat")).orElse(""));
			lng = Double.parseDouble(Optional.ofNullable(req.queryParams("lng")).orElse(""));
			rad = Double.parseDouble(Optional.ofNullable(req.queryParams("rad")).orElse(""));
			venueExploreResponse = foursquareClient.exploreVenue(lat, lng, rad);
		} catch (Exception e) {
			log.error("lat = " + lat + ", lng = " + lng + ", rad = " + rad, e);
			venueExploreResponse = new VenueExploreResponse();
			venueExploreResponse.setStatus(ERROR);
			return venueExploreResponse;
		}
		return venueExploreResponse;
	}
}
