package com.mukulpathak.healthgraph.pojos;

import com.google.gson.annotations.SerializedName;

public class Webm{

	@SerializedName("max")
	private String max;

	@SerializedName("480")
	private String jsonMember480;

	public void setMax(String max){
		this.max = max;
	}

	public String getMax(){
		return max;
	}

	public void setJsonMember480(String jsonMember480){
		this.jsonMember480 = jsonMember480;
	}

	public String getJsonMember480(){
		return jsonMember480;
	}

	@Override
 	public String toString(){
		return 
			"Webm{" + 
			"max = '" + max + '\'' + 
			",480 = '" + jsonMember480 + '\'' + 
			"}";
		}
}