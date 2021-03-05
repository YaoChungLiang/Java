package com.antra;

public class Circle extends Shape {
	private float radius, area;
	
	Circle(float rad){
		this.radius = rad;
	}
	
	@Override
	public float getArea() {
		// TODO Auto-generated method stub
		this.area = (float) Math.PI * radius * radius;
		return area;
	}
}
