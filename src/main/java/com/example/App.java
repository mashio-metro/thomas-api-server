package com.example;

import freemarker.template.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Optional;

import static com.example.Value.Status.*;
import static spark.Spark.get;
import static spark.SparkBase.setPort;

/**
 * @author mukai_masaki on 2014/08/30.
 *         Copyright: CYBER AGNET. INC
 */
public class App {

	private static Logger log = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		System.out.println(Optional.ofNullable(System.getenv("PORT")).orElse("3456"));
		int port = Integer.parseInt(Optional.ofNullable(System.getenv("PORT")).orElse("3456"));
		setPort(port);
		{
			Configuration conf = new Configuration();
			File f = new File("template");
			conf.setClassForTemplateLoading(App.class, "/template");
		}

		get("/venues/search", "application/json", (req, res) -> {
			FoursquareClient foursquareClient = new FoursquareClient();
			VenueSearchResponse venueSearchResponse = null;
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
		}, new JsonTransformer());

		get("/venues/explore", "application/json", (req, res) -> {
			FoursquareClient foursquareClient = new FoursquareClient();
			VenueExploreResponse venueExploreResponse = null;
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
		}, new JsonTransformer());
	}

}
