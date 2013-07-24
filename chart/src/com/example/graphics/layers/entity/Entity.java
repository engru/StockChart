package com.example.graphics.layers.entity;

public class Entity {

	int date;
	int length;
	public double open,high,low,close;
	double vol,tur,change,turoverate;
	
	public Entity(int date){
		this.date = date;
	}
	
	public Entity(double open, double high, double low, double close,int date){
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.date = date;
	}
	
	public int getDate(){
		return date;
	}
	
	public Entity setLength(int length){
		this.length = length;
		return this;
	}
	
	public int getLength(){
		return length;
	}
	
}
