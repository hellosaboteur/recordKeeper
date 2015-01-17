package org.gpworks.discogs;

import org.json.JSONObject;

/*
 * This object is a little wonky. we need to combine calls to both release and artist_releases to build the entire release 
 * object. I wanted to use a facade pattern but this object is a bastard.
 * TODO: add the relevant properties from the release call.
 */
public class Release {
	private String _releaseId;
	private String _artistId;
	private String _title;
	private String _thumb;
	private String _year;
	private JSONObject _jsonObj;
	
	public String get_releaseId() {
		return _releaseId;
	}
	
	public String get_artistId() {
		return _artistId;
	}
	
	public String get_title() {
		return _title;
	}
	
	public String get_thumb() {
		return _thumb;
	}
	
	public String get_year() {
		return _year;
	}
	
	public Release(JSONObject jsonObj){
		this._jsonObj = jsonObj;
	}
	
	private void praseReleaseObject(){
		
	}
	
/*"thumb": "https://api.discogs.com/images/R-150-60518-1165674057.jpeg",
      "artist": "Younger Than Park",
      "main_release": 60518,
      "title": "Can't Turn Back",
      "role": "Main",
      "year": 1993,
      "resource_url": "https://api.discogs.com/masters/150972",
      "type": "master",
      "id": 150972
      */
}
