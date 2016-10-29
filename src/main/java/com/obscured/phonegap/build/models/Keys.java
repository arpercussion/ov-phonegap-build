package com.obscured.phonegap.build.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Keys {

	@JsonProperty("android")
	private Device android;
	@JsonProperty("ios")
	private Device ios;
	@JsonProperty("winphone")
	private Device winphone;
	@JsonProperty("windows")
	private Device windows;

	@JsonProperty("android")
	public Device getAndroid() {
		return android;
	}


	@JsonProperty("android")
	public void setAndroid(Device android) {
		this.android = android;
	}


	@JsonProperty("ios")
	public Device getIos() {
		return ios;
	}


	@JsonProperty("ios")
	public void setIos(Device ios) {
		this.ios = ios;
	}


	@JsonProperty("winphone")
	public Device getWinphone() {
		return winphone;
	}


	@JsonProperty("winphone")
	public void setWinphone(Device winphone) {
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
