package com.antra;

public abstract class Shape implements Comparable<Shape>{
	public float area;
	public abstract float getArea();
	
	@Override
	public int compareTo(Shape obj) {
		return Float.compare(getArea(), obj.getArea());
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " with area: " + getArea();
	}
}
