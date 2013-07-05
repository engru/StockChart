package com.example.graphics.coverage.event;

import com.example.graphics.coverage.entity.StockData;

import android.util.FloatMath;
import android.view.MotionEvent;

public class StockTouchParser extends TouchParser {

	/*
	public boolean onTouchEvent(MotionEvent ev) {
		
		return false;
		
	}
	*/
	
	
	

	float touchPostX = 0;
	float touchPostY = 0;
	float touchPostX2 = 0;
	float touchPostY2 = 0;
	float initX = 0;
	float initY = 0;
	float initX2 = 0;
	float initY2 = 0;
	boolean isTouch = false;
	@Override
	public boolean onTouchEvent(MotionEvent event) {
				if (event.getPointerCount() == 1) {
					// 获取点击坐�?
					touchPostX = event.getX();
					touchPostY = event.getY();
					touchPostX2 = 0;
					touchPostY2 = 0;

				} else if (event.getPointerCount() == 2) {
					touchPostX = event.getX(0);
					touchPostY = event.getY(0);
					touchPostX2 = event.getX(1);
					touchPostY2 = event.getY(1);
				}
				switch (event.getAction() & MotionEvent.ACTION_MASK) {
				case MotionEvent.ACTION_DOWN:
					initX = touchPostX;
					initY = touchPostY;
					initX2 = touchPostX2;
					initY2 = touchPostY2;
					System.out.println("down");
					isTouch = true;
					break;
				case MotionEvent.ACTION_UP:

					//sum = sticksum;
					System.out.println("up");
					refreshData();
					initX = 0;
					initY = 0;
					initX2 = 0;
					initY2 = 0;
					//this.invalidate();

					isTouch = false;
					break;
				case MotionEvent.ACTION_MOVE:
					isTouch = true;
					if(initX2 ==0 && initY2==0){
						initX = touchPostX;
						initY = touchPostY;
						initX2 = touchPostX2;
						initY2 = touchPostY2;
						sum = ((StockData)adapter.getData()).getStickNum();
					}
					System.out.println("move");
					refreshData();
					//this.invalidate();//drawCross();
					break;
				}
				
				return true;
	}

	private void refreshData() {
		// TODO Auto-generated method stub
		float stickWidth = ((float)(group.getWidth() - 48)/ sum);
		initParams(stickWidth,sum);
	}
	
	int sum = 0;
	int beginIndex = 0;
	int sticksum = 0;
	private void initParams(float stickWidth,int sum) {
		//1、获取 index
		//2、获取个数
		StockData sd = (StockData) adapter.getData();
		
		System.out.println(stickWidth+"|"+sum);
		
		int index = (int) (((initX+initX2)/2f-48)/stickWidth);
		float x = touchPostX2-touchPostX;
		float y = touchPostY2-touchPostY;
		float ix = initX2-initX;
		float iy = initY2-initY;
		sticksum = (int)((FloatMath.sqrt(ix*ix+iy*iy)/FloatMath.sqrt(x * x + y * y)) * sum);
		
		System.out.println("xxxxx"+FloatMath.sqrt(ix*ix+iy*iy)/FloatMath.sqrt(x * x + y * y));
		if(sticksum>sd.getListEntity().size()) sticksum = sd.getListEntity().size();
		beginIndex = index - sticksum/2;
		if(beginIndex<0){
			beginIndex = 0;
			sticksum = sticksum+beginIndex;
		}
		System.out.println("-----------"+beginIndex+"|"+sticksum+"|"+index);
		((StockData)sd).updateDisplay(beginIndex, sticksum);
		adapter.update();
	}
}
