package org.gpworks.discogs;

import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class Artist {
	private static final String TAG = Artist.class.getName();
	
	private String _name;
	private String _thumb;
	private String _uri;
	private URL _resourceURL;
	private String _id;
	private JSONObject _jsonObj;
	
	public String get_name() {
		return _name;
	}	
	
	public String get_thumb() {
		return _thumb;
	}
	
	public String get_uri() {
		return _uri;
	}
	
	public URL get_resourceURL() {
		return _resourceURL;
	}
	
	public String get_id() {
		return _id;
	}
		
	public Artist(JSONObject jsonObj){
		this._jsonObj = jsonObj; 
		this.parseArtistObject();
	}
	
	private void parseArtistObject(){
		try{
			this._name = _jsonObj.getString("title");
			this._thumb = _jsonObj.getString("thumb"); 
			this._uri = _jsonObj.getString("uri");
			this._resourceURL = new URL(_jsonObj.getString("resource_url"));
			this._id = _jsonObj.getString("id");
		} catch (JSONException e) {			
			Log.e(TAG, e.getStackTrace().toString());
		} catch (MalformedURLException e) {
			Log.e(TAG, e.getStackTrace().toString());
		}	
	}
	
}
