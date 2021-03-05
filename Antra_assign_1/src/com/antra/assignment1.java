package com.antra;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Integer;

public class assignment1 {
	public static void main(String[] args) {
		// Q - 13
		playKeyBoard();
		
		// Q - 14
		int [] mergeArr = mergeArrays(new int[] {1,2,3},new int[] {4,5,6});  // result = [1,2,3,4,5,6]
		System.out.println(Arrays.toString(mergeArr));

		// Q-15
		int secondLarge = secondLargest(new int[] {2,3,4,5,6,7}); // result = 6
		System.out.println(secondLarge);
		
	}
	
	public static void playKeyBoard() {
		Scanner sc = new Scanner(System.in);
		int a;
		String input = "";
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter("x.txt", true);
			 bw = new BufferedWriter(fw);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		while(!input.equals("q")) {
			System.out.println("type an integer (q for exit):");
			input = sc.next();
			try {
				a = Integer.parseInt(input);
			}catch(Exception e){
				if(!input.equals("q")) {
					System.out.println("Invalid input");
					continue;
				}else {
					break;
				}
			}
			if(a <= 0) {
				System.out.println("Invalid input");
			}else {
				assignment1.doMoreStuff(a, bw);
			}
		}
		
		try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void doMoreStuff(int x, BufferedWriter bw){
		int y = (x*(x+1))/2;
		System.out.println(System.currentTimeMillis());
		try{
			bw.write(String.valueOf(y));
			bw.newLine();
		} catch (IOException e) {
			    e.printStackTrace();
		}
	}
	
	public static int[] mergeArrays(int[] arr1, int[] arr2) {
		int[]  mergeArr = new int[arr1.length + arr2.length];
		System.arraycopy(arr1, 0, mergeArr, 0, arr1.length);
		System.arraycopy(arr2, 0, mergeArr, arr1.length, arr2.length);
		return mergeArr;
	}
	
	public static int secondLargest(int[] arr){
	  	int k = 2;
	    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
	    for(Integer i : arr){
	      pq.add(i);
	    }
	    while(k > 1 && pq.size() > 1){
	      pq.poll();
	      k--;
	    }
	    return pq.peek();
	}
}
