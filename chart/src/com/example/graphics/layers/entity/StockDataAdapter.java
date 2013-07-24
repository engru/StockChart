package com.example.graphics.layers.entity;

import java.util.List;


public class StockDataAdapter extends DataAdapter {
	StockData d = new StockData("stockdata in adapter");
	
	public StockDataAdapter(Data data) {
		super(data);
		//this.d = (StockData) data;
	}
	
	public void addEntityAll(List<Entity> le){
		d.addEntityAll(le);
	}
	
	public void addEntity(Entity entity){
		d.addEntity(entity);
	}
	
	public Data getData(){
		return this.d;
	}

	/*
	public void update(){
		System.out.println("update");
		for(Group group:mObservers){
			group.dispatchData(d);
		}
	}
	*/
}
