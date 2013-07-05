package com.example.graphics.coverage.entity;

public class ExtendData extends Data{
	int lenght = 0;
	
	public ExtendData(String name){
		super(name);
	}
	
	public void setLenght(int lenght){
		this.lenght = lenght;
	}
	
	public int getLenght(){
		return lenght;
	}
}
