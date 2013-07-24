package com.example.chart;

import java.util.ArrayList;
import java.util.List;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.BarChart.Type;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;


import com.example.graphics.MyView;
import com.example.graphics.layers.entity.Data;
import com.example.graphics.layers.entity.DataAdapter;
import com.example.graphics.layers.entity.Entity;
import com.example.graphics.layers.entity.ExtendData;
import com.example.graphics.layers.entity.StockData;
import com.example.graphics.layers.entity.StockDataAdapter;
import com.example.graphics.layers.group.StockGroup;
import com.example.graphics.wight.entity.LineEntity;
import com.example.graphics.wight.entity.OHLCEntity;
import com.example.graphics.wight.grid.CandleStickChart;
import com.example.graphics.wight.grid.MACandleStickChart;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class MainActivity extends Activity {
	Context mContext;
	CandleStickChart candlestickchart;
	List<OHLCEntity> ohlc;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.mContext = this;
		setContentView(R.layout.activity_main);
		initViews();
		//addContentView(view, params);
		initEntity();
		initSample();
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				mhandler.sendEmptyMessage(100);
			}
			
		}).start();
	}
	
	List<Entity> lentity = new ArrayList<Entity>();
	private void initEntity(){
        List<Entity> ohlc = new ArrayList<Entity>();
        for(int j=0;j<100;j++){
       // this.ohlc = new ArrayList<Entity>();
        	double i= j*j;
        	if(j<50){
        		i = j*j/2;
        	}else{
        		i = (100-j)*(100-j)/2;
        	}
        	 ohlc.add(new Entity(246+i ,248+i ,235+i ,235+i ,20110825));
             ohlc.add(new Entity(240+i ,242+i ,236+i ,242+i ,20110824));
             ohlc.add(new Entity(236+i ,240+i ,235+i ,240+i ,20110823));
             ohlc.add(new Entity(232+i ,236+i ,231+i ,236+i ,20110822));
             ohlc.add(new Entity(240+i ,240+i ,235+i ,235+i ,20110819));
             ohlc.add(new Entity(240+i ,241+i ,239+i ,240+i ,20110818));
             ohlc.add(new Entity(242+i ,243+i ,240+i ,240+i ,20110817));
             ohlc.add(new Entity(239+i ,242+i ,238+i ,242+i ,20110816));
             ohlc.add(new Entity(239+i ,240+i ,238+i ,239+i ,20110815));
             ohlc.add(new Entity(230+i ,238+i ,230+i ,238+i ,20110812));
             ohlc.add(new Entity(236+i ,237+i ,234+i ,234+i ,20110811));
             ohlc.add(new Entity(226+i ,233+i ,223+i ,232+i ,20110810));
             ohlc.add(new Entity(239+i ,241+i ,229+i ,232+i ,20110809));
             ohlc.add(new Entity(242+i ,244+i ,240+i ,242+i ,20110808));
             ohlc.add(new Entity(248+i ,249+i ,247+i ,248+i ,20110805));
             ohlc.add(new Entity(245+i ,248+i ,245+i ,247+i ,20110804));
             ohlc.add(new Entity(249+i ,249+i ,245+i ,247+i ,20110803));
             ohlc.add(new Entity(249+i ,251+i ,248+i ,250+i ,20110802));
             ohlc.add(new Entity(250+i ,252+i ,248+i ,250+i ,20110801));
             ohlc.add(new Entity(250+i ,251+i ,248+i ,250+i ,20110729));
             ohlc.add(new Entity(249+i ,252+i ,248+i ,252+i ,20110728));
             ohlc.add(new Entity(248+i ,250+i ,247+i ,250+i ,20110727));
             ohlc.add(new Entity(256+i ,256+i ,248+i ,248+i ,20110726));
             ohlc.add(new Entity(257+i ,258+i ,256+i ,257+i ,20110725));
             ohlc.add(new Entity(259+i ,260+i ,256+i ,256+i ,20110722));
             ohlc.add(new Entity(261+i ,261+i ,257+i ,259+i ,20110721));
             ohlc.add(new Entity(260+i ,260+i ,259+i ,259+i ,20110720));
             ohlc.add(new Entity(262+i ,262+i ,260+i ,261+i ,20110719));
             ohlc.add(new Entity(260+i ,262+i ,259+i ,262+i ,20110718));
             ohlc.add(new Entity(259+i ,261+i ,258+i ,261+i ,20110715));
             ohlc.add(new Entity(255+i ,259+i ,255+i ,259+i ,20110714));
             ohlc.add(new Entity(258+i ,258+i ,255+i ,255+i ,20110713));
             ohlc.add(new Entity(258+i ,260+i ,258+i ,260+i ,20110712));
             ohlc.add(new Entity(259+i ,260+i ,258+i ,259+i ,20110711));
             ohlc.add(new Entity(261+i ,262+i ,259+i ,259+i ,20110708));
             ohlc.add(new Entity(261+i ,261+i ,258+i ,261+i ,20110707));
             ohlc.add(new Entity(261+i ,261+i ,259+i ,261+i ,20110706));
             ohlc.add(new Entity(257+i ,261+i ,257+i ,261+i ,20110705));
             ohlc.add(new Entity(256+i ,257+i ,255+i ,255+i ,20110704));
             ohlc.add(new Entity(253+i ,257+i ,253+i ,256+i ,20110701));
             ohlc.add(new Entity(255+i ,255+i ,252+i ,252+i ,20110630));
             ohlc.add(new Entity(256+i ,256+i ,253+i ,255+i ,20110629));
             ohlc.add(new Entity(254+i ,256+i ,254+i ,255+i ,20110628));
             ohlc.add(new Entity(247+i ,256+i ,247+i ,254+i ,20110627));
             ohlc.add(new Entity(244+i ,249+i ,243+i ,248+i ,20110624));
             ohlc.add(new Entity(244+i ,245+i ,243+i ,244+i ,20110623));
             ohlc.add(new Entity(242+i ,244+i ,241+i ,244+i ,20110622));
             ohlc.add(new Entity(243+i ,243+i ,241+i ,242+i ,20110621));
             ohlc.add(new Entity(246+i ,247+i ,244+i ,244+i ,20110620));
             ohlc.add(new Entity(248+i ,249+i ,246+i ,246+i ,20110617));
             ohlc.add(new Entity(251+i ,253+i ,250+i ,250+i ,20110616));
             ohlc.add(new Entity(249+i ,253+i ,249+i ,253+i ,20110615));
             ohlc.add(new Entity(248+i ,250+i ,246+i ,250+i ,20110614));
             ohlc.add(new Entity(249+i ,250+i ,247+i ,250+i ,20110613));
             ohlc.add(new Entity(254+i ,254+i ,250+i ,250+i ,20110610));
             ohlc.add(new Entity(254+i ,255+i ,251+i ,255+i ,20110609));
             ohlc.add(new Entity(252+i ,254+i ,251+i ,254+i ,20110608));
             ohlc.add(new Entity(250+i ,253+i ,250+i ,252+i ,20110607));
             ohlc.add(new Entity(251+i ,252+i ,247+i ,250+i ,20110603));
             ohlc.add(new Entity(253+i ,254+i ,252+i ,254+i ,20110602));
             ohlc.add(new Entity(250+i ,254+i ,250+i ,254+i ,20110601));
             ohlc.add(new Entity(250+i ,252+i ,248+i ,250+i ,20110531));
             ohlc.add(new Entity(253+i ,254+i ,250+i ,251+i ,20110530));
             ohlc.add(new Entity(255+i ,256+i ,253+i ,253+i ,20110527));
             ohlc.add(new Entity(256+i ,257+i ,253+i ,254+i ,20110526));
             ohlc.add(new Entity(256+i ,257+i ,254+i ,256+i ,20110525));
             ohlc.add(new Entity(265+i ,265+i ,257+i ,257+i ,20110524));
             ohlc.add(new Entity(265+i ,266+i ,265+i ,265+i ,20110523));
             ohlc.add(new Entity(267+i ,268+i ,265+i ,266+i ,20110520));
             ohlc.add(new Entity(264+i ,267+i ,264+i ,267+i ,20110519));
             ohlc.add(new Entity(264+i ,266+i ,262+i ,265+i ,20110518));
             ohlc.add(new Entity(266+i ,267+i ,264+i ,264+i ,20110517));
             ohlc.add(new Entity(264+i ,267+i ,263+i ,267+i ,20110516));
             ohlc.add(new Entity(266+i ,267+i ,264+i ,264+i ,20110513));
             ohlc.add(new Entity(269+i ,269+i ,266+i ,268+i ,20110512));
             ohlc.add(new Entity(267+i ,269+i ,266+i ,269+i ,20110511));
             ohlc.add(new Entity(266+i ,268+i ,266+i ,267+i ,20110510));
             ohlc.add(new Entity(264+i ,268+i ,263+i ,266+i ,20110509));
             ohlc.add(new Entity(265+i ,268+i ,265+i ,267+i ,20110506));
             ohlc.add(new Entity(271+i ,271+i ,266+i ,266+i ,20110505));
             ohlc.add(new Entity(271+i ,273+i ,269+i ,273+i ,20110504));
             ohlc.add(new Entity(268+i ,271+i ,267+i ,271+i ,20110503));
        	/*
        ohlc.add(new Entity(246 ,248 ,235 ,235 ,20110825));
        ohlc.add(new Entity(240 ,242 ,236 ,242 ,20110824));
        ohlc.add(new Entity(236 ,240 ,235 ,240 ,20110823));
        ohlc.add(new Entity(232 ,236 ,231 ,236 ,20110822));
        ohlc.add(new Entity(240 ,240 ,235 ,235 ,20110819));
        ohlc.add(new Entity(240 ,241 ,239 ,240 ,20110818));
        ohlc.add(new Entity(242 ,243 ,240 ,240 ,20110817));
        ohlc.add(new Entity(239 ,242 ,238 ,242 ,20110816));
        ohlc.add(new Entity(239 ,240 ,238 ,239 ,20110815));
        ohlc.add(new Entity(230 ,238 ,230 ,238 ,20110812));
        ohlc.add(new Entity(236 ,237 ,234 ,234 ,20110811));
        ohlc.add(new Entity(226 ,233 ,223 ,232 ,20110810));
        ohlc.add(new Entity(239 ,241 ,229 ,232 ,20110809));
        ohlc.add(new Entity(242 ,244 ,240 ,242 ,20110808));
        ohlc.add(new Entity(248 ,249 ,247 ,248 ,20110805));
        ohlc.add(new Entity(245 ,248 ,245 ,247 ,20110804));
        ohlc.add(new Entity(249 ,249 ,245 ,247 ,20110803));
        ohlc.add(new Entity(249 ,251 ,248 ,250 ,20110802));
        ohlc.add(new Entity(250 ,252 ,248 ,250 ,20110801));
        ohlc.add(new Entity(250 ,251 ,248 ,250 ,20110729));
        ohlc.add(new Entity(249 ,252 ,248 ,252 ,20110728));
        ohlc.add(new Entity(248 ,250 ,247 ,250 ,20110727));
        ohlc.add(new Entity(256 ,256 ,248 ,248 ,20110726));
        ohlc.add(new Entity(257 ,258 ,256 ,257 ,20110725));
        ohlc.add(new Entity(259 ,260 ,256 ,256 ,20110722));
        ohlc.add(new Entity(261 ,261 ,257 ,259 ,20110721));
        ohlc.add(new Entity(260 ,260 ,259 ,259 ,20110720));
        ohlc.add(new Entity(262 ,262 ,260 ,261 ,20110719));
        ohlc.add(new Entity(260 ,262 ,259 ,262 ,20110718));
        ohlc.add(new Entity(259 ,261 ,258 ,261 ,20110715));
        ohlc.add(new Entity(255 ,259 ,255 ,259 ,20110714));
        ohlc.add(new Entity(258 ,258 ,255 ,255 ,20110713));
        ohlc.add(new Entity(258 ,260 ,258 ,260 ,20110712));
        ohlc.add(new Entity(259 ,260 ,258 ,259 ,20110711));
        ohlc.add(new Entity(261 ,262 ,259 ,259 ,20110708));
        ohlc.add(new Entity(261 ,261 ,258 ,261 ,20110707));
        ohlc.add(new Entity(261 ,261 ,259 ,261 ,20110706));
        ohlc.add(new Entity(257 ,261 ,257 ,261 ,20110705));
        ohlc.add(new Entity(256 ,257 ,255 ,255 ,20110704));
        ohlc.add(new Entity(253 ,257 ,253 ,256 ,20110701));
        ohlc.add(new Entity(255 ,255 ,252 ,252 ,20110630));
        ohlc.add(new Entity(256 ,256 ,253 ,255 ,20110629));
        ohlc.add(new Entity(254 ,256 ,254 ,255 ,20110628));
        ohlc.add(new Entity(247 ,256 ,247 ,254 ,20110627));
        ohlc.add(new Entity(244 ,249 ,243 ,248 ,20110624));
        ohlc.add(new Entity(244 ,245 ,243 ,244 ,20110623));
        ohlc.add(new Entity(242 ,244 ,241 ,244 ,20110622));
        ohlc.add(new Entity(243 ,243 ,241 ,242 ,20110621));
        ohlc.add(new Entity(246 ,247 ,244 ,244 ,20110620));
        ohlc.add(new Entity(248 ,249 ,246 ,246 ,20110617));
        ohlc.add(new Entity(251 ,253 ,250 ,250 ,20110616));
        ohlc.add(new Entity(249 ,253 ,249 ,253 ,20110615));
        ohlc.add(new Entity(248 ,250 ,246 ,250 ,20110614));
        ohlc.add(new Entity(249 ,250 ,247 ,250 ,20110613));
        ohlc.add(new Entity(254 ,254 ,250 ,250 ,20110610));
        ohlc.add(new Entity(254 ,255 ,251 ,255 ,20110609));
        ohlc.add(new Entity(252 ,254 ,251 ,254 ,20110608));
        ohlc.add(new Entity(250 ,253 ,250 ,252 ,20110607));
        ohlc.add(new Entity(251 ,252 ,247 ,250 ,20110603));
        ohlc.add(new Entity(253 ,254 ,252 ,254 ,20110602));
        ohlc.add(new Entity(250 ,254 ,250 ,254 ,20110601));
        ohlc.add(new Entity(250 ,252 ,248 ,250 ,20110531));
        ohlc.add(new Entity(253 ,254 ,250 ,251 ,20110530));
        ohlc.add(new Entity(255 ,256 ,253 ,253 ,20110527));
        ohlc.add(new Entity(256 ,257 ,253 ,254 ,20110526));
        ohlc.add(new Entity(256 ,257 ,254 ,256 ,20110525));
        ohlc.add(new Entity(265 ,265 ,257 ,257 ,20110524));
        ohlc.add(new Entity(265 ,266 ,265 ,265 ,20110523));
        ohlc.add(new Entity(267 ,268 ,265 ,266 ,20110520));
        ohlc.add(new Entity(264 ,267 ,264 ,267 ,20110519));
        ohlc.add(new Entity(264 ,266 ,262 ,265 ,20110518));
        ohlc.add(new Entity(266 ,267 ,264 ,264 ,20110517));
        ohlc.add(new Entity(264 ,267 ,263 ,267 ,20110516));
        ohlc.add(new Entity(266 ,267 ,264 ,264 ,20110513));
        ohlc.add(new Entity(269 ,269 ,266 ,268 ,20110512));
        ohlc.add(new Entity(267 ,269 ,266 ,269 ,20110511));
        ohlc.add(new Entity(266 ,268 ,266 ,267 ,20110510));
        ohlc.add(new Entity(264 ,268 ,263 ,266 ,20110509));
        ohlc.add(new Entity(265 ,268 ,265 ,267 ,20110506));
        ohlc.add(new Entity(271 ,271 ,266 ,266 ,20110505));
        ohlc.add(new Entity(271 ,273 ,269 ,273 ,20110504));
        ohlc.add(new Entity(268 ,271 ,267 ,271 ,20110503));
        */
        }
        this.lentity = ohlc;
	}
	
	StockDataAdapter adapter ;
	StockData data1 = new StockData("data");
	Entity entity = null;
	int lock = 0;
	int length1 = 0;
	private void initSample() {
		// TODO Auto-generated method stub
		//初始化组，初始化数据
		Data data = new Data("data-1");
		StockGroup group = new StockGroup(this);
		//绑定数据和组
		adapter = new StockDataAdapter(data);
		group.setAdapter(adapter);
		layout.addView(group);
		
		TextView tv = (TextView)findViewById(R.id.textView1);
		tv.setOnClickListener(new OnClickListener() {
			int length = 0;
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				new Thread(new Runnable(){
					@Override
					public void run() {
						// TODO Auto-generated method stub
						length1++;
						length = length1;
						for(int i=0;i<1;i++){
						
							//Entity entity = new Entity(0);
							//entity.setLength(length);
							//data1.addEntity(new Entity(0).setLength(length));
							lock++;
							
							entity = lentity.get(i%82).setLength(length);//new Entity(i).setLength(length);
							length+=10;
							System.out.println(i);
							//adapter.addData(data1);
							//adapter.update();
							mhandler.sendEmptyMessage(100);
							while(lock!=0){
								//try {
								//	new Thread().sleep(1);
								//} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
								//	e1.printStackTrace();
								//}
							}
						}
					}
				}).start();
			}
		});
		
		
	}

	Handler mhandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case 100:
				update();
				break;
			default:
				update();
				break;
			}
		}
		
		private void update() {
			//adapter.addData(data1);
			//adapter.addEntity(entity);
			for(int i=0;i<1;i++)
			adapter.addEntityAll(lentity);
			lock--;
			adapter.update();
			//new Thread(new Runnable(){
			//	@Override
			//	public void run() {
			//	}
			//}).start();

		}
	};


	LinearLayout layout;
	private List<Double> mDataList = new ArrayList<Double>();
	private void initViews(){
		layout = (LinearLayout)this.findViewById(R.id.layout);
		mDataList.add(1.0);
		mDataList.add(2.0);
		mDataList.add(3.0);
		mDataList.add(4.0);
		mDataList.add(5.0);
		mDataList.add(6.0);
		mDataList.add(7.0);
		XYMultipleSeriesDataset dataset = buildBarDataset("test",mDataList);
		XYMultipleSeriesRenderer renderer = buildBarRenderer();
		GraphicalView view = ChartFactory.getBarChartView(this, dataset, renderer, Type.DEFAULT);
		MyView v = new MyView(this);
		
		initOHLC();
		initCandleStickChart();
		candlestickchart.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		
		initMACandleStickChart();
		macandlestickchart.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		//layout.addView(candlestickchart);
	}
	
	
	protected XYMultipleSeriesDataset buildBarDataset(String title,
			List<Double> values) {
		XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
		XYSeries series = new XYSeries(title);

		for (int i = 0; i < values.size(); i++) {
			Double y = values.get(i);

			//series.addColor(getColor(y));
			//series.addLabel(getLabel(y));
			series.add(i + 1, tranBatteryValue(y));
		}

		dataset.addSeries(series);

		return dataset;
	}
	
	private double tranBatteryValue(double in) {
		double out = 0;
		if (in > BAR_YVALUE_SHOW_MAX && in <= BATTERY_VALUE_SHOW_MAX) {
			out = BAR_YVALUE_SHOW_MAX + (in - BAR_YVALUE_SHOW_MAX)
					* (BAR_YVALUE_MAX - BAR_YVALUE_SHOW_MAX)
					/ (BATTERY_VALUE_MAX - BAR_YVALUE_SHOW_MAX);
		} else if (in > BATTERY_VALUE_SHOW_MAX) {
			out = tranBatteryValue(BATTERY_VALUE_SHOW_MAX);
		} else {
			out = in;
		}

		if (in > BAR_YVALUE_SHOW_MAX && in < 30) {
			out = out + 0.25;
		}
		
		return out;
	}
	
	protected String getLabel(double label) {
		boolean bFlag = false;
		String text = "";
		String temp = "";
		if (label < 1) {
			bFlag = true;
			label = label * 60;
			temp = String.format("%.0f", label);
		} else {
			temp = String.format("%.2f", label);
		}

		try {
			if(temp.contains(",")){
				char[] temp_arr = temp.toCharArray();
				for(int i = 0 ; i<temp_arr.length;i++) {
					if(temp_arr[i] == ','){
						temp_arr[i] = '.';
					}
				}
				temp =  new String(temp_arr);
				System.out.println(temp);
			}
			label = Double.valueOf(temp);
		} catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		if (label == Math.round(label)) {
			text = Math.round(label) + "";
		} else {
			text = label + "";
		}
		if (bFlag) {
			text += "m";
		} else {
			text += "h";
		}
		return text;
	}
	  


	protected int getColor(double value) {
		int color = mBarColorNormal;

		if (value < BATTERY_VALUE_DANGE) {
			color = mBarColorDange;
		} else if (value > BATTERY_VALUE_NORMAL) {
			color = mBarColorNice;
		}
		
		return color;
	}
	
	public static final int INDEX_DRAIN_KIND_IDLE = 1;
	public static final int INDEX_DRAIN_KIND_CALL = 2;
	public static final int INDEX_DRAIN_KIND_NET = 3;
	public static final int INDEX_DRAIN_KIND_MUSIC = 4;
	public static final int INDEX_DRAIN_KIND_VIDEO = 5;
	public static final int INDEX_DRAIN_KIND_READ = 6;
	public static final int INDEX_DRAIN_KIND_GAME = 7;

	private static final int BATTERY_VALUE_MAX = 200;
	private static final int BATTERY_VALUE_SHOW_MAX = 150;
	private static final int BAR_YVALUE_MIN = 0;
	private static final int BAR_YVALUE_MAX = 11;
	private static final int BAR_YVALUE_SHOW_MAX = 8;

	private static final Double BAR_XVALUE_MIN = 0.5;
	private static final Double BAR_XVALUE_MAX = 7.5;
	
	private static final Double BATTERY_VALUE_DANGE = 1.0;
	private static final Double BATTERY_VALUE_NORMAL = 8.0;
	
	private int mBarLabelColor = Color.rgb(0, 0, 0);
	private int mAxesColor = Color.rgb(0, 0, 0);
	
	private int mBarColorNice = Color.rgb(143, 201, 0);
	private int mBarColorNormal = Color.rgb(64, 150, 238);
	private int mBarColorDange = Color.rgb(255, 26, 0);
	private int mBarChartBackgroundColor = Color.rgb(0, 0, 0);



    private int mBarMarginTop = 90;
    private int mBarMarginBottom = 23 ;
    private int mBarMarginLeft = 45;
    private int mBarMarginRight = 39;

    private int mAxisTitleTextSize = 20  ;
    private int mLabelsTextSize = 20 ;
    private int mChartValuesTextSize  = 20;

	
	protected XYMultipleSeriesRenderer buildBarRenderer() {
		XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();

		renderer.setChartTitle("label");		
		renderer.setChartTitleTextSize(mAxisTitleTextSize);		

		renderer.setApplyBackgroundColor(true);
		renderer.setBackgroundColor(mBarChartBackgroundColor);
		renderer.setMarginsColor(mBarChartBackgroundColor);
		renderer.setAxesColor(mBarLabelColor);
		renderer.setLabelsColor(mAxesColor);
		
		renderer.setAxisTitleTextSize(mLabelsTextSize);
		renderer.setLabelsTextSize(mAxisTitleTextSize);

//		renderer.setLegendTextSize(16);

		//renderer.setYTitle(mContext.getString(R.string.label_text_leaving_time));
		renderer.setShowLegend(false);

		renderer.setXAxisMin(BAR_XVALUE_MIN);
		renderer.setXAxisMax(BAR_XVALUE_MAX);
		renderer.setYAxisMin(BAR_YVALUE_MIN);
		renderer.setYAxisMax(BAR_YVALUE_MAX);

		renderer.setXLabels(0);
		renderer.setYLabels(0);
		renderer.addXTextLabel(INDEX_DRAIN_KIND_IDLE, "idle");
		renderer.addXTextLabel(INDEX_DRAIN_KIND_CALL, "call");
		renderer.addXTextLabel(INDEX_DRAIN_KIND_NET, "net");
		renderer.addXTextLabel(INDEX_DRAIN_KIND_MUSIC,"music");
		renderer.addXTextLabel(INDEX_DRAIN_KIND_VIDEO, "video");
		renderer.addXTextLabel(INDEX_DRAIN_KIND_READ, "read");
		renderer.addXTextLabel(INDEX_DRAIN_KIND_GAME, "game");

		for (int i = 0; i <= BAR_YVALUE_MAX; i++) {
			if (i <= BAR_YVALUE_SHOW_MAX) {
				renderer.addYTextLabel(i, Integer.toString(i) + "   ");
			} else if (i == BAR_YVALUE_MAX) {
				renderer.addYTextLabel(i, "MAX");
			} else {
//				renderer.addYTextLabel(i, Integer.toString(i) + "  " );
			}
		}

		renderer.setMargins(new int[] { mBarMarginTop, mBarMarginLeft,
				mBarMarginBottom, mBarMarginRight });
		renderer.setYLabelsAlign(Align.RIGHT);
		renderer.setXLabelsAlign(Align.CENTER);
		renderer.setPanEnabled(false, false);
		renderer.setZoomEnabled(false, false);
		renderer.setBarSpacing(1.5f);

		SimpleSeriesRenderer r = new SimpleSeriesRenderer();
		r.setColor(mAxesColor);
		r.setDisplayChartValues(true);
		r.setChartValuesTextAlign(Align.CENTER);

		r.setChartValuesTextSize(mChartValuesTextSize);

		//r.setIsApplySetBarColor(true);
		//r.setIsApplySetBarLabel(true);
		renderer.addSeriesRenderer(r);

		return renderer;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}


	private void initCandleStickChart()
	{
        this.candlestickchart = new CandleStickChart(this);
        candlestickchart.setAxisXColor(Color.LTGRAY);
        candlestickchart.setAxisYColor(Color.LTGRAY);
        candlestickchart.setLatitudeColor(Color.GRAY);
        candlestickchart.setLongitudeColor(Color.GRAY);
        candlestickchart.setBorderColor(Color.LTGRAY);
        candlestickchart.setLongitudeFontColor(Color.WHITE);
        candlestickchart.setLatitudeFontColor(Color.WHITE);
        candlestickchart.setAxisMarginRight(1);
        
        //最大显示足数
        candlestickchart.setMaxSticksNum(52);
        //最大纬线数
        candlestickchart.setLatitudeNum(5);
        //最大经线数
        candlestickchart.setLongitudeNum(3);
        //最大价格
        candlestickchart.setMaxValue(1000);
        //最小价格
        candlestickchart.setMinValue(200);
        
        candlestickchart.setDisplayAxisXTitle(true);
        candlestickchart.setDisplayAxisYTitle(true);
        candlestickchart.setDisplayLatitude(true);
        candlestickchart.setDisplayLongitude(true);
        candlestickchart.setBackgroundColor(Color.BLACK);
        
        //为chart2增加均线
        candlestickchart.setOHLCData(ohlc);
	}

	private void initOHLC(){
        List<OHLCEntity> ohlc = new ArrayList<OHLCEntity>();
        
        this.ohlc = new ArrayList<OHLCEntity>();
        for(int i=0;i<5;i++){
        ohlc.add(new OHLCEntity(246 ,248 ,235 ,235 ,20110825));
        ohlc.add(new OHLCEntity(240 ,242 ,236 ,242 ,20110824));
        ohlc.add(new OHLCEntity(236 ,240 ,235 ,240 ,20110823));
        ohlc.add(new OHLCEntity(232 ,236 ,231 ,236 ,20110822));
        ohlc.add(new OHLCEntity(240 ,240 ,235 ,235 ,20110819));
        ohlc.add(new OHLCEntity(240 ,241 ,239 ,240 ,20110818));
        ohlc.add(new OHLCEntity(242 ,243 ,240 ,240 ,20110817));
        ohlc.add(new OHLCEntity(239 ,242 ,238 ,242 ,20110816));
        ohlc.add(new OHLCEntity(239 ,240 ,238 ,239 ,20110815));
        ohlc.add(new OHLCEntity(230 ,238 ,230 ,238 ,20110812));
        ohlc.add(new OHLCEntity(236 ,237 ,234 ,234 ,20110811));
        ohlc.add(new OHLCEntity(226 ,233 ,223 ,232 ,20110810));
        ohlc.add(new OHLCEntity(239 ,241 ,229 ,232 ,20110809));
        ohlc.add(new OHLCEntity(242 ,244 ,240 ,242 ,20110808));
        ohlc.add(new OHLCEntity(248 ,249 ,247 ,248 ,20110805));
        ohlc.add(new OHLCEntity(245 ,248 ,245 ,247 ,20110804));
        ohlc.add(new OHLCEntity(249 ,249 ,245 ,247 ,20110803));
        ohlc.add(new OHLCEntity(249 ,251 ,248 ,250 ,20110802));
        ohlc.add(new OHLCEntity(250 ,252 ,248 ,250 ,20110801));
        ohlc.add(new OHLCEntity(250 ,251 ,248 ,250 ,20110729));
        ohlc.add(new OHLCEntity(249 ,252 ,248 ,252 ,20110728));
        ohlc.add(new OHLCEntity(248 ,250 ,247 ,250 ,20110727));
        ohlc.add(new OHLCEntity(256 ,256 ,248 ,248 ,20110726));
        ohlc.add(new OHLCEntity(257 ,258 ,256 ,257 ,20110725));
        ohlc.add(new OHLCEntity(259 ,260 ,256 ,256 ,20110722));
        ohlc.add(new OHLCEntity(261 ,261 ,257 ,259 ,20110721));
        ohlc.add(new OHLCEntity(260 ,260 ,259 ,259 ,20110720));
        ohlc.add(new OHLCEntity(262 ,262 ,260 ,261 ,20110719));
        ohlc.add(new OHLCEntity(260 ,262 ,259 ,262 ,20110718));
        ohlc.add(new OHLCEntity(259 ,261 ,258 ,261 ,20110715));
        ohlc.add(new OHLCEntity(255 ,259 ,255 ,259 ,20110714));
        ohlc.add(new OHLCEntity(258 ,258 ,255 ,255 ,20110713));
        ohlc.add(new OHLCEntity(258 ,260 ,258 ,260 ,20110712));
        ohlc.add(new OHLCEntity(259 ,260 ,258 ,259 ,20110711));
        ohlc.add(new OHLCEntity(261 ,262 ,259 ,259 ,20110708));
        ohlc.add(new OHLCEntity(261 ,261 ,258 ,261 ,20110707));
        ohlc.add(new OHLCEntity(261 ,261 ,259 ,261 ,20110706));
        ohlc.add(new OHLCEntity(257 ,261 ,257 ,261 ,20110705));
        ohlc.add(new OHLCEntity(256 ,257 ,255 ,255 ,20110704));
        ohlc.add(new OHLCEntity(253 ,257 ,253 ,256 ,20110701));
        ohlc.add(new OHLCEntity(255 ,255 ,252 ,252 ,20110630));
        ohlc.add(new OHLCEntity(256 ,256 ,253 ,255 ,20110629));
        ohlc.add(new OHLCEntity(254 ,256 ,254 ,255 ,20110628));
        ohlc.add(new OHLCEntity(247 ,256 ,247 ,254 ,20110627));
        ohlc.add(new OHLCEntity(244 ,249 ,243 ,248 ,20110624));
        ohlc.add(new OHLCEntity(244 ,245 ,243 ,244 ,20110623));
        ohlc.add(new OHLCEntity(242 ,244 ,241 ,244 ,20110622));
        ohlc.add(new OHLCEntity(243 ,243 ,241 ,242 ,20110621));
        ohlc.add(new OHLCEntity(246 ,247 ,244 ,244 ,20110620));
        ohlc.add(new OHLCEntity(248 ,249 ,246 ,246 ,20110617));
        ohlc.add(new OHLCEntity(251 ,253 ,250 ,250 ,20110616));
        ohlc.add(new OHLCEntity(249 ,253 ,249 ,253 ,20110615));
        ohlc.add(new OHLCEntity(248 ,250 ,246 ,250 ,20110614));
        ohlc.add(new OHLCEntity(249 ,250 ,247 ,250 ,20110613));
        ohlc.add(new OHLCEntity(254 ,254 ,250 ,250 ,20110610));
        ohlc.add(new OHLCEntity(254 ,255 ,251 ,255 ,20110609));
        ohlc.add(new OHLCEntity(252 ,254 ,251 ,254 ,20110608));
        ohlc.add(new OHLCEntity(250 ,253 ,250 ,252 ,20110607));
        ohlc.add(new OHLCEntity(251 ,252 ,247 ,250 ,20110603));
        ohlc.add(new OHLCEntity(253 ,254 ,252 ,254 ,20110602));
        ohlc.add(new OHLCEntity(250 ,254 ,250 ,254 ,20110601));
        ohlc.add(new OHLCEntity(250 ,252 ,248 ,250 ,20110531));
        ohlc.add(new OHLCEntity(253 ,254 ,250 ,251 ,20110530));
        ohlc.add(new OHLCEntity(255 ,256 ,253 ,253 ,20110527));
        ohlc.add(new OHLCEntity(256 ,257 ,253 ,254 ,20110526));
        ohlc.add(new OHLCEntity(256 ,257 ,254 ,256 ,20110525));
        ohlc.add(new OHLCEntity(265 ,265 ,257 ,257 ,20110524));
        ohlc.add(new OHLCEntity(265 ,266 ,265 ,265 ,20110523));
        ohlc.add(new OHLCEntity(267 ,268 ,265 ,266 ,20110520));
        ohlc.add(new OHLCEntity(264 ,267 ,264 ,267 ,20110519));
        ohlc.add(new OHLCEntity(264 ,266 ,262 ,265 ,20110518));
        ohlc.add(new OHLCEntity(266 ,267 ,264 ,264 ,20110517));
        ohlc.add(new OHLCEntity(264 ,267 ,263 ,267 ,20110516));
        ohlc.add(new OHLCEntity(266 ,267 ,264 ,264 ,20110513));
        ohlc.add(new OHLCEntity(269 ,269 ,266 ,268 ,20110512));
        ohlc.add(new OHLCEntity(267 ,269 ,266 ,269 ,20110511));
        ohlc.add(new OHLCEntity(266 ,268 ,266 ,267 ,20110510));
        ohlc.add(new OHLCEntity(264 ,268 ,263 ,266 ,20110509));
        ohlc.add(new OHLCEntity(265 ,268 ,265 ,267 ,20110506));
        ohlc.add(new OHLCEntity(271 ,271 ,266 ,266 ,20110505));
        ohlc.add(new OHLCEntity(271 ,273 ,269 ,273 ,20110504));
        ohlc.add(new OHLCEntity(268 ,271 ,267 ,271 ,20110503));
//        ohlc.add(new OHLCEntity(273 ,275 ,268 ,268 ,20110429));
//        ohlc.add(new OHLCEntity(274 ,276 ,270 ,272 ,20110428));
//        ohlc.add(new OHLCEntity(275 ,277 ,273 ,273 ,20110427));
//        ohlc.add(new OHLCEntity(280 ,280 ,276 ,276 ,20110426));
//        ohlc.add(new OHLCEntity(282 ,283 ,280 ,281 ,20110425));
//        ohlc.add(new OHLCEntity(282 ,283 ,281 ,282 ,20110422));
//        ohlc.add(new OHLCEntity(280 ,281 ,279 ,280 ,20110421));
//        ohlc.add(new OHLCEntity(283 ,283 ,279 ,279 ,20110420));
//        ohlc.add(new OHLCEntity(284 ,286 ,283 ,285 ,20110419));
//        ohlc.add(new OHLCEntity(283 ,286 ,282 ,285 ,20110418));
//        ohlc.add(new OHLCEntity(285 ,285 ,283 ,284 ,20110415));
//        ohlc.add(new OHLCEntity(280 ,285 ,279 ,285 ,20110414));
//        ohlc.add(new OHLCEntity(281 ,283 ,280 ,282 ,20110413));
//        ohlc.add(new OHLCEntity(283 ,286 ,282 ,282 ,20110412));
//        ohlc.add(new OHLCEntity(280 ,283 ,279 ,283 ,20110411));
//        ohlc.add(new OHLCEntity(280 ,281 ,279 ,280 ,20110408));
//        ohlc.add(new OHLCEntity(276 ,280 ,276 ,280 ,20110407));
//        ohlc.add(new OHLCEntity(273 ,276 ,272 ,276 ,20110406));
//        ohlc.add(new OHLCEntity(275 ,276 ,271 ,272 ,20110404));
//        ohlc.add(new OHLCEntity(275 ,276 ,273 ,275 ,20110401));
        }
        for(int i= ohlc.size(); i > 0 ; i--){
        	this.ohlc.add(ohlc.get(i -1));
        }
	}
	
	
	MACandleStickChart macandlestickchart;
	private void initMACandleStickChart()
	{
        this.macandlestickchart = new MACandleStickChart(this);
      List<LineEntity> lines = new ArrayList<LineEntity>();
      
      //计算5日均线
      LineEntity MA5 = new LineEntity();
      MA5.setTitle("MA5");
      MA5.setLineColor(Color.WHITE);
      MA5.setLineData(initMA(5));
      lines.add(MA5);
      
      //计算10日均线
      LineEntity MA10 = new LineEntity();
      MA10.setTitle("MA10");
      MA10.setLineColor(Color.RED);
      MA10.setLineData(initMA(10));
      lines.add(MA10);
      
      //计算25日均线
      LineEntity MA25 = new LineEntity();
      MA25.setTitle("MA25");
      MA25.setLineColor(Color.GREEN);
      MA25.setLineData(initMA(25));
      lines.add(MA25);
      
      macandlestickchart.setAxisXColor(Color.LTGRAY);
      macandlestickchart.setAxisYColor(Color.LTGRAY);
      macandlestickchart.setLatitudeColor(Color.GRAY);
      macandlestickchart.setLongitudeColor(Color.GRAY);
      macandlestickchart.setBorderColor(Color.LTGRAY);
      macandlestickchart.setLongitudeFontColor(Color.WHITE);
      macandlestickchart.setLatitudeFontColor(Color.WHITE);
      macandlestickchart.setAxisMarginRight(1);
      
      //最大显示足数
      macandlestickchart.setMaxSticksNum(52);
      //最大纬线数
      macandlestickchart.setLatitudeNum(5);
      //最大经线数
      macandlestickchart.setLongitudeNum(3);
      //最大价格
      macandlestickchart.setMaxValue(1000);
      //最小价格
      macandlestickchart.setMinValue(200);
      
      macandlestickchart.setDisplayAxisXTitle(true);
      macandlestickchart.setDisplayAxisYTitle(true);
      macandlestickchart.setDisplayLatitude(true);
      macandlestickchart.setDisplayLongitude(true);
      macandlestickchart.setBackgroundColor(Color.BLACK);

      
    //为chart2增加均线
    macandlestickchart.setLineData(lines);
    
    //为chart2增加均线
    macandlestickchart.setOHLCData(ohlc);
        
	}
	

	private List<Float> initMA(int days){
		
		if (days < 2){
			return null;
		}
		
        List<Float> MA5Values = new ArrayList<Float>();
        
    	float sum = 0;
    	float avg = 0;
        for(int i = 0 ; i < this.ohlc.size(); i++){
        	float close =(float)ohlc.get(i).getClose();
        	if(i< days){
        		sum = sum + close;
        		avg = sum / (i + 1f);
        	}else{
        		sum = sum + close - (float)ohlc.get(i-days).getClose();
        		avg = sum / days;
        	}
        	MA5Values.add(avg);
        }
        
        return MA5Values;
	}
}
