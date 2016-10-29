package com.obscured.phonegap.build.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class App {
	@JsonProperty("id")
	private Integer id;
	@JsonProperty("title")
	private String title;
	@JsonProperty("package")
	private String _package;
	@JsonProperty("version")
	private String version;
	@JsonProperty("build_count")
	private Integer buildCount;
	@JsonProperty("private")
	private Boolean _private;
	@JsonProperty("phonegap_version")
	private String phonegapVersion;
	@JsonProperty("hydrates")
	private Boolean hydrates;
	@JsonProperty("share")
	private Boolean share;
	@JsonProperty("last_build")
	private String lastBuild;
	@JsonProperty("description")
	private String description;
	@JsonProperty("repo")
	private String repo;
	@JsonProperty("tag")
	private String tag;
	@JsonProperty("debug")
	private Boolean debug;
	@JsonProperty("head")
	private String head;
	@JsonProperty("link")
	private String link;
	@JsonProperty("plugins")
	private String plugins;
	@JsonProperty("completed")
	private Boolean completed;
	@JsonProperty("role")
	private String role;
	@JsonProperty("icon")
	private Icon icon;
	@JsonProperty("status")
	private Status status;
	@JsonProperty("phonegap_versions")
	private PhonegapVersions phonegapVersions;
	@JsonProperty("download")
	private Download download;
	@JsonProperty("error")
	private Error error;
	@JsonProperty("install_url")
	private String installUrl;
	@JsonProperty("share_url")
	private String shareUrl;
	@JsonProperty("keys")
	private Keys keys;
	@JsonProperty("logs")
	private Logs logs;

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

	@JsonProperty("package")
	public String getPackage() {
		return _package;
	}

	@JsonProperty("package")
	public void setPackage(String _package) {
		this._package = _package;
	}

	@JsonProperty("version")
	public String getVersion() {
		return version;
	}

	@JsonProperty("version")
	public void setVersion(String version) {
		this.version = version;
	}

	@JsonProperty("build_count")
	public Integer getBuildCount() {
		return buildCount;
	}


	@JsonProperty("build_count")
	public void setBuildCount(Integer buildCount) {
		this.buildCount = buildCount;
	}


	@JsonProperty("private")
	public Boolean getPrivate() {
		return _private;
	}


	@JsonProperty("private")
	public void setPrivate(Boolean _private) {
		this._private = _private;
	}


	@JsonProperty("phonegap_version")
	public String getPhonegapVersion() {
		return phonegapVersion;
	}


	@JsonProperty("phonegap_version")
	public void setPhonegapVersion(String phonegapVersion) {
		this.phonegapVersion = phonegapVersion;
	}


	@JsonProperty("hydrates")
	public Boolean getHydrates() {
		return hydrates;
	}


	@JsonProperty("hydrates")
	public void setHydrates(Boolean hydrates) {
		this.hydrates = hydrates;
	}


	@JsonProperty("share")
	public Boolean getShare() {
		return share;
	}


	@JsonProperty("share")
	public void setShare(Boolean share) {
		this.share = share;
	}


	@JsonProperty("last_build")
	public String getLastBuild() {
		return lastBuild;
	}


	@JsonProperty("last_build")
	public void setLastBuild(String lastBuild) {
		this.lastBuild = lastBuild;
	}


	@JsonProperty("description")
	public String getDescription() {
		return description;
	}


	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}


	@JsonProperty("repo")
	public String getRepo() {
		return repo;
	}


	@JsonProperty("repo")
	public void setRepo(String repo) {
		this.repo = repo;
	}


	@JsonProperty("tag")
	public String getTag() {
		return tag;
	}


	@JsonProperty("tag")
	public void setTag(String tag) {
		this.tag = tag;
	}


	@JsonProperty("debug")
	public Boolean getDebug() {
		return debug;
	}


	@JsonProperty("debug")
	public void setDebug(Boolean debug) {
		this.debug = debug;
	}


	@JsonProperty("head")
	public String getHead() {
		return head;
	}


	@JsonProperty("head")
	public void setHead(String head) {
		this.head = head;
	}


	@JsonProperty("link")
	public String getLink() {
		return link;
	}


	@JsonProperty("link")
	public void setLink(String link) {
		this.link = link;
	}


	@JsonProperty("plugins")
	public String getPlugins() {
		return plugins;
	}


	@JsonProperty("plugins")
	public void setPlugins(String plugins) {
		this.plugins = plugins;
	}


	@JsonProperty("completed")
	public Boolean getCompleted() {
		return completed;
	}


	@JsonProperty("completed")
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}


	@JsonProperty("role")
	public String getRole() {
		return role;
	}


	@JsonProperty("role")
	public void setRole(String role) {
		this.role = role;
	}


	@JsonProperty("icon")
	public Icon getIcon() {
		return icon;
	}


	@JsonProperty("icon")
	public void setIcon(Icon icon) {
		this.icon = icon;
	}


	@JsonProperty("status")
	public Status getStatus() {
		return status;
	}


	@JsonProperty("status")
	public void setStatus(Status status) {
		this.status = status;
	}


	@JsonProperty("phonegap_versions")
	public PhonegapVersions getPhonegapVersions() {
		return phonegapVersions;
	}


	@JsonProperty("phonegap_versions")
	public void setPhonegapVersions(PhonegapVersions phonegapVersions) {
		this.phonegapVersions = phonegapVersions;
	}


	@JsonProperty("download")
	public Download getDownload() {
		return download;
	}


	@JsonProperty("download")
	public void setDownload(Download download) {
		this.download = download;
	}


	@JsonProperty("error")
	public Error getError() {
		return error;
	}


	@JsonProperty("error")
	public void setError(Error error) {
		this.error = error;
	}


	@JsonProperty("install_url")
	public String getInstallUrl() {
		return installUrl;
	}


	@JsonProperty("install_url")
	public void setInstallUrl(String installUrl) {
		this.installUrl = installUrl;
	}


	@JsonProperty("share_url")
	public String getShareUrl() {
		return shareUrl;
	}


	@JsonProperty("share_url")
	public void setShareUrl(String shareUrl) {
		this.shareUrl = shareUrl;
	}


	@JsonProperty("keys")
	public Keys getKeys() {
		return keys;
	}


	@JsonProperty("keys")
	public void setKeys(Keys keys) {
		this.keys = keys;
	}


	@JsonProperty("logs")
	public Logs getLogs() {
		return logs;
	}


	@JsonProperty("logs")
	public void setLogs(Logs logs) {
		this.logs = logs;
	}
}

