package com.mukulpathak.healthgraph.pojos;

import com.google.gson.annotations.SerializedName;

public class CategoriesItem{

	@SerializedName("description")
	private String description;

	@SerializedName("id")
	private int id;

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"CategoriesItem{" + 
			"description = '" + description + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}