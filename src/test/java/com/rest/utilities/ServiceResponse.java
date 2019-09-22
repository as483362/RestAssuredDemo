package com.rest.utilities;

import static com.jayway.restassured.RestAssured.given;
import org.json.JSONException;
import org.json.JSONObject;

import gherkin.deps.com.google.gson.JsonObject;

public class ServiceResponse {

	/**
	 * 
	 * This method gets API response status code and returns status code
	 * 
	 * @param route
	 * @return response
	 */

	public static int getServiceResponseStatuCode(String route) throws JSONException {

		int response = given().contentType("application/json").when().get(route).statusCode();

		return response;
	}

	/**
	 * 
	 * This method gets API response body details and returns body details as JSONObject
	 * 
	 * @param route
	 * @return response
	 */

	public static JSONObject getJSONResponseServiceDetails(String route) throws JSONException {

		String response = given().contentType("application/json").when().get(route).then().extract().body().asString();

		return new JSONObject(response);
	}

	/**
	 * 
	 * This method submit the post request and returns posted status code
	 * 
	 * @param route
	 * @param payLoad
	 * @return response
	 */

	public static int getPostServiceResponseStatuCode(String route, JsonObject payLoad) throws JSONException {

		int response = given().contentType("application/json").body(payLoad.toString()).when().post(route).statusCode();

		return response;
	}

}
