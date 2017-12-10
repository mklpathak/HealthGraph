package com.mukulpathak.healthgraph.pojos;

import com.google.gson.annotations.SerializedName;

public class PriceOverview{

	@SerializedName("initial")
	private int initial;

	@SerializedName("final")
	private int jsonMemberFinal;

	@SerializedName("currency")
	private String currency;

	@SerializedName("discount_percent")
	private int discountPercent;

	public void setInitial(int initial){
		this.initial = initial;
	}

	public int getInitial(){
		return initial;
	}

	public void setJsonMemberFinal(int jsonMemberFinal){
		this.jsonMemberFinal = jsonMemberFinal;
	}

	public int getJsonMemberFinal(){
		return jsonMemberFinal;
	}

	public void setCurrency(String currency){
		this.currency = currency;
	}

	public String getCurrency(){
		return currency;
	}

	public void setDiscountPercent(int discountPercent){
		this.discountPercent = discountPercent;
	}

	public int getDiscountPercent(){
		return discountPercent;
	}

	@Override
 	public String toString(){
		return 
			"PriceOverview{" + 
			"initial = '" + initial + '\'' + 
			",final = '" + jsonMemberFinal + '\'' + 
			",currency = '" + currency + '\'' + 
			",discount_percent = '" + discountPercent + '\'' + 
			"}";
		}
}