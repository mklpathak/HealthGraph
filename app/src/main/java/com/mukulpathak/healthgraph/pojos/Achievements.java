package com.mukulpathak.healthgraph.pojos;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Achievements{

	@SerializedName("total")
	private int total;

	@SerializedName("highlighted")
	private List<HighlightedItem> highlighted;

	public void setTotal(int total){
		this.total = total;
	}

	public int getTotal(){
		return total;
	}

	public void setHighlighted(List<HighlightedItem> highlighted){
		this.highlighted = highlighted;
	}

	public List<HighlightedItem> getHighlighted(){
		return highlighted;
	}

	@Override
 	public String toString(){
		return 
			"Achievements{" + 
			"total = '" + total + '\'' + 
			",highlighted = '" + highlighted + '\'' + 
			"}";
		}
}