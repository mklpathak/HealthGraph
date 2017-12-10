package com.mukulpathak.healthgraph.pojos;

import com.google.gson.annotations.SerializedName;

public class ReleaseDate{

	@SerializedName("coming_soon")
	private boolean comingSoon;

	@SerializedName("date")
	private String date;

	public void setComingSoon(boolean comingSoon){
		this.comingSoon = comingSoon;
	}

	public boolean isComingSoon(){
		return comingSoon;
	}

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	@Override
 	public String toString(){
		return 
			"ReleaseDate{" + 
			"coming_soon = '" + comingSoon + '\'' + 
			",date = '" + date + '\'' + 
			"}";
		}
}