package org.placeholder.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestPost {

	@JsonProperty("title")
	private String title;

	@JsonProperty("body")
	private String body;

	@JsonProperty("userId")
	private int userId;

	public String getTitle() {
		return title;
	}

	public String getBody() {
		return body;
	}

	public int getUserId() {
		return userId;
	}

	public static class Builder {
		private String title;
		private String body;
		private int userId;

		public Builder withTitle(String title) {
			this.title = title;
			return this;
		}

		public Builder withBody(String body) {
			this.body = body;
			return this;
		}

		public Builder withUserId(int userId) {
			this.userId = userId;
			return this;
		}
		public Builder jsonDefult(){
			this.title = "foo";
			this.body = "bar";
			this.userId = 1;
			return this;
		}

		public RequestPost build() {
			RequestPost requestPost = new RequestPost();
			requestPost.title = title;
			requestPost.body = body;
			requestPost.userId = userId;
			return requestPost;
		}
	}
}
