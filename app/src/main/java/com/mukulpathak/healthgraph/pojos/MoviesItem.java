package com.mukulpathak.healthgraph.pojos;

import com.google.gson.annotations.SerializedName;

public class MoviesItem{

	@SerializedName("highlight")
	private boolean highlight;

	@SerializedName("thumbnail")
	private String thumbnail;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("webm")
	private Webm webm;

	public void setHighlight(boolean highlight){
		this.highlight = highlight;
	}

	public boolean isHighlight(){
		return highlight;
	}

	public void setThumbnail(String thumbnail){
		this.thumbnail = thumbnail;
	}

	public String getThumbnail(){
		return thumbnail;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setWebm(Webm webm){
		this.webm = webm;
	}

	public Webm getWebm(){
		return webm;
	}

	@Override
 	public String toString(){
		return 
			"MoviesItem{" + 
			"highlight = '" + highlight + '\'' + 
			",thumbnail = '" + thumbnail + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",webm = '" + webm + '\'' + 
			"}";
		}
}