package com.antra;
import java.util.*;

public class assignment3 {
	public static void main(String[] args) {
		
		// Q - 15
		System.out.println(" Assignment 3 - Q 15");
		List<Integer> aList = new ArrayList<>(List.of(1,2,3,4,10));
		Map<String, String> bMap = new HashMap<>();
		bMap.put("a", "1");
		bMap.put("b", "2");
		bMap.put("c", "10");
		System.out.println("A list cnotains all the element in A list but not in B map : "  + Q15(aList,bMap).toString());
		System.out.println();
		
		// Q - 16
		System.out.println(" Assignment 3 - Q 16");
		Shape circle = new Circle(3);
		Shape square = new Square(4);
		Shape rectangle = new Rectangle(4,5);
		List<Shape> shapeList = new ArrayList<>();
		shapeList.add(circle);
		shapeList.add(square);
		shapeList.add(rectangle);
		System.out.println(shapeList.toString());
		Collections.sort(shapeList);
		System.out.println("After sorting");
		System.out.println(shapeList.toString());
		
		
	}
	
	public static List<Integer> Q15(List<Integer> A, Map<String, String> B ){
		List<Integer> res = new ArrayList<Integer>();
		HashSet<Integer> bValueSet = new HashSet<Integer>();
		for(String val : B.values()) {
			bValueSet.add(Integer.parseInt(val));
		}
		for(Integer i:A) {
			if(!bValueSet.contains(i)) {
				res.add(i);
			}
		}
		return res;
	}
	
	
}


