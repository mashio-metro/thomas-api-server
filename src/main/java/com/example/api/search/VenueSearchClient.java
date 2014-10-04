package com.example.api.search;

import com.example.api.FoursquareClient;
import com.example.value.Venue.Venue;
import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static com.example.value.Status.EXIST;
import static com.example.value.Status.NOT_EXIST;

/**
 * @author mukai_masaki on 2014/10/05.
 *         Copyright: CYBER AGNET. INC
 */
public class VenueSearchClient extends FoursquareClient {

	private static final Logger log = LoggerFactory.getLogger(VenueSearchClient.class);

	public VenueSearchResponse searchVenue(double lat, double lng, double rad) throws IOException, URISyntaxException {
		builder.setPath(ENDPOINT + "/venues/search");
		builder.addParameter("ll", lng + "," + lat);
		builder.addParameter("radius", "" + rad);
		System.out.println(builder.build());
		HttpGet getMethod = new HttpGet(builder.build());
		HttpResponse res = httpClient.execute(getMethod);
		int responseCode = res.getStatusLine().getStatusCode();
		System.out.println(responseCode);
		String json = EntityUtils.toString(res.getEntity());
		List<Venue> venueList = new ArrayList<>();
		VenueSearchResponse venueSearchResponse = new VenueSearchResponse();
		try {
			JSONObject obj = new JSONObject(json);
			System.out.println(obj);
			JSONArray venueJsonArray = obj.getJSONObject("response").getJSONArray("venues");
			for (int i = 0; i < venueJsonArray.length(); i++) {
				JSONObject venueJson = venueJsonArray.getJSONObject(i);
				Venue venue = new Gson().fromJson(venueJson.toString(), Venue.class);
				venueList.add(venue);
			}
		} catch (JSONException e) {
			log.error("json=" + json, e);
		}
		if (!venueList.isEmpty()) {
			venueSearchResponse.setStatus(EXIST.getStatus());
		} else {
			venueSearchResponse.setStatus(NOT_EXIST.getStatus());
		}
		venueSearchResponse.setVenues(venueList);
		return venueSearchResponse;
	}

}
