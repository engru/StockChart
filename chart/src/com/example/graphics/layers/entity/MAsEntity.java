package com.example.graphics.layers.entity;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;

import com.example.graphics.wight.entity.LineEntity;

public class MAsEntity {
	List<MAEntity> lines = new ArrayList<MAEntity>();
	
	public MAsEntity(){
		
	}
	
	public MAsEntity(List<Entity> ohlc){
		super();
		//5日线
		preinitMA("MA5", 5, ohlc, Color.WHITE);
		//10日线
		preinitMA("MA10", 10, ohlc, Color.RED);
		//15日线
		preinitMA("MA15", 15, ohlc, Color.GREEN);
	}
	
	public List<MAEntity> getListMAEntity(){
		return lines;
	}
	
	
	public void updateMAs(List<Entity> ohlc){		//全局刷新
		
		//5日线
		preinitMA("MA5", 5, ohlc, Color.BLACK);
		//10日线
		preinitMA("MA10", 10, ohlc, 0xffff00ff);//Color.RED);
		//15日线
		preinitMA("MA15", 15, ohlc, 0xff2ca7b4);//Color.GREEN);
		for(int i=0;i<lines.size();i++){
			//System.out.println(lines.get(i).getTitle()+":"+lines.get(i).getLineData().size());
		}
	}
	
	public void updateMAs(List<Entity> ohlcs,List<Entity> ohlc){		//全局刷新
		les = ohlcs;
		//5日线
		preinitMA("MA5", 5, ohlc, Color.BLACK);
		//10日线
		preinitMA("MA10", 10, ohlc, 0xffff00ff);//Color.RED);
		//15日线
		preinitMA("MA15", 15, ohlc, 0xff2ca7b4);//Color.GREEN);
		for(int i=0;i<lines.size();i++){
			//System.out.println(lines.get(i).getTitle()+":"+lines.get(i).getLineData().size());
		}
	}
	
	public void updateMAs(Entity entity){			//个体增量刷新
		
	}
	
	private void preinitMA(String title,int days,List<Entity> ohlc,int color){
	      //计算25日均线
		/*
		//if(lines.size()==0)
			for(MAEntity entity:lines){
				System.out.println("xxxxxxxx");
				if(entity.getTitle().equals(title)){
					entity.getLineData().addAll(initMA(days,ohlc));
				}else{
					MAEntity ma = new MAEntity();
					ma.setTitle(title);
					ma.setLineColor(color);
					ma.setLineData(initMA(days,ohlc));
					lines.add(ma);
				}
			}
			*////////////////
/*
			if(lines.size()==0){
				MAEntity ma = new MAEntity();
				ma.setTitle(title);
				ma.setLineColor(color);
				ma.setLineData(initMA(days,ohlc));
				lines.add(ma);
			}
*/
			boolean check = false;
			for(int i=0;i<lines.size();i++){
				if(lines.get(i).getTitle().equals(title)){
					lines.get(i).getLineData().addAll(initMA(title,days,ohlc,true));
					check = true;
				}
			}
			if(!check){
				MAEntity ma = new MAEntity();
				ma.setTitle(title);
				ma.setLineColor(color);
				ma.setLineData(initMA(title,days,ohlc,false));
				lines.add(ma);
			}
	}
	
	List<Entity> les = new ArrayList<Entity>();
	
	public List<Float> initMA(String title,int days,List<Entity> ohlc,boolean add){
		
		if (days < 2){
			return null;
		}
		
        List<Float> MA5Values = new ArrayList<Float>();
        
    	float sum = 0;
    	float avg = 0;
        for(int i = 0 ; i < ohlc.size(); i++){
        	float close =(float)ohlc.get(i).close;
        	if(i< days){
        		if(add){	//如果是扩展
        			for(int j=0;j<lines.size();j++){					// 均线匹配
        				if(lines.get(j).getTitle().equals(title)){		// 均线匹配
        					sum = 0;
        					int size = les.size();
                			for(int k=0;k<days-1-i;k++){
                				sum = sum + (float)les.get(size+1-days+k + i).close;
                			}
                			
                			for(int k=0;k<=i;k++){
                				sum = sum + (float)ohlc.get(k).close;
                			}
        				}
        			}
        			//sum = sum + close - (float)
        			avg = sum / days;
        		}else{		//如果只是初始数据
	        		sum = sum + close;
	        		avg = sum / (i + 1f);
        		}
        	}else{
        		sum = sum + close - (float)ohlc.get(i-days).close;
        		avg = sum / days;
        	}
        	MA5Values.add(avg);
        }
        
        return MA5Values;
	}
	
	
	
	public static float addMA(int i, int days, Entity ohlc,List<Entity> ohlcs){
		//当前 days 项
		if(days<2){
			return 0;
		}
		
		float sum = 0;
		float avg = 0;
		if(i< days){
			sum =  sum + (float)ohlc.close;
			avg = sum / (i + 1f);
		}else{
			sum = sum + (float)ohlc.close - (float)ohlcs.get(i-days).close;
			avg = sum / days;
		}
		return avg;
	}
	
	
	
	

	public class MAEntity{
		private List<Float> lineData;
	
		private String title;
	
		private int lineColor;
	
		private boolean display = true;
		
	
		public MAEntity() {
			super();
		}
	
		public MAEntity(List<Float> lineData, String title, int lineColor) {
			super();
			this.lineData = lineData;
			this.title = title;
			this.lineColor = lineColor;
		}
		
		/**
		 * @param value 
		 */
		public void put(float value){
			if (null == lineData){
				lineData = new ArrayList<Float>();
			}
			lineData.add(value);
		}
	
		/**
		 * @return the lineData
		 */
		public List<Float> getLineData() {
			return lineData;
		}
	
		/**
		 * @param lineData the lineData to set
		 */
		public void setLineData(List<Float> lineData) {
			this.lineData = lineData;
		}
	
		/**
		 * @return the title
		 */
		public String getTitle() {
			return title;
		}
	
		/**
		 * @param title the title to set
		 */
		public void setTitle(String title) {
			this.title = title;
		}
	
		/**
		 * @return the lineColor
		 */
		public int getLineColor() {
			return lineColor;
		}
	
		/**
		 * @param lineColor the lineColor to set
		 */
		public void setLineColor(int lineColor) {
			this.lineColor = lineColor;
		}
	
		/**
		 * @return the display
		 */
		public boolean isDisplay() {
			return display;
		}
	
		/**
		 * @param display the display to set
		 */
		public void setDisplay(boolean display) {
			this.display = display;
		}
		
	}
}
