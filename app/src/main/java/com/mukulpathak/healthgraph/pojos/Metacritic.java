package com.mukulpathak.healthgraph.pojos;

import com.google.gson.annotations.SerializedName;

public class Metacritic{

	@SerializedName("score")
	private int score;

	@SerializedName("url")
	private String url;

	public void setScore(int score){
		this.score = score;
	}

	public int getScore(){
		return score;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"Metacritic{" + 
			"score = '" + score + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}