package com.obscured.phonegap.build.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Device {

	@JsonProperty("all")
	private List<Key> all = new ArrayList<>();

	@JsonProperty("link")
	private String link;


	@JsonProperty("all")
	public List<Key> getAll() {
		return all;
	}


	@JsonProperty("all")
	public void setAll(List<Key> all) {
		this.all = all;
	}


	@JsonProperty("link")
	public String getLink() {
		return link;
	}


	@JsonProperty("link")
	public void setLink(String link) {
		this.link = link;
	}

}