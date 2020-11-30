package divisors;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;

public class ThreadedMaxDivisors implements Runnable {
	
	private long min;
	private long max;
	Entry<Long,Long> result;
	
	public ThreadedMaxDivisors(long min, long max) {
		this.min = min;
		this.max = max;
	}

	@Override
	public void run() {
//		long maxDivisors = 0;
//		long numFound = 0;
//		long numberTested = 0;
//		for (long num = this.min; num <= this.max; num++) {
//			int divisors = CountDivisors.countDivisors(num);
//			if (divisors >= maxDivisors) {
//				maxDivisors = divisors;
//				numFound = num;
//			}
//			numberTested++;
//            if (numberTested == 1000) {
//                System.out.print('.');
//                numberTested = 0;
//            }
//			
//		}
//		this.result = new AbstractMap.SimpleEntry<Long,Long>(numFound, maxDivisors);
	}
	

	public static void main(String[] args) {
		
		long min = 100_000;
		long max = 200_000;
		
		Set<Thread> threadSet = new HashSet<Thread>();
		Set<ThreadedMaxDivisors> divisorsSet = new HashSet<ThreadedMaxDivisors>();
		long startTime = System.currentTimeMillis();
		
		long interval = 1000;
		long n = (max-min)/interval;

		for(long i = 1; i < n; i++) {
			long tmp = i*interval;
			Runnable r = () ->{
				try {
					ThreadedMaxDivisors tmd = new ThreadedMaxDivisors(min+tmp-1000, min + tmp);
					tmd.result = CountDivisors.maxDivisors(tmd.min, tmd.max);
					divisorsSet.add(tmd);
					
				}catch(Exception e){
					e.printStackTrace();
				}
			};
			Thread t = new Thread(r);
			threadSet.add(t);
			t.start();
			
		}


		/* join() tells a thread to wait until it's complete before the rest of the code and proceed.
		 * if we do that for all the threads, then then we can get the results of the threads once
		 * all of them are done
		 */
		for (Thread t: threadSet) {
			try {
				t.join();
				System.out.print("Done");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// at this point, all threads have been completed, since we
		// called the "join()" method on all the threads we created,
		// which forces the code to wait until the thread is finished
		// before we continue
		long largeNum = 0;
		long MaxNumOfDivisors = 0;
		for (ThreadedMaxDivisors tmd : divisorsSet) {
			// presumably you've recorded the results of
			// each ThreadedMaxDivisors run. Pick
			// the largest number with the largest number of
			// divisors
			if(tmd.result.getValue() >= MaxNumOfDivisors) {
				if(tmd.result.getKey() > largeNum) {
					largeNum = tmd.result.getKey();
					MaxNumOfDivisors = tmd.result.getValue();
				}
			}
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("\n" + largeNum + ": " + MaxNumOfDivisors);
		System.out.println("Threaded elapsed time: " + (endTime - startTime));
		
		
		startTime = System.currentTimeMillis();
		Entry<Long,Long> e = CountDivisors.maxDivisors(min, max);
		
		long number = e.getKey();
		long numDivisors = e.getValue();
		
		System.out.println("\n" + number + ": " + numDivisors);
		endTime = System.currentTimeMillis();
		
		System.out.println("Non-threaded elapsed time: " + (endTime - startTime));
		
		
		
		
	}
}
