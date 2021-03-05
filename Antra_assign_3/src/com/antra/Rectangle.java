package com.antra;

public class Rectangle extends Shape {
	private float width, height,area;
	
	Rectangle(float width, float height ){
		this.width = width;
		this.height = height;
	}
	
	@Override
	public float getArea() {
		// TODO Auto-generated method stub
		area = width * height;
		return area;
	}
}
