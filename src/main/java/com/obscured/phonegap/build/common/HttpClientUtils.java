package com.obscured.phonegap.build.common;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.*;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;
import org.json.JSONTokener;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HttpClientUtils {

	private static CloseableHttpClient httpclient = HttpClients.createDefault();

	static String buildAppsPath() {
		return String.format("%s%s", Constants.API_PATH, Constants.APPS_PATH);
	}

	static String buildKeysPath() {
		return String.format("%s%s", Constants.API_PATH, Constants.KEYS_PATH);
	}

	private static HttpClientContext buildAuthCacheContext(URI uri, String user, String password) {
		HttpHost targetHost = new HttpHost(uri.getHost(), uri.getPort(), uri.getScheme());
		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		credsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(user, password));

		AuthCache authCache = new BasicAuthCache();
		authCache.put(targetHost, new BasicScheme());

		// Add AuthCache to the execution context
		final HttpClientContext context = HttpClientContext.create();
		context.setCredentialsProvider(credsProvider);
		context.setAuthCache(authCache);
		return context;
	}

	public static JSONObject get(String url, String path, String user, String password) {
		JSONObject json = null;
		try {
			URI uri = new URIBuilder(url).setPath(path).build();

			// Add AuthCache to the execution context
			final HttpClientContext context = buildAuthCacheContext(uri, user, password);

			// make GET request
			HttpGet httpGet = new HttpGet(uri);

			// issue request
			try (CloseableHttpResponse response = httpclient.execute(httpGet, context)) {
				int statusCode = response.getStatusLine().getStatusCode();
				if (statusCode >= 400) {
					printError("GET", uri.toString(), "Status: " + statusCode, null);
				} else {
					HttpEntity entity = response.getEntity();
					if (entity != null) {
						try (InputStream stream = entity.getContent()) {
							InputStreamReader reader = new InputStreamReader(stream);
							JSONTokener tokener = new JSONTokener(reader);
							json = new JSONObject(tokener);
						} catch (Exception e) {
							printError("GET", uri.toString(), "Could not generate InputStream", e);
						}
					}
				}
			} catch (IOException e) {
				printError("GET", uri.toString(), "Problem with HTTPClient", e);
			}
		} catch (URISyntaxException e) {
			printError("GET", url + path, "Problem with URIBuilder", e);
		}

		return json;
	}

	public static JSONObject post(String url, String path, String json, String user, String password) {
		JSONObject result = null;
		try {
			// build uri
			URI uri = new URIBuilder(url).setPath(path).build();

			// Add AuthCache to the execution context
			final HttpClientContext context = buildAuthCacheContext(uri, user, password);

			HttpPost request = new HttpPost(uri);

			// pass content directly
			StringEntity stringEntity = new StringEntity(json);
			request.setEntity(stringEntity);

			try (CloseableHttpResponse response = httpclient.execute(request, context)) {
				int statusCode = response.getStatusLine().getStatusCode();
				if (statusCode >= 400) {
					printError("POST", uri.toString(), "Status: " + statusCode, null);
				} else {
					HttpEntity entity = response.getEntity();
					if (entity != null) {
						try (InputStream stream = entity.getContent()) {
							InputStreamReader reader = new InputStreamReader(stream);
							JSONTokener tokener = new JSONTokener(reader);
							result = new JSONObject(tokener);
						} catch (Exception e) {
							printError("POST", uri.toString(), "Could not generate InputStream", e);
						}
					}
				}
			} catch (IOException e) {
				printError("POST", uri.toString(), "Problem with HTTPClient", e);
			}
		} catch (URISyntaxException e) {
			printError("POST", url + path, "Problem with URIBuilder", e);
		} catch (UnsupportedEncodingException e) {
			printError("POST", url + path, "Problem with StringEntity", e);
		}
		return result;
	}

	public static JSONObject put(String url, String path, String json, String user, String password) {
		JSONObject result = null;
		try {
			// build uri
			URI uri = new URIBuilder(url).setPath(path).build();

			// Add AuthCache to the execution context
			final HttpClientContext context = buildAuthCacheContext(uri, user, password);

			HttpPut request = new HttpPut(uri);

			// pass content directly
			StringEntity stringEntity = new StringEntity(json);
			request.setEntity(stringEntity);

			try (CloseableHttpResponse response = httpclient.execute(request, context)) {
				int statusCode = response.getStatusLine().getStatusCode();
				if (statusCode >= 400) {
					printError("PUT", uri.toString(), "Status: " + statusCode, null);
				} else {
					HttpEntity entity = response.getEntity();
					if (entity != null) {
						try (InputStream stream = entity.getContent()) {
							InputStreamReader reader = new InputStreamReader(stream);
							JSONTokener tokener = new JSONTokener(reader);
							result = new JSONObject(tokener);
						} catch (Exception e) {
							printError("PUT", uri.toString(), "Could not generate InputStream", e);
						}
					}
				}
			} catch (IOException e) {
				printError("PUT", uri.toString(), "Problem with HTTPClient", e);
			}
		} catch (URISyntaxException e) {
			printError("PUT", url + path, "Problem with URIBuilder", e);
		} catch (UnsupportedEncodingException e) {
			printError("PUT", url + path, "Problem with StringEntity", e);
		}
		return result;
	}

	public static boolean delete(String url, String path, String user, String password) {
		boolean isSuccess = false;
		try {
			// build uri
			URI uri = new URIBuilder(url).setPath(path).build();

			// Add AuthCache to the execution context
			final HttpClientContext context = buildAuthCacheContext(uri, user, password);

			HttpDelete request = new HttpDelete(uri);

			try (CloseableHttpResponse response = httpclient.execute(request, context)) {
				List<Integer> okResults = Arrays.asList(Response.Status.NO_CONTENT.getStatusCode(), Response.Status.OK.getStatusCode());
				isSuccess = (okResults.contains(response.getStatusLine().getStatusCode()));
				if (!isSuccess) {
					printError("DELETE", uri.toString(), response.getStatusLine().getReasonPhrase(), null);
				}
			} catch (IOException e) {
				printError("DELETE", uri.toString(), "Problem with HTTPClient", e);
			}
		} catch (URISyntaxException e) {
			printError("DELETE", url + path, "Problem with StringEntity", e);
		}
		return isSuccess;
	}

	private static void printError(String method, String url, String message, Exception e) {
		List<String> builder = new ArrayList<>();

		if (StringUtils.isNotEmpty(method)) {
			builder.add("Method: " + method);
		}

		if (StringUtils.isNotEmpty(url)) {
			builder.add("Url: " + url);
		}

		if (StringUtils.isNotEmpty(message)) {
			builder.add("Message: " + message);
		}

		if (e != null) {
			builder.add("Exception: " + e.getMessage());
		}

		System.out.println(StringUtils.join(builder, ';'));
	}
}
