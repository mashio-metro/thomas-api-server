package com.example;

import com.example.Value.Venue.Venue;
import com.example.Value.recommentation.RecommendedGroup;
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

	public VenueSearchResponse searchVenue(double lat, double lng, double rad) throws IOException, URISyntaxException {
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


	public VenueExploreResponse exploreVenue(double lat, double lng, double rad) throws IOException, URISyntaxException {
		builder.setPath(ENDPOINT + "/venues/explore");
		builder.addParameter("ll", lng + "," + lat);
		builder.addParameter("radius", ""+rad);
		HttpGet getMethod = new HttpGet(builder.build());
		HttpResponse res = httpClient.execute(getMethod);
		int responseCode = res.getStatusLine().getStatusCode();
		String json =  EntityUtils.toString(res.getEntity());
		JSONObject obj = null;
		JSONArray groupJsonArray = null;
		List<RecommendedGroup> groupList = new ArrayList<>();
		VenueExploreResponse response = new VenueExploreResponse();
		try {
			obj = new JSONObject(json);
			System.out.println(obj);
			groupJsonArray = obj.getJSONObject("response").getJSONArray("groups");
		} catch (JSONException e) {
			log.error("", e);
		}
		for (int i = 0; i < groupJsonArray.length(); i++) {
			JSONObject groupJson = null;
			try {
				groupJson = groupJsonArray.getJSONObject(i);
			} catch (JSONException e) {
				log.error("", e);
			}
			RecommendedGroup group = new Gson().fromJson(groupJson.toString(), RecommendedGroup.class);
			System.out.println(group);
			groupList.add(group);
		}
		response.setGroups(groupList);
		return response;
	}
}
