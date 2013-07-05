package com.example.graphics.coverage.view;

import java.util.List;

import com.example.graphics.coverage.Constants;
import com.example.graphics.coverage.entity.Data;
import com.example.graphics.coverage.entity.StockData;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Paint.Style;
import android.view.MotionEvent;

public class GridCompo extends compo {
	private boolean displayLongitude = Constants.DEFAULT_DISPLAY_LONGITUDE;
	private boolean displayLatitude = Constants.DEFAULT_DISPLAY_LATITUDE;
	private boolean displayAxisXTitle = Constants.DEFAULT_DISPLAY_AXIS_X_TITLE;
	private boolean displayAxisYTitle = Constants.DEFAULT_DISPLAY_AXIS_X_TITLE;
	
	
	public GridCompo(Context mContext, String name) {
		super(mContext, name);
		// TODO Auto-generated constructor stub
	}
	
	
	protected void onDraw(Canvas canvas) {
		System.out.println("griddraw");
		//绘制边框
		//绘制坐标轴
		drawXAxis(canvas);
		drawYAxis(canvas);
		//绘制刻度标
		//横轴日期
		if (displayLongitude || displayAxisXTitle) {
			drawAxisGridX(canvas);
		}
		//纵轴价格啥的
		if (displayLatitude || displayAxisYTitle) {
			drawAxisGridY(canvas);
		}
		//绘制其他

	}
	


	protected void drawXAxis(Canvas canvas) {

		float length = super.getWidth();
		float postY = super.getHeight() - 48;

		Paint mPaint = new Paint();
		mPaint.setColor(Color.BLUE);

		canvas.drawLine(48f, postY, length, postY, mPaint);

	}


	protected void drawYAxis(Canvas canvas) {

		float length = super.getHeight() - 48;
		float postX = 48;

		Paint mPaint = new Paint();
		mPaint.setColor(Color.BLUE);

		canvas.drawLine(postX, 0f, postX, length+32, mPaint);
	}
	
	
	
	protected void drawAxisGridX(Canvas canvas) {

		//if (null != axisXTitles) {
			int counts = 4;//axisXTitles.size();
			float length = super.getHeight() - 48;

			Paint mPaintLine = new Paint();
		//	mPaintLine.setColor(longitudeColor);
		//	if (dashLongitude) {
		//		mPaintLine.setPathEffect(dashEffect);
		//	}

			Paint mPaintFont = new Paint();
	//		mPaintFont.setColor(longitudeFontColor);
			mPaintFont.setTextSize(25);
	//		mPaintFont.setAntiAlias(true);
			if (counts > 1) {
				float postOffset = (super.getWidth() - 48) / (counts - 1);
				float offset = 48;
				for (int i = 0; i <= counts; i++) {
					// draw line
					if (displayLongitude) {
						//canvas.drawLine(offset + i * postOffset, 0f, offset + i
						//		* postOffset, length, mPaintLine);
						mPaintLine.setStyle(Style.STROKE);
						mPaintLine.setPathEffect(new DashPathEffect(new float[]{5,5,5,5}, 1));
						Path path = new Path();
						if(i==3){
							path.moveTo(offset + i * postOffset-10, 0f); 
							path.lineTo(offset + i * postOffset-10,length);
						}else {
							path.moveTo(offset + i * postOffset, 0f);
							path.lineTo(offset + i * postOffset,length);
						}
						canvas.drawPath(path, mPaintLine);
					}
					// draw title
					if (displayAxisXTitle) {
						if (i < counts && i > 0) {
							canvas.drawText("20130728", offset + i
									* postOffset
									- ("20130728".length())
									* 25 / 4f, super.getHeight() - 48 + 25,
									mPaintFont);
						} else if (0 == i) {
							canvas.drawText("20130528", 48 + 2f, super.getHeight() - 48 + 25, mPaintFont);
						}
					//}
				}
			}
		}
	}
	
	private void drawAxisGridY(Canvas canvas) {
		
		int offset = 48;
		int postOffset = (this.getHeight()-48) / 4;
		
		float wave = maxvalue - minvalue;
		float h = wave/4;
		
		Paint paint = new Paint();
		paint.setTextSize(25);
		for(int i=0;i<=4;i++){
			if(i!=4)
			canvas.drawLine(offset, i*postOffset, this.getWidth(), i*postOffset, paint);
			canvas.drawText(""+(int)(h*(4-i)+minvalue), 0, i*postOffset+25, paint);
		}
	}
	
	
	//public void onInterceptData(List<Data> ld) {
		// TODO Auto-generated method stub
		//确定是否处理此数据
	//	this.onData(ld);
	//}
	float maxvalue,minvalue;
	public void onData(Data d) {
		// TODO Auto-generated method stub
		//length = ((ExtendData)(d)).getLenght();
		//length = ((StockData)(d)).getListEntity().get(0).getLength();
		//this.d = (StockData) d;
		maxvalue = ((StockData)d).getMaxValue();
		minvalue = ((StockData)d).getMinValue();
		
		super.onData(d);
	}
	
	public boolean onTouchEvent(MotionEvent event) {
		return false;
	}
}
