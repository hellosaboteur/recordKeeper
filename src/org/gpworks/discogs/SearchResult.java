package org.gpworks.discogs;

import org.json.JSONException;
import org.json.JSONObject;

public class SearchResult {	
	private String _httpResponse;
	private JSONObject _jsonResponse;
	
	public SearchResult(String response) throws JSONException{
		this._httpResponse = response;
		this._jsonResponse = new JSONObject(response);
	}

	public JSONObject get_jsonResponse() {
		return _jsonResponse;
	}

	public void set_jsonResponse(JSONObject _jsonResponse) {
		this._jsonResponse = _jsonResponse;
	}

	
	public String get_httpResponse() {
		return _httpResponse;
	}

	public void set_httpResponse(String _httpResponse) {
		this._httpResponse = _httpResponse;
	}
}
