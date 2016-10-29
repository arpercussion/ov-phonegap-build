package com.obscured.phonegap.build.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Icon {

	@JsonProperty("filename")
	private String filename;
	@JsonProperty("link")
	private String link;


	@JsonProperty("filename")
	public String getFilename() {
		return filename;
	}


	@JsonProperty("filename")
	public void setFilename(String filename) {
		this.filename = filename;
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
