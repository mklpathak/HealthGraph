package com.mukulpathak.healthgraph.pojos;

import com.google.gson.annotations.SerializedName;

public class HighlightedItem{

	@SerializedName("path")
	private String path;

	@SerializedName("name")
	private String name;

	public void setPath(String path){
		this.path = path;
	}

	public String getPath(){
		return path;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@Override
 	public String toString(){
		return 
			"HighlightedItem{" + 
			"path = '" + path + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}