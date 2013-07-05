package com.example.graphics.coverage.view;

import java.util.ArrayList;
import java.util.List;

import com.example.graphics.coverage.entity.Data;
import com.example.graphics.coverage.entity.Entity;
import com.example.graphics.coverage.entity.ExtendData;
import com.example.graphics.coverage.entity.StockData;
import com.example.graphics.coverage.utils.Utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.renderscript.Font;
import android.renderscript.Font.Style;
import android.util.FloatMath;
import android.view.MotionEvent;

public class Linecompo extends compo {

	public Linecompo(Context mContext, String name) {
		super(mContext, name);
		// TODO Auto-generated constructor stub
	}
	
	int length = 10;
	List<Integer> ll = new ArrayList<Integer>();
	StockData d = null;
	
	protected void onDraw(Canvas canvas) {
		//System.out.println("lindraw");
		try{
		//throw new Exception("ontouch");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		Paint mPaint = new Paint();
		mPaint.setColor(Color.RED);
		//mPaint.set
		/*
		if(d!=null){
			for(Entity entity : d.getListEntity()){
				length = entity.getLength();
				//canvas.drawLine(10f, 10f, length, this.getHeight()/2, mPaint);
			}
		}else
			canvas.drawLine(10f, 10f, length, this.getHeight()/2, mPaint);
		*/
		if(null != d)
		drawK(canvas);
	}
	
	private void drawK(Canvas canvas) {
		
			if(sum == 0) sum = 164;//d.getListEntity().size();
			float stickWidth = ((float)(super.getWidth() - 48)/ StickSumDisplay)-1;
			//float stickWidth = ((float)(super.getWidth() - 48)/ d.getListEntity().size()) - 1;
			float stickX =  48 +1;
			//if(isTouch)
			//	initParams(stickWidth + 1,sum);
			
			Paint mPaintPositive = new Paint();
			mPaintPositive.setColor(Color.RED);
			mPaintPositive.setStyle(Paint.Style.STROKE);
			mPaintPositive.setStrokeWidth(2);

			Paint mPaintNegative = new Paint();
			mPaintNegative.setColor(0xff008b00);
			mPaintNegative.setStrokeWidth(2);
			
			Paint mPaintCross = new Paint();
			mPaintCross.setColor(Color.BLACK);
			mPaintCross.setStrokeWidth(2);
			System.out.println("newsum:"+StickSumDisplay+"|initIndex:"+beginIndex+"|width:"+stickWidth);
			//System.out.println("max:"+d.maxValue+"|min:"+d.minValue);
			//System.out.println("width:"+(super.getWidth()-48)+"|"+stickWidth+"|"+d.getListEntity().size());
			if (null != d) {
				for(int i = beginIndex;i<StickSumDisplay;i++){
				//for (int i = 0; i < d.getListEntity().size(); i++) {
					Entity ohlc = d.getListEntity().get(i);
					float maxValue = d.getMaxValue();
					float minValue = d.getMinValue();
					//Entity ohlc = new Entity(266 ,267 ,264 ,264 ,20110517);
					/*
					float openY = (float) ((1f - (ohlc.open - minValue) / (maxValue - minValue))
							* (super.getHeight() - 48));
					float highY = (float) ((1f - (ohlc.high - minValue) / (maxValue - minValue))
							* (super.getHeight() - 48) );
					float lowY = (float) ((1f - (ohlc.low - minValue) / (maxValue - minValue))
							* (super.getHeight() - 48));
					float closeY = (float) ((1f - (ohlc.close - minValue) / (maxValue - minValue))
							* (super.getHeight() - 48));
					*/
					
					float openY = Utils.getCoordinate(ohlc.open,  maxValue, minValue, super.getHeight()-48);
					float highY = Utils.getCoordinate(ohlc.high,  maxValue, minValue, super.getHeight()-48);
					float lowY  = Utils.getCoordinate(ohlc.low,   maxValue, minValue, super.getHeight()-48);
					float closeY= Utils.getCoordinate(ohlc.close, maxValue, minValue, super.getHeight()-48);

					if (ohlc.open < ohlc.close) {
						// stick or line
						//canvas.drawLine(stickX + stickWidth / 2f, highY, stickX
						//		+ stickWidth / 2f, lowY, mPaintPositive);
						if (stickWidth >= 2f) {
							canvas.drawRect(stickX, closeY, stickX + stickWidth,
									openY, mPaintPositive);
						}
						
						canvas.drawLine(stickX + stickWidth / 2f, highY, stickX+stickWidth/2f, closeY, mPaintPositive);
						canvas.drawLine(stickX + stickWidth /2f,openY, stickX+ stickWidth / 2f, lowY, mPaintPositive);
						//canvas.drawLine(stickX + stickWidth / 2f, highY, stickX
						//		+ stickWidth / 2f, lowY, mPaintPositive);
					} else if (ohlc.open > ohlc.close) {
						// stick or line
						if (stickWidth >= 2f) {
							canvas.drawRect(stickX, openY, stickX + stickWidth,
									closeY, mPaintNegative);
						}
						canvas.drawLine(stickX + stickWidth / 2f, highY, stickX
								+ stickWidth / 2f, lowY, mPaintNegative);
					} else {
						// line or point
						if (stickWidth >= 2f) {
							canvas.drawLine(stickX, closeY, stickX + stickWidth,
									openY, mPaintCross);
						}
						canvas.drawLine(stickX + stickWidth / 2f, highY, stickX
								+ stickWidth / 2f, lowY, mPaintCross);
					}

					// next x
					stickX = stickX + 1 + stickWidth;
					if(stickWidth+1<1){
						//for(int j=0;j<1/(stickWidth+1);j++)
						//{
							i=i+(int)(1/(stickWidth+1));
							stickX = stickX + (1+stickWidth)*(int)(1/(stickWidth+1));
						//}
					}
				}
			}
		
		
	}
	int initIndex = 0;
	int endIndex;
	int newsum = 0;
	int sum = 0;
	
	private void initParams(float stickWidth,int sum) {
		//1、获取 index
		//2、获取个数
		int index = (int) (((initX+initX2)/2f-48)/stickWidth);
		float x = touchPostX2-touchPostX;
		float y = touchPostY2-touchPostY;
		float ix = initX2-initX;
		float iy = initY2-initY;
		newsum = (int)((FloatMath.sqrt(ix*ix+iy*iy)/FloatMath.sqrt(x * x + y * y)) * sum);

		System.out.println("xxxxx"+FloatMath.sqrt(ix*ix+iy*iy));
		if(newsum>d.getListEntity().size()) newsum = d.getListEntity().size();
		initIndex = index - newsum/2;
		if(initIndex<0){
			initIndex = 0;
			newsum = newsum+initIndex;
		}
		
		endIndex = index + newsum/2;
	}
	
	int StickSumDisplay = 0;
	int beginIndex = 0;

	public void onData(Data d) {
		// TODO Auto-generated method stub
		this.d = (StockData) d;
		StickSumDisplay = this.d.getStickNum();//this.d.getListEntity().size();
		beginIndex = this.d.getBeginIndex();
		super.onData(d);
	}

	float initX=0,initY=0,initX2=0,initY2=0;
	
	
	public boolean onTouchEvent(MotionEvent event) {
		if(true)return false;
		else{
		//System.out.println("line touch");
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
			//System.out.println("down");
			isTouch = true;
			break;
		case MotionEvent.ACTION_UP:
			initX = 0;
			initY = 0;
			initX2 = 0;
			initY2 = 0;
			sum = newsum;
			this.invalidate();
			System.out.println("up");
			isTouch = false;
			break;
		case MotionEvent.ACTION_MOVE:
			isTouch = true;
			if(initX2 ==0 && initY2==0){
				initX = touchPostX;
				initY = touchPostY;
				initX2 = touchPostX2;
				initY2 = touchPostY2;
			}
			//System.out.println("move");
			this.invalidate();//drawCross();
			break;
		}
		
		return true;}
	}
}
