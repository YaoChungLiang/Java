package com.antra;


public class Square extends Shape{
	private float width, area;
	
	Square(float width){
		this.width = width;
	}
	
	@Override
	public float getArea() {
		// TODO Auto-generated method stub
		area = width * width;
		return area;
	}
}
