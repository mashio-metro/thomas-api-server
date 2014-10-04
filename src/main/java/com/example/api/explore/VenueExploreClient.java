package com.example.api.explore;

import com.example.api.FoursquareClient;
import com.example.value.Venue.Photo;
import com.example.value.Venue.Photos;
import com.example.value.recommentation.RecommendedGroup;
import com.google.appengine.api.urlfetch.HTTPResponse;
import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
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

/**
 * @author mukai_masaki on 2014/10/05.
 *         Copyright: CYBER AGNET. INC
 */
public class VenueExploreClient extends FoursquareClient {

	private Logger log = LoggerFactory.getLogger(VenueExploreClient.class);

	public VenueExploreResponse exploreVenue(double lat, double lng, double rad) throws IOException, URISyntaxException {
		builder.setPath(ENDPOINT + "/venues/explore");
		builder.addParameter("venuePhotos", "1");
		builder.addParameter("ll", lng + "," + lat);
		builder.addParameter("radius", ""+rad);
		builder.addParameter("venuePhotos", "1");
		HttpGet getMethod = new HttpGet(builder.build());
		HttpResponse res = httpClient.execute(getMethod);
		String json =  EntityUtils.toString(res.getEntity());
		JSONObject obj;
		JSONArray groupJsonArray = null;
		List<RecommendedGroup> groupList = new ArrayList<>();
		VenueExploreResponse response = new VenueExploreResponse();
		System.out.println(json);
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
