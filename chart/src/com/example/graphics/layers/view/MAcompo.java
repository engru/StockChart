package com.example.graphics.layers.view;

import java.util.List;

import com.example.graphics.layers.entity.Data;
import com.example.graphics.layers.entity.MAsEntity.MAEntity;
import com.example.graphics.layers.entity.StockData;
import com.example.graphics.layers.utils.Utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.MotionEvent;

public class MAcompo extends compo {
	StockData sd = null;
	float stickWidth;
	public MAcompo(Context mContext, String name) {
		super(mContext, name);
		// TODO Auto-generated constructor stub
	}
	
	
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		System.out.print("madraw:"+(sd!=null?"true |":"false\n"));
		if(sd!=null){
			System.out.println(sd.getListEntity().size()+"|"+sd.getMAsEntity().getListMAEntity().size());
		}
		if(sd!=null && sd.getMAsEntity()!=null && sd.getMAsEntity().getListMAEntity().size()!=0){
			drawMALines(canvas);
		}

	}



	private void drawMALines(Canvas canvas) {
		stickWidth = ((float)(this.getWidth() - 48)/ sd.getStickNum());
		List<MAEntity> lma = sd.getMAsEntity().getListMAEntity();
		for(int i=0; i<lma.size(); i++){
			Paint paint = new Paint();
			paint.setStrokeWidth(2);
			paint.setColor(lma.get(i).getLineColor());
			float startX = 48 + stickWidth/2f;
			PointF ptFirst = null;
			MAEntity entity = lma.get(i);
			System.out.println(entity.getLineData().size()+"|"+sd.getBeginIndex()+"|"+sd.getStickNum());
			for(int j= sd.getBeginIndex() ;j<sd.getBeginIndex()+sd.getStickNum();j++){
				//sd.getListEntity().get(j).close
				//System.out.println("+"+j);
				float valueY = Utils.getCoordinate(entity.getLineData().get(j),
						sd.getMaxValue(), sd.getMinValue(), super.getHeight()-48);
				//System.out.println(valueY);
				if(j>sd.getBeginIndex())
					canvas.drawLine(ptFirst.x, ptFirst.y, startX,valueY, paint);
				
				ptFirst = new PointF(startX,valueY);
				startX += stickWidth;
				if(stickWidth<1){
					//for(int j=0;j<1/(stickWidth+1);j++)
					//{
						j += (int)(1/stickWidth);
						startX += stickWidth*(int)(1/stickWidth);
					//}
				}
				//System.out.println("-"+j+"|"+this.getWidth()+"|"+sd.getStickNum());
			}
		}
	}


	@Override
	public void onData(Data d) {
		// TODO Auto-generated method stub
		sd = (StockData) d;
		//stickWidth = ((float)(this.getWidth() - 48)/ sd.getStickNum());
		//System.out.println((this.getWidth()-48)+"|"+sd.getStickNum()+"|"+(float)(this.getWidth()-48)/sd.getStickNum());
		super.onData(d);
	}
	
	
	
	public boolean onTouchEvent(MotionEvent event) {
		return false;
	}
}
