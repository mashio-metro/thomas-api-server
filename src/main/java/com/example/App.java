package com.example;

import com.example.route.ExploreRoute;
import com.example.route.SearchRoute;
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

	public static void main(String[] args) {
		System.out.println(Optional.ofNullable(System.getenv("PORT")).orElse("3456"));
		int port = Integer.parseInt(Optional.ofNullable(System.getenv("PORT")).orElse("3456"));
		setPort(port);
		{
			Configuration conf = new Configuration();
			conf.setClassForTemplateLoading(App.class, "/template");
		}
		get("/venues/search", "application/json", new SearchRoute(), new JsonTransformer());
		get("/venues/explore", "application/json", new ExploreRoute(), new JsonTransformer());
	}

}
