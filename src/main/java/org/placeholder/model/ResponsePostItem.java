package org.placeholder.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponsePostItem{

	@JsonProperty("id")
	private int id;

	@JsonProperty("title")
	private String title;

	@JsonProperty("body")
	private String body;

	@JsonProperty("userId")
	private int userId;

	public int getId(){
		return id;
	}

	public String getTitle(){
		return title;
	}

	public String getBody(){
		return body;
	}

	public int getUserId(){
		return userId;
	}
}