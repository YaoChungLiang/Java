package com.antra;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class assignment4 {
	public static void main(String[] args) {
		String inFile = System.getProperty("user.dir") + "/src/com/antra/input.txt";
		String outFile = System.getProperty("user.dir") + "/src/com/antra/output.txt";
		BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(1024);
		
		ThreadRead tr = new ThreadRead(inFile, blockingQueue );
		ThreadWrite tw = new ThreadWrite(outFile, blockingQueue);
		
		new Thread(tr).start();
		new Thread(tw).start();
		
	} 
}
