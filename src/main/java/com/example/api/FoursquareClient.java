package com.example.api;

import com.example.api.explore.VenueExploreClient;
import com.example.api.explore.VenueExploreResponse;
import com.example.api.search.VenueSearchClient;
import com.example.api.search.VenueSearchResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * foursquareのAPIくためのファサード
 * @author mukai_masaki on 2014/09/17.
 *         Copyright: CYBER AGNET. INC
 */
public class FoursquareClient {

	protected HttpClient httpClient;
	protected URIBuilder builder = new URIBuilder();
	protected RequestConfig config = RequestConfig.DEFAULT;
	protected static final String ENDPOINT = "https://api.foursquare.com/v2";
	protected static final String TOKEN = "GUHSNIAB2JFBUNX4JAOQ3MSTCPPRQAOQWZNG2DZMELWHE1XI";
	protected static final String VERSION = "20140917";

	public FoursquareClient() {
		this.httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
		this.builder.addParameter("v", VERSION);
		this.builder.addParameter("oauth_token", TOKEN);
	}

	public VenueSearchResponse searchVenue(double lat, double lng, double rad) throws IOException, URISyntaxException {
		return new VenueSearchClient().searchVenue(lat, lng, rad);
	}


	public VenueExploreResponse exploreVenue(double lat, double lng, double rad) throws IOException, URISyntaxException {
		return new VenueExploreClient().exploreVenue(lat, lng, rad);
	}
}
