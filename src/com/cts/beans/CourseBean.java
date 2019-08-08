package com.cts.beans;

import java.io.Serializable;

public class CourseBean implements Serializable{

	private String name;
	private int fee;
	private int duration;
	private int capacity;
	private int avail;
	
	public CourseBean() {
		// TODO Auto-generated constructor stub
	}

	public CourseBean(String name, int fee, int duration, int capacity, int avail) {
		super();
		this.name = name;
		this.fee = fee;
		this.duration = duration;
		this.capacity = capacity;
		this.avail = avail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getAvail() {
		return avail;
	}

	public void setAvail(int avail) {
		this.avail = avail;
	}
	
	
	
	
	
}
