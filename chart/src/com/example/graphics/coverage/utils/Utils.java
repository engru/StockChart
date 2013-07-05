package com.example.graphics.coverage.utils;

public class Utils {

	public static float getCoordinate(double current, float maxValue, float minValue, int width){
		return  (float)( (maxValue-current) / (maxValue-minValue) ) * width ;
		
	}
}
