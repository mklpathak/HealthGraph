package com.mukulpathak.healthgraph.pojos;

import java.util.List;

public class Twitch{
	private int startTwitch;
	private List<Integer> values;
	private List<Integer> valuesTwitch;
	private int start;
	private int step;

	public void setStartTwitch(int startTwitch){
		this.startTwitch = startTwitch;
	}

	public int getStartTwitch(){
		return startTwitch;
	}

	public void setValues(List<Integer> values){
		this.values = values;
	}

	public List<Integer> getValues(){
		return values;
	}

	public void setValuesTwitch(List<Integer> valuesTwitch){
		this.valuesTwitch = valuesTwitch;
	}

	public List<Integer> getValuesTwitch(){
		return valuesTwitch;
	}

	public void setStart(int start){
		this.start = start;
	}

	public int getStart(){
		return start;
	}

	public void setStep(int step){
		this.step = step;
	}

	public int getStep(){
		return step;
	}

	@Override
 	public String toString(){
		return 
			"Twitch{" + 
			"start_twitch = '" + startTwitch + '\'' + 
			",values = '" + values + '\'' +
			",values_twitch = '" + valuesTwitch + '\'' +
			",start = '" + start + '\'' + 
			",step = '" + step + '\'' + 
			"}";
		}
}