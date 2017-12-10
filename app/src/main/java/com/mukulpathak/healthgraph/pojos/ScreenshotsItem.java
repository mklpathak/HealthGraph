package com.mukulpathak.healthgraph.pojos;

import com.google.gson.annotations.SerializedName;

public class ScreenshotsItem{

	@SerializedName("path_full")
	private String pathFull;

	@SerializedName("path_thumbnail")
	private String pathThumbnail;

	@SerializedName("id")
	private int id;

	public void setPathFull(String pathFull){
		this.pathFull = pathFull;
	}

	public String getPathFull(){
		return pathFull;
	}

	public void setPathThumbnail(String pathThumbnail){
		this.pathThumbnail = pathThumbnail;
	}

	public String getPathThumbnail(){
		return pathThumbnail;
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
			"ScreenshotsItem{" + 
			"path_full = '" + pathFull + '\'' + 
			",path_thumbnail = '" + pathThumbnail + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}