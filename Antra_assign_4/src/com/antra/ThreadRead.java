package com.antra;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;


public class ThreadRead implements Runnable {

	private String inFile = null;
	protected BlockingQueue<String> blockingQueue = null;
	
	ThreadRead(String inFile, BlockingQueue<String> blockingQueue){
		this.inFile = inFile;
		this.blockingQueue = blockingQueue;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
    	BufferedReader br = null;
		File file = new File(this.inFile);
		
    	try {
			br = new BufferedReader(new FileReader(file));
			String buffer = null;
			while((buffer=br.readLine()) != null) {
				System.out.println(buffer);
				blockingQueue.put(calculate(buffer));
				blockingQueue.put("\n");
			}
			blockingQueue.put("EOF");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String calculate(String s) {
		if(s.equals("")) return "";
		int res = 0;
		int sign = 1;
		int pre = 0;
		int i = 0;
		while(i < s.length()) {
			if(s.charAt(i) == ' ') {
				i++;
				continue;
			}
			else if(s.charAt(i)== '+' || s.charAt(i) == '-') {
				res += pre * sign;
				sign = s.charAt(i) == '+' ? 1 : -1;
				pre = 0;
				i++;
			}else if( Math.abs((s.charAt(i) - '0')) < 10) {
				pre = pre * 10 + (s.charAt(i) - '0');
				i++;
			}else {
				throw new IllegalArgumentException("Not a valid character to operate!");
			}
			
		}
		res += pre * sign;
		System.out.println(s);
		System.out.println(res);
		
		return String.valueOf(res);
	}


}
