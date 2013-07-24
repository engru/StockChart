package com.example.chart;

public class StockInfo {
	String id;
	public double yclose;
	
	public String Code, name;
	
	public double price,open,high,low;
	public double vol,tur,change;
	String turoverate;
	
	public boolean moreInfo =false;
	public StockInfo(String id){
		this.id = id;
	}
}
