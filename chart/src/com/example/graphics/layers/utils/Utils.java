package com.example.graphics.layers.utils;

public class Utils {

	public static float getCoordinate(double current, float maxValue, float minValue, int width){
		return  (float)( (maxValue-current) / (maxValue-minValue) ) * width ;
		
	}
}
