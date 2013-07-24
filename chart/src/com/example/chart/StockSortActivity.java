package com.example.chart;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class StockSortActivity extends Activity{
	Context mContext;
	ListView lv;
	StockAdapter adapter;
	TextView tv;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.mContext = this;
		setContentView(R.layout.activity_stocksort);
		initViews();

	}
	private void initViews() {
		// TODO Auto-generated method stub
		lv = (ListView)findViewById(R.id.listView1);
		adapter = new StockAdapter(this,handler);
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				System.out.println("onItemClick:"+arg2);
				startActivity(new Intent(StockSortActivity.this,MainActivity.class));
			}
		});
		
		tv = (TextView)findViewById(R.id.textView1);
		tv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//请求数据
				httprequest req = new httprequest(cb);
				req.execute("");
				System.out.println("zzzzzzz");
				//cb.update();
				//

				//ms.add(null);
				//adapter.addAll(ms);
				//adapter.notifyDataSetChanged();
				//
			}
		});
	}
	
	List<StockInfo> ms=new ArrayList<StockInfo>();
	ICallBack cb = new ICallBack() {

		@Override
		public void update(String result) {
			// TODO Auto-generated method stub
			// [^( |"|:|”|>|\u0022)](|<xliff:g [^>]+>)%[^\/s]+s
			//"[^"]+"
			String regEx = "\"[^\"]+\"";
			Pattern pat = Pattern.compile(regEx);  
			Matcher mat = pat.matcher(result);  
			//boolean rs = mat.find();  
			while(mat.find()){

				String str = mat.group();
				System.out.println(str);
				StockInfo si = new StockInfo(str);
				//
				//[^,]*
				//
				Pattern pat2 = Pattern.compile("[^,]*");
				Matcher mat2 = pat2.matcher(str);
				int i=0;
				while(mat2.find()){
					//System.out.println(mat2.group()+"|"+i);
					if(mat2.group().equals(""))
						continue;
					
					switch(i){
					case 1:
						si.Code 	= mat2.group();break;
					case 2:
						si.name 	= mat2.group();break;
					case 3:
						si.yclose 	= Double.parseDouble(mat2.group());break;
					case 4:
						si.open 	= Double.parseDouble(mat2.group());break;
					case 5:
						si.price 	= Double.parseDouble(mat2.group());break;
					case 6:
						si.high 	= Double.parseDouble(mat2.group());break;
					case 7:
						si.low 		= Double.parseDouble(mat2.group());break;
					case 8:
						si.vol 		= Double.parseDouble(mat2.group());break;
					case 9:
						si.tur 		= Double.parseDouble(mat2.group());break;
					case 10:
						si.change 	= Double.parseDouble(mat2.group());break;
					case 11:
						si.turoverate =mat2.group();break;
						
					}
					i++;
				}
				//
				ms.add(si);
			}
			//tv.setText(result);
			adapter.addAll(ms);
			adapter.notifyDataSetChanged();
		}
	};
	
	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			if (msg.what == 1) {
				adapter.notifyDataSetChanged();//数据库发生改变时更新adapter
			}
		}
	};
	
}
