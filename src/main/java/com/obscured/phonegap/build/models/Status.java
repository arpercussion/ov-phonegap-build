package com.obscured.phonegap.build.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Status {

	@JsonProperty("android")
	private String android;
	@JsonProperty("ios")
	private String ios;
	@JsonProperty("winphone")
	private String winphone;
	@JsonProperty("windows")
	private Device windows;


	@JsonProperty("android")
	public String getAndroid() {
		return android;
	}


	@JsonProperty("android")
	public void setAndroid(String android) {
		this.android = android;
	}


	@JsonProperty("ios")
	public String getIos() {
		return ios;
	}


	@JsonProperty("ios")
	public void setIos(String ios) {
		this.ios = ios;
	}


	@JsonProperty("winphone")
	public String getWinphone() {
		return winphone;
	}


	@JsonProperty("winphone")
	public void setWinphone(String winphone) {
		this.winphone = winphone;
	}

	@JsonProperty("windows")
	public Device getWindows() {
		return windows;
	}

	@JsonProperty("windows")
	public void setWindows(Device windows) {
		this.windows = windows;
	}
}
