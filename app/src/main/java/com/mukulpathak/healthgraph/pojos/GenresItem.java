package com.mukulpathak.healthgraph.pojos;

import com.google.gson.annotations.SerializedName;

public class GenresItem{

	@SerializedName("description")
	private String description;

	@SerializedName("id")
	private String id;

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"GenresItem{" + 
			"description = '" + description + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}