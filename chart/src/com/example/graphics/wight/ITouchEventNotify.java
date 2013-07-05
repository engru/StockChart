package com.example.graphics.wight;

import com.example.graphics.wight.grid.GridChart;


public interface ITouchEventNotify {

	public void notifyEventAll(GridChart chart);
	
	public void addNotify(ITouchEventResponse notify);
	
	public void removeNotify(int i);
	
	public void removeAllNotify();
}
