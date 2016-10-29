package com.obscured.phonegap.build.common;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.obscured.phonegap.build.models.App;
import com.obscured.phonegap.build.models.Key;
import com.obscured.phonegap.build.models.Keys;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

public class Wrapper {

	private String user;
	private String password;

	public Wrapper(String user, String password) {
		this.user = user;
		this.password = password;
	}

	// READ API //////////////////////////

	public List<App> getApps() {
		List<App> result = null;

		String path = HttpClientUtils.buildAppsPath();

		JSONObject json = HttpClientUtils.get(Constants.BASE_URL, path, user, password);

		if (json != null) {
			// get apps from json object
			String apps = json.get("apps").toString();
			try {
				result = new ObjectMapper().readValue(apps, new TypeReference<List<App>>() {
				});
			} catch (IOException e) {
				System.out.println("ERROR ObjectMapper: " + e.getMessage());
			}
		}

		return result;
	}

	public App getApp(String id) throws Exception {
		App result = null;

		String path = HttpClientUtils.buildAppsPath();
		path += "/" + id;

		JSONObject json = HttpClientUtils.get(Constants.BASE_URL, path, user, password);

		if (json != null) {
			String app = json.toString();
			try {
				result = new ObjectMapper().readValue(app, App.class);
			} catch (IOException e) {
				System.out.println("ERROR ObjectMapper: " + e.getMessage());
			}
		}

		return result;
	}

	public Keys getKeys() {
		Keys result = null;

		String path = HttpClientUtils.buildKeysPath();

		JSONObject json = HttpClientUtils.get(Constants.BASE_URL, path, user, password);

		if (json != null) {
			String keys = json.get("keys").toString();
			try {
				result = new ObjectMapper().readValue(keys, Keys.class);
			} catch (IOException e) {
				System.out.println("ERROR ObjectMapper: " + e.getMessage());
			}
		}

		return result;
	}


	public List<Key> getKeysByPlatform(String platform) {
		List<Key> result = null;

		String path = HttpClientUtils.buildKeysPath();
		path += "/" + platform;

		JSONObject json = HttpClientUtils.get(Constants.BASE_URL, path, user, password);

		if (json != null) {
			String keys = json.get("keys").toString();
			try {
				result = new ObjectMapper().readValue(keys, new TypeReference<List<Key>>() {
				});
			} catch (IOException e) {
				System.out.println("ERROR ObjectMapper: " + e.getMessage());
			}
		}

		return result;
	}

	// WRITE API /////////////////////////

	public App updateRepoApp(String id) {
		App result = null;
		String path = HttpClientUtils.buildAppsPath();
		path += "/" + id;

		JSONObject json = new JSONObject();
		json.append("pull", true);

		JSONObject jobj = HttpClientUtils.put(Constants.BASE_URL, path, json.toString(), user, password);

		if (jobj != null) {
			String app = jobj.toString();
			try {
				result = new ObjectMapper().readValue(app, App.class);
			} catch (IOException e) {
				System.out.println("ERROR ObjectMapper: " + e.getMessage());
			}
		}

		return result;
	}

}
