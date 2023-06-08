package org.placeholder.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponsePost{

	@JsonProperty("ResponsePost")
	private List<ResponsePostItem> responsePost;

	public List<ResponsePostItem> getResponsePost(){
		return responsePost;
	}
}