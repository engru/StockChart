package com.example.graphics.coverage.group;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.graphics.coverage.dispatch.IDispatchData;
import com.example.graphics.coverage.entity.Data;
import com.example.graphics.coverage.entity.DataAdapter;
import com.example.graphics.coverage.event.TouchParser;
import com.example.graphics.coverage.view.GridCompo;
import com.example.graphics.coverage.view.Linecompo;
import com.example.graphics.coverage.view.compo;

public class Group extends FrameLayout implements IDispatchData {

	//Group 中囊括 View，相当于View集，类似ViewGroup 用于对其中的View分发
	
	
	List<compo> ls = new ArrayList<compo>();
	
	public Group(Context mContext){
		super(mContext);
	}
	
	public void setAdapter(DataAdapter adapter){
		adapter.registerObserver(this);
		initListener(adapter);
	}



	public void initListener(DataAdapter adapter) {
		// TODO Auto-generated method stub
	}

	@Override
	public void dispatchData(Data d) {
		// TODO Auto-generated method stub
		for(compo c:ls){
			c.onInterceptData(d);
		}
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		System.out.println("ontouch");
		return true;
	}


	
	
}
