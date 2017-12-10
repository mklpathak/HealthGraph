package com.mukulpathak.healthgraph.pojos;

import com.google.gson.annotations.SerializedName;

public class SupportInfo{

	@SerializedName("url")
	private String url;

	@SerializedName("email")
	private String email;

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"SupportInfo{" + 
			"url = '" + url + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}