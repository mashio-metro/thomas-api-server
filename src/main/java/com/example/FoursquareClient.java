package com.example;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * foursquareのAPIくためのファサード
 * @author mukai_masaki on 2014/09/17.
 *         Copyright: CYBER AGNET. INC
 */
public class FoursquareClient {

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

	public String getVenue(double lat, double lng) throws IOException, URISyntaxException {
		builder.setPath(ENDPOINT + "/venues/search");
		builder.addParameter("ll", lng + "," + lat);
		System.out.println(builder.build());
		HttpGet getMethod = new HttpGet(builder.build());
		HttpResponse res = httpClient.execute(getMethod);
		int responseCode = res.getStatusLine().getStatusCode();
		System.out.println(responseCode);
		return EntityUtils.toString(res.getEntity());
	}
}
