package com.mukulpathak.healthgraph.pojos;

import com.google.gson.annotations.SerializedName;

public class Recommendations{

	@SerializedName("total")
	private int total;

	public void setTotal(int total){
		this.total = total;
	}

	public int getTotal(){
		return total;
	}

	@Override
 	public String toString(){
		return 
			"Recommendations{" + 
			"total = '" + total + '\'' + 
			"}";
		}
}