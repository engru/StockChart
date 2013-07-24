package com.example.graphics.layers.entity;

import java.util.ArrayList;
import java.util.List;

public class StockData extends Data {

	//日期
	//开盘、最高、最低、收盘
	//成交量、成交额、涨跌幅、换手率
	
	int date;
	double open,high,low,close;
	double vol,tur,change,turoverate;
	public float globalMaxValue = 0,globalMinValue = 0;
	
	List<Entity> le = new ArrayList<Entity>();
	GridEntity ge = new GridEntity();
	
	//List<MAEntity> mLMA = new ArrayList<MAEntity>();
	MAsEntity mMAs = new MAsEntity();
	
	//最大K线数，这个参数有个默认，和触控体验是关联的
	int maxSticksNum = 50;
	
	
	public StockData(String name) {
		super(name);
	}
	
	public void addEntityAll(List<Entity> le){
		//this.le.clear();
		this.le.addAll(le);
		//System.out.println("entitysize:"+this.le.size()+this.le.get(80).date);
		updateAllData(le);
		initTAI(le);
		StickNumDisplay = 164;//this.le.size();
		//更新显示
		updateDisplay(0, StickNumDisplay);
	}
	
	public void addEntity(Entity entity){
		le.add(entity);
		updateData(entity);
		StickNumDisplay = 164;//this.le.size();
		//更新显示
		updateDisplay(0, StickNumDisplay);
	}
	
	public List<Entity> getListEntity(){
		return le;
	}
	
	
	private void updateAllData(List<Entity> le){
		for(Entity entity:le){
			updateData(entity);
		}
	}
	
	private void updateData(Entity entity){
		//更新整盘极限值
		if(entity.high>globalMaxValue)
			globalMaxValue = (float)entity.high;
		if(minValue == 0)
			globalMinValue = (float)entity.low;
		if(entity.low<globalMinValue)
			globalMinValue = (float)entity.low;

	}

//----------------------------------------------------------------------------------------//
	private void initTAI(List<Entity> le){
		//主图指标，均线MA、EXPMA、SAR、BOLL、BBI
		initMAs(le);
		//技术指标，RSI、KDJ、MACD、W%R、DMI、BIAS、OBV、CCI、ROC
	}
	
	private void initMAs(List<Entity> le){
		/*//5日均线
		MAEntity.initMA(5, le);
		//10日均线
		MAEntity.initMA(10, le);
		//15日均线
		MAEntity.initMA(15, le);
		*/
		mMAs.updateMAs(this.le,le);
	}
	
	public MAsEntity getMAsEntity(){
		return mMAs;
	}
	
//------------------------------------------------------------------------------------------//
	
	/** 
	 * 显示系统关注的主要参数
	 */
	//考虑缩放问题
	//关注当前需要现实的K线数
	
	private int StickNumDisplay = 0;
	private int beginIndex = 0;
	private float maxValue = 0;
	private float minValue = 0;
	
	//---------- 显示数量，及起始数据 ------------//
	public void setStickNum(int StickNumDisplay){
		this.StickNumDisplay = StickNumDisplay;
	}
	
	public void setBeginIndex(int beginIndex){
		this.beginIndex = beginIndex;
	}
	
	public void setDisplayParams(int beginIndex, int StickNumDisplay){
		this.beginIndex = beginIndex;
		this.StickNumDisplay = StickNumDisplay;
	}
	
	public int getStickNum(){
		return StickNumDisplay;
	}

	public int getBeginIndex(){
		return beginIndex;
	}
	
	//---------- 显示边界，即最大值、最小值 --------//
	public void setMaxValue(float maxValue){
		this.maxValue = maxValue;
	}
	
	public void setMinValue(float minValue){
		this.minValue = minValue;
	}
	
	public float getMaxValue(){
		return maxValue;
	}
	
	public float getMinValue(){
		return minValue;
	}
	
	//----------- 外部调用操作，主要来自于触控事件 -------//
	
	public void updateDisplay(int beginIndex, int StickNumDislapy) {
		setDisplayParams(beginIndex, StickNumDislapy);
		updateDisplay();
	}
	
	private void updateDisplay(){
		maxValue = 0;
		minValue = 0;
		for(int i = beginIndex; i < beginIndex+StickNumDisplay ; i++){
			updateRange(le.get(i));
		}
		//System.out.println("updatedisplay:"+beginIndex+"|"+StickNumDisplay+"|"+maxValue+"|"+minValue);
	}
	
	private void updateRange(Entity entity){
		//更新局部显示的边界值
		if(entity != null){
			if(entity.high> getMaxValue()) 
				setMaxValue((float)entity.high);
			
			if(getMinValue() == 0 || entity.low<getMinValue()) 
				setMinValue((float)entity.low);
		}
	}
//-----------------------------------------------------------------------------------------------//


	
	//考虑触摸，触屏绘制的是基于收盘价
	
}
