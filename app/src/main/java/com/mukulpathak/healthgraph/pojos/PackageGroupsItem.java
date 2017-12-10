package com.mukulpathak.healthgraph.pojos;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class PackageGroupsItem{

	@SerializedName("display_type")
	private int displayType;

	@SerializedName("subs")
	private List<SubsItem> subs;

	@SerializedName("save_text")
	private String saveText;

	@SerializedName("name")
	private String name;

	@SerializedName("description")
	private String description;

	@SerializedName("is_recurring_subscription")
	private String isRecurringSubscription;

	@SerializedName("title")
	private String title;

	@SerializedName("selection_text")
	private String selectionText;

	public void setDisplayType(int displayType){
		this.displayType = displayType;
	}

	public int getDisplayType(){
		return displayType;
	}

	public void setSubs(List<SubsItem> subs){
		this.subs = subs;
	}

	public List<SubsItem> getSubs(){
		return subs;
	}

	public void setSaveText(String saveText){
		this.saveText = saveText;
	}

	public String getSaveText(){
		return saveText;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setIsRecurringSubscription(String isRecurringSubscription){
		this.isRecurringSubscription = isRecurringSubscription;
	}

	public String getIsRecurringSubscription(){
		return isRecurringSubscription;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setSelectionText(String selectionText){
		this.selectionText = selectionText;
	}

	public String getSelectionText(){
		return selectionText;
	}

	@Override
 	public String toString(){
		return 
			"PackageGroupsItem{" + 
			"display_type = '" + displayType + '\'' + 
			",subs = '" + subs + '\'' + 
			",save_text = '" + saveText + '\'' + 
			",name = '" + name + '\'' + 
			",description = '" + description + '\'' + 
			",is_recurring_subscription = '" + isRecurringSubscription + '\'' + 
			",title = '" + title + '\'' + 
			",selection_text = '" + selectionText + '\'' + 
			"}";
		}
}