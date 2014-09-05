package com.example;

import com.google.gson.Gson;
import spark.ResponseTransformer;

/**
 * @author mukai_masaki on 2014/08/30.
 *         Copyright: CYBER AGNET. INC
 */
public class JsonTransformer implements ResponseTransformer{

	private Gson gson = new Gson();

	@Override
	public String render(Object o) throws Exception {
		return gson.toJson(o);
	}
}
