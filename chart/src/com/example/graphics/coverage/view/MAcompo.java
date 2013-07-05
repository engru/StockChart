package com.example.graphics.coverage.view;

import android.content.Context;
import android.view.MotionEvent;

public class MAcompo extends compo {

	public MAcompo(Context mContext, String name) {
		super(mContext, name);
		// TODO Auto-generated constructor stub
	}
	public boolean onTouchEvent(MotionEvent event) {
		//接受触屏事件，比如缩放，显示指标，拖动
		System.out.println("xxxxxxxontouchcompo");
		return false;
	}
}
