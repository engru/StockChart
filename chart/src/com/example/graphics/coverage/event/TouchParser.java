package com.example.graphics.coverage.event;

import com.example.graphics.coverage.entity.DataAdapter;
import com.example.graphics.coverage.group.Group;

import android.view.MotionEvent;

public class TouchParser {
	DataAdapter adapter;
	Group group;
	
	public interface OnTouchParserListener{
		void onDetail();
	}

	public TouchParser(){
		
	}
	
	public void bindAdapter(DataAdapter adapter){
		this.adapter = adapter;
	}
	
	public void bindAdapter(DataAdapter adapter,Group group){
		this.adapter = adapter;
		this.group = group;
	}
	
	public boolean onTouchEvent(MotionEvent ev) {
		
		return false;
		
	}
}
