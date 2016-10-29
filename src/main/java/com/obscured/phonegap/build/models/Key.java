package com.obscured.phonegap.build.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Key {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("title")
	private String title;
	@JsonProperty("link")
	private String link;
	@JsonProperty("default")
	private Boolean _default;
	@JsonProperty("cert_name")
	private String certName;
	@JsonProperty("provision")
	private String provision;
	@JsonProperty("role")
	private String role;
	@JsonProperty("locked")
	private Boolean locked;
	@JsonProperty("alias")
	private String alias;

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}


	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}


	@JsonProperty("title")
	public String getTitle() {
		return title;
	}


	@JsonProperty("title")
	public void setTitle(String title) {
		this.title = title;
	}


	@JsonProperty("link")
	public String getLink() {
		return link;
	}


	@JsonProperty("link")
	public void setLink(String link) {
		this.link = link;
	}

	@JsonProperty("default")
	public Boolean getDefault() {
		return _default;
	}


	@JsonProperty("default")
	public void setDefault(Boolean _default) {
		this._default = _default;
	}

	@JsonProperty("cert_name")
	public String getCertName() {
		return certName;
	}

	@JsonProperty("cert_name")
	public void setCertName(String certName) {
		this.certName = certName;
	}

	@JsonProperty("provision")
	public String getProvision() {
		return provision;
	}


	@JsonProperty("provision")
	public void setProvision(String provision) {
		this.provision = provision;
	}

	@JsonProperty("role")
	public String getRole() {
		return role;
	}


	@JsonProperty("role")
	public void setRole(String role) {
		this.role = role;
	}


	@JsonProperty("locked")
	public Boolean getLocked() {
		return locked;
	}


	@JsonProperty("locked")
	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	@JsonProperty("alias")
	public String getAlias() {
		return alias;
	}


	@JsonProperty("alias")
	public void setAlias(String alias) {
		this.alias = alias;
	}
}