package com.example;

import com.example.Value.Venue;
import com.example.Value.VenueResponse;
import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
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

import static com.example.Value.Status.*;

/**
 * foursquareのAPIくためのファサード
 * @author mukai_masaki on 2014/09/17.
 *         Copyright: CYBER AGNET. INC
 */
public class FoursquareClient {

	private Logger log = LoggerFactory.getLogger(FoursquareClient.class);

	private HttpClient httpClient;
	private URIBuilder builder = new URIBuilder();
	private RequestConfig config = RequestConfig.DEFAULT;
	private static final String ENDPOINT = "https://api.foursquare.com/v2";
	private static final String TOKEN = "GUHSNIAB2JFBUNX4JAOQ3MSTCPPRQAOQWZNG2DZMELWHE1XI";
	private static final String VERSION = "20140917";

	public FoursquareClient() {
		this.httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
		this.builder.addParameter("v", VERSION);
		this.builder.addParameter("oauth_token", TOKEN);
	}

	public VenueResponse searchVenue(double lat, double lng, double rad) throws IOException, URISyntaxException {
		builder.setPath(ENDPOINT + "/venues/search");
		builder.addParameter("ll", lng + "," + lat);
		builder.addParameter("radius", ""+rad);
		System.out.println(builder.build());
		HttpGet getMethod = new HttpGet(builder.build());
		HttpResponse res = httpClient.execute(getMethod);
		int responseCode = res.getStatusLine().getStatusCode();
		System.out.println(responseCode);
		String json =  EntityUtils.toString(res.getEntity());
		List<Venue> venueList = new ArrayList<>();
		VenueResponse venueResponse = new VenueResponse();
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
			venueResponse.setStatus(EXIST.getStatus());
		} else {
			venueResponse.setStatus(NOT_EXIST.getStatus());
		}
		venueResponse.setVenues(venueList);
		return venueResponse;
	}
}
