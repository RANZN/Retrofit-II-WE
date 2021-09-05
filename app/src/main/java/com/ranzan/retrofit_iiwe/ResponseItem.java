package com.ranzan.retrofit_iiwe;

import com.google.gson.annotations.SerializedName;

public class ResponseItem{

	@SerializedName("name")
	private String name;

	@SerializedName("postId")
	private Integer postId;

	@SerializedName("id")
	private Integer id;

	@SerializedName("body")
	private String body;

	@SerializedName("email")
	private String email;

	public String getName(){
		return name;
	}

	public Integer getPostId(){
		return postId;
	}

	public Integer getId(){
		return id;
	}

	public String getBody(){
		return body;
	}

	public String getEmail(){
		return email;
	}
}