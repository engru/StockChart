package com.example.graphics.layers.entity;

import java.util.ArrayList;
import java.util.List;

import com.example.graphics.layers.group.Group;

public class DataAdapter implements IDataOperate{
	List<Data> ld = new ArrayList<Data>();
	Data d = new Data("data");
	//ArrayList<T> mObservers = new ArrayList<T>();
	ArrayList<Group> mObservers = new ArrayList<Group>();
	
	public DataAdapter(Data data){
		//d=data;//ld.add(data);
	}

	public void registerObserver(Group group){
		mObservers.add(group);
	}
	
	public void addData(Data data){
		d=data;
		//ld.clear();
		//ld.add(data);
	}
	
	public void addDataAll(List<Data> ld){
		this.ld.clear();
		this.ld = ld;
	}
	
	@Override
	public Data getData(){
		return d;
	}
	
	public void update(){
		//System.out.println("update");
		for(Group group:mObservers){
			group.dispatchData(getData());
		}
	}

}
