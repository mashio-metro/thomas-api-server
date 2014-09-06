package com.example;

import freemarker.template.Configuration;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
			File f = new File("template");
			conf.setClassForTemplateLoading(App.class, "/template");
		}
		get("/users/:user", (req, res) -> {
			Map<String, Object> attributes = new HashMap<String, Object>();
			attributes.put("message", "hello world");
			return new ModelAndView(attributes, "hello.ftl");
		}, new FreeMarkerEngine());

		get("/", (req, res) -> {
			Map<String, Object> attributes = new HashMap<String, Object>();
			attributes.put("message", "hello world");
			return new ModelAndView(attributes, "hello.ftl");
		}, new FreeMarkerEngine());

	}

}
