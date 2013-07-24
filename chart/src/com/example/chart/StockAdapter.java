package com.example.chart;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class StockAdapter extends ArrayAdapter{
	Context mContext;
	List<StockInfo> mStockInfoList = new ArrayList<StockInfo>();
	Handler handler;
	
	public StockAdapter(Context context) {
		super(context, 0);
		// TODO Auto-generated constructor stub
		mContext = context;
	}
	
	public StockAdapter(Context context,Handler handler) {
		super(context, 0);
		// TODO Auto-generated constructor stub
		mContext = context;
		this.handler = handler;
	}
	
	public void addAll(List<StockInfo> mStockInfoList){
		this.mStockInfoList.addAll(mStockInfoList);
	}
	
	public void add(StockInfo mStockInfo){
		this.mStockInfoList.add(mStockInfo);
	}
	
    public int getCount() {   
        // TODO Auto-generated method stub
    	return mStockInfoList.size();
    }
    
    /*
    @Override  
    public Object getItem(int position) {  
        // TODO Auto-generated method stub  
    	System.out.println("getItem:"+position);
        return null;  
    }  

    @Override  
    public long getItemId(int position) {  
        // TODO Auto-generated method stub  
    	System.out.println("getItemId:"+position);
        return position;  
    }  
	*/
   
    Holder holderback=null;
	public View getView(int position, View convertView, ViewGroup parent){
		System.out.println("getview:"+position+"|"+mStockInfoList.get(position).moreInfo+"|"+(convertView!=null?"true":"false"));
		final int position1=position;

		
		Holder holder = null;
		if(convertView!=null){
			holder = (Holder)convertView.getTag();   
		}else{
			holder = new Holder();
			convertView = LayoutInflater.from(mContext).inflate(R.layout.row_stock_list,null); 
			
			holder.fl = (LinearLayout)convertView.findViewById(R.id.stock);
			holder.rl = (RelativeLayout)convertView.findViewById(R.id.stock2);
			
			holder.tv_code = (TextView)convertView.findViewById(R.id.tv_code);
			holder.tv_name = (TextView)convertView.findViewById(R.id.tv_name);
			holder.tv_turoverate = (TextView)convertView.findViewById(R.id.tv_turoverate);
			holder.tv_price =(TextView)convertView.findViewById(R.id.tv_price);
			holder.tv_change=(TextView)convertView.findViewById(R.id.tv_change);
			
			holder.tv = (TextView)convertView.findViewById(R.id.tv_more_info);
			
			convertView.setTag(holder);
			
		}
		//
		holderback = holder;
		
		holder.rl.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//holderback.tv.setText(mStockInfoList.get(position1).id);
				//tv.setVisibility(View.VISIBLE);
				//holderback.rl.setVisibility(View.GONE);
				System.out.println("onclick:"+position1);
				mStockInfoList.get(position1).moreInfo =!mStockInfoList.get(position1).moreInfo;
				handler.sendEmptyMessage(1);
			}
		});

		
		holder.tv_code.setText(mStockInfoList.get(position).Code);
		holder.tv_name.setText(mStockInfoList.get(position).name);
		/*
		tv_turoverate.setText(mStockInfoList.get(position).turoverate);
		tv_price.setText(""+mStockInfoList.get(position).price);
		tv_change.setText(""+mStockInfoList.get(position).change);
		*/
		//TextView tv = (TextView)v.findViewById(R.id.tv_name);
		//tv.setText(mStockInfoList.get(position).name);
		/*
		if(position%2==0){
			tv.setBackgroundColor(0x6fcccc66);
		}else{
			tv.setBackgroundColor(0x8f99cc00);
		}*/
		//0xffe33125;	//红
		//0xff7dc573	//蓝
		if(mStockInfoList.get(position).price>mStockInfoList.get(position).open){
			holder.tv_turoverate.setText("+"+mStockInfoList.get(position).turoverate);
			holder.tv_price.setText(""+mStockInfoList.get(position).price);
			holder.tv_change.setText("+"+mStockInfoList.get(position).change);
			holder.fl.setBackgroundColor(0xffe33125);
		}else if(mStockInfoList.get(position).price==mStockInfoList.get(position).open){
			holder.tv_turoverate.setText(mStockInfoList.get(position).turoverate);
			holder.tv_price.setText(""+mStockInfoList.get(position).price);
			holder.tv_change.setText(""+mStockInfoList.get(position).change);
			holder.fl.setBackgroundColor(Color.BLACK);
		}else{
			holder.tv_turoverate.setText(""+mStockInfoList.get(position).turoverate);
			holder.tv_price.setText(""+mStockInfoList.get(position).price);
			holder.tv_change.setText(""+mStockInfoList.get(position).change);
			holder.fl.setBackgroundColor(0xff7dc573);
		}
		//
		if(mStockInfoList.get(position).moreInfo){
		//	System.out.println(mStockInfoList.get(position).moreInfo);
			holder.tv.setText(mStockInfoList.get(position).id);
			holder.tv.setVisibility(View.VISIBLE);
		}else{
			holder.tv.setVisibility(View.GONE);
		}

		
		return convertView;
	}

	class Holder{
		public LinearLayout fl;
		public RelativeLayout rl;
		
		public TextView tv_code;
		public TextView tv_name;
		public TextView tv_turoverate;
		public TextView tv_price;
		public TextView tv_change;
		
		public TextView tv;
		public boolean click;
	}
}
