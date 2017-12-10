package com.mukulpathak.healthgraph.pojos;

import com.google.gson.annotations.SerializedName;

public class Platforms{

	@SerializedName("linux")
	private boolean linux;

	@SerializedName("windows")
	private boolean windows;

	@SerializedName("mac")
	private boolean mac;

	public void setLinux(boolean linux){
		this.linux = linux;
	}

	public boolean isLinux(){
		return linux;
	}

	public void setWindows(boolean windows){
		this.windows = windows;
	}

	public boolean isWindows(){
		return windows;
	}

	public void setMac(boolean mac){
		this.mac = mac;
	}

	public boolean isMac(){
		return mac;
	}

	@Override
 	public String toString(){
		return 
			"Platforms{" + 
			"linux = '" + linux + '\'' + 
			",windows = '" + windows + '\'' + 
			",mac = '" + mac + '\'' + 
			"}";
		}
}