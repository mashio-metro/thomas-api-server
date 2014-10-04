package com.example.api.photo;

import com.example.api.FoursquareClient;
import com.example.value.Venue.Photo;
import com.example.value.Venue.Photos;
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

/**
 * @author mukai_masaki on 2014/10/05.
 *         Copyright: CYBER AGNET. INC
 */
public class PhotoSearch extends FoursquareClient {

	private Logger log = LoggerFactory.getLogger(PhotoSearch.class);

	private List<Photo> fetchPhotos (String venueId) throws URISyntaxException, IOException {
		builder.setPath(ENDPOINT + "/venues/" + venueId + "/photos");
		builder.addParameter("venuePhotos", "1");
		HttpGet getMethod = new HttpGet(builder.build());
		HttpResponse res = httpClient.execute(getMethod);
		String json =  EntityUtils.toString(res.getEntity());
		JSONObject obj = null;
		JSONArray photoJsonArray = null;
		List<Photo> photoList = new ArrayList<>();
		System.out.println(json);
		try {
			obj = new JSONObject(json);
			System.out.println(obj);
			photoJsonArray = obj.getJSONObject("response").getJSONObject("photos").getJSONArray("items");
		} catch (JSONException e) {
			log.error("", e);
		}
		for (int i = 0; i < photoJsonArray.length(); i++) {
			JSONObject photoJson = null;
			try {
				photoJson = photoJsonArray.getJSONObject(i);
			} catch (JSONException e) {
				log.error("", e);
			}
			Photo photo = new Gson().fromJson(photoJson.toString(), Photo.class);
			System.out.println(photo);
			photoList.add(photo);
		}
		return photoList;
	}

}
