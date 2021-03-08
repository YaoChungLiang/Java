package com.antra;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

public class ThreadWrite implements Runnable {
	private String outFile = null;
	protected BlockingQueue<String> blockingQueue = null;
	
	ThreadWrite(String outFile, BlockingQueue<String> blockingQueue){
		this.outFile = outFile;
		this.blockingQueue = blockingQueue;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		BufferedWriter bw = null;
		File file = new File(this.outFile);
		
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			bw = new BufferedWriter(new FileWriter(file));
			while(true) {
				String buffer = blockingQueue.take();
				if(buffer.equals("EOF")) {
					break;
				}
				bw.write(buffer);
			}
			
		}catch(IOException ioe) {
			ioe.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				bw.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	

}
