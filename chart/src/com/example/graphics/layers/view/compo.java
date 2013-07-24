package com.example.graphics.layers.view;

import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

import com.example.graphics.layers.dispatch.IHandleData;
import com.example.graphics.layers.entity.Data;


public class compo extends View implements IHandleData{
	String name = "name";
	
	public compo(Context mContext,String name){
		super(mContext);
		this.name = name;
	}
	
	public void update(){
		
	}
	//Canvas canvas;
	protected void onDraw(Canvas canvas) {
		//this.canvas = canvas;
		super.onDraw(canvas);
		if(isTouch)
			drawCross(canvas);
	}

	@Override
	public void onInterceptData(Data d) {
		// TODO Auto-generated method stub
		//确定是否处理此数据
		this.onData(d);
	}

	@Override
	public void onData(Data d) {
		// TODO Auto-generated method stub
		//System.out.println("onData:"+this.name);
		//for(Data d :ld){
		//	System.out.println(d.getName());
		//}
		
		super.invalidate();
		//this.dispatchDraw(canvas);
		//this.onDraw(canvas);
	}
	
	
	public boolean onInterceptTouchEvent(MotionEvent event){
		return false;
	}
	
	boolean isTouch = false;
	float touchPostX =0;
	float touchPostY =0;
	float touchPostX2=0,touchPostY2 = 0;
	/*@Override
	public boolean onTouchEvent(MotionEvent event) {
		System.out.println("ontouch1");
		

			// touched points, if touch point is only one
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
			isTouch = true;
			break;
		case MotionEvent.ACTION_UP:
			isTouch = false;
			this.invalidate();
			break;
		case MotionEvent.ACTION_MOVE:
			this.invalidate();//drawCross();
			break;
		}
		
		return true;
	}
*/
	private void drawCross(Canvas canvas) {
		// TODO Auto-generated method stub
		System.out.println("drawxxx:"+touchPostX);
		Paint paint = new Paint();
		paint.setColor(Color.GRAY);
		canvas.drawLine(touchPostX, 0, touchPostX, this.getHeight(), paint);
		canvas.drawLine(0, touchPostY, this.getWidth(), touchPostY, paint);
		if(touchPostX2 != 0 && touchPostY2 !=0){
			canvas.drawLine(touchPostX2, 0, touchPostX2, this.getHeight(), paint);
			canvas.drawLine(0, touchPostY2, this.getWidth(), touchPostY2, paint);
		}
		
	}
	
}
