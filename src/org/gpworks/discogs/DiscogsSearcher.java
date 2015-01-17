package org.gpworks.discogs;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;




import org.json.JSONException;

import android.util.Log;

public class DiscogsSearcher {
	static final String key = "fVgSklTDHYFzSsLGUAJh";
	static final String secret = "kywapSQHbhDdrwurkCEzrcUsVXuUKlWF";
	static final String urlBase = "https://api.discogs.com/database/search?q=";

	public enum Condition {
		ARTIST, QUERY, TITLE, RELEASE_TITLE
	}

	public URL buildSearchURL(Condition condition, String value)
			throws Exception {
		String searchUrlString = urlBase + buildQuery(condition, value);
		URL searchURL = new URL(searchUrlString);
		return searchURL;
	}

	public SearchResult executeQuery(URL query) throws JSONException {
		InputStream in = null;
		HttpURLConnection urlConnection;
		String response = null;
		try {
			urlConnection = (HttpURLConnection) query.openConnection();
			in = new BufferedInputStream(urlConnection.getInputStream());
			
			int ch;
	        StringBuilder sb = new StringBuilder();
	        while((ch = in.read())!= -1)
	            sb.append((char)ch);
	        response = sb.toString();
	        Log.d("RESPONSE", response);
			
		} catch (IOException e) {
		}
		return new SearchResult(response);
	}

	private String buildQuery(Condition condition, String value) {
		String queryString = "";
		String creds = "&key="+key+"&secret="+secret;
		switch (condition) {
		case ARTIST:
			queryString = value.trim()+"&type=artist";
			break;

		default:
			throw new NullPointerException("Condition cannot be null");
		}
		return queryString+creds;
	}

}
