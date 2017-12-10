package com.mukulpathak.healthgraph.pojos;

import com.google.gson.annotations.SerializedName;

public class SubsItem{

	@SerializedName("option_description")
	private String optionDescription;

	@SerializedName("can_get_free_license")
	private String canGetFreeLicense;

	@SerializedName("option_text")
	private String optionText;

	@SerializedName("price_in_cents_with_discount")
	private int priceInCentsWithDiscount;

	@SerializedName("percent_savings")
	private int percentSavings;

	@SerializedName("packageid")
	private int packageid;

	@SerializedName("is_free_license")
	private boolean isFreeLicense;

	@SerializedName("percent_savings_text")
	private String percentSavingsText;

	public void setOptionDescription(String optionDescription){
		this.optionDescription = optionDescription;
	}

	public String getOptionDescription(){
		return optionDescription;
	}

	public void setCanGetFreeLicense(String canGetFreeLicense){
		this.canGetFreeLicense = canGetFreeLicense;
	}

	public String getCanGetFreeLicense(){
		return canGetFreeLicense;
	}

	public void setOptionText(String optionText){
		this.optionText = optionText;
	}

	public String getOptionText(){
		return optionText;
	}

	public void setPriceInCentsWithDiscount(int priceInCentsWithDiscount){
		this.priceInCentsWithDiscount = priceInCentsWithDiscount;
	}

	public int getPriceInCentsWithDiscount(){
		return priceInCentsWithDiscount;
	}

	public void setPercentSavings(int percentSavings){
		this.percentSavings = percentSavings;
	}

	public int getPercentSavings(){
		return percentSavings;
	}

	public void setPackageid(int packageid){
		this.packageid = packageid;
	}

	public int getPackageid(){
		return packageid;
	}

	public void setIsFreeLicense(boolean isFreeLicense){
		this.isFreeLicense = isFreeLicense;
	}

	public boolean isIsFreeLicense(){
		return isFreeLicense;
	}

	public void setPercentSavingsText(String percentSavingsText){
		this.percentSavingsText = percentSavingsText;
	}

	public String getPercentSavingsText(){
		return percentSavingsText;
	}

	@Override
 	public String toString(){
		return 
			"SubsItem{" + 
			"option_description = '" + optionDescription + '\'' + 
			",can_get_free_license = '" + canGetFreeLicense + '\'' + 
			",option_text = '" + optionText + '\'' + 
			",price_in_cents_with_discount = '" + priceInCentsWithDiscount + '\'' + 
			",percent_savings = '" + percentSavings + '\'' + 
			",packageid = '" + packageid + '\'' + 
			",is_free_license = '" + isFreeLicense + '\'' + 
			",percent_savings_text = '" + percentSavingsText + '\'' + 
			"}";
		}
}