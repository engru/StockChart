package com.example.graphics.coverage.view;

import com.example.graphics.coverage.entity.Data;
import com.example.graphics.coverage.entity.Entity;
import com.example.graphics.coverage.entity.StockData;
import com.example.graphics.coverage.utils.Utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;

public class Touchcompo extends compo {

	float stickWidth = 0;//((float)(super.getWidth() - 48)/ d.getListEntity().size()) - 1;
	
	public Touchcompo(Context mContext, String name) {
		super(mContext, name);
		// TODO Auto-generated constructor stub
	}
	
	protected void onDraw(Canvas canvas) {
		if(isTouch)
			drawCross(canvas);
	}
	
	private void drawCross(Canvas canvas) {
		// TODO Auto-generated method stub
		System.out.println("drawtouch");
		Paint paint = new Paint();
		paint.setStrokeWidth(2);
		paint.setColor(Color.GRAY);
		//canvas.drawLine(touchPostX, 0, touchPostX, this.getHeight(), paint);
		//canvas.drawLine(0, touchPostY, this.getWidth(), touchPostY, paint);
		if(touchPostX2 != 0 && touchPostY2 !=0){
			canvas.drawLine(touchPostX2, 0, touchPostX2, this.getHeight(), paint);
			//canvas.drawLine(0, touchPostY2, this.getWidth(), touchPostY2, paint);

			System.out.println("touch2:"+touchPostX2);
		}
		
		int index = (int) ((touchPostX-48)/stickWidth);
		System.out.println("index:"+index+"|touch:"+touchPostX);
		Entity entity = null;
		if(index>=0)
			entity = sd.getListEntity().get(index);
		float closeY = 200;
		if(entity!=null)
			closeY = Utils.getCoordinate(entity.close, sd.getMaxValue(), sd.getMinValue(), super.getHeight()-48 );
		
		canvas.drawLine(48+index*stickWidth+(stickWidth+1)/2f, 0, 48+index*stickWidth+(stickWidth+1)/2f, this.getHeight(), paint);
		canvas.drawLine(0, closeY, this.getWidth(), closeY, paint);
	}

	StockData sd = null;
	@Override
	public void onData(Data d) {
		sd = (StockData)d;
		stickWidth = ((float)(super.getWidth() - 48)/ sd.getStickNum());
		//this.invalidate();
		super.onData(d);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		//接受触屏事件，比如缩放，显示指标，拖动
		System.out.println("ontouchcompo");
		

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
		
		System.out.print("sd:"+(sd!=null?"not null":"null\n"));
		if(sd!=null) System.out.println("|size:"+ sd.getListEntity().size());
		if(sd!=null && sd.getListEntity().size()>0){
			if(touchPostX2!=0 || touchPostY2!=0){
				System.out.println("zzzzzzzzzzzz");
				return false;
			}else{
				System.out.println("zzzzzzzzzzzzccccccccccc");
				return false;
			}
		}else{
			return false;
		}
	}
}
