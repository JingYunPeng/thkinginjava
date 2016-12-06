
package prep.jing.study.thkinginjava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Administrator
 *
 */
public class SimplePriorities implements Runnable {
	private int countDown = 5;
	private volatile double d;
	private final int priority;

	private SimplePriorities(int priority) {
		this.priority = priority;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		Thread.currentThread().setPriority(priority);
		while (true) {
			System.out.println(status());
			for (int i = 0; i < 100000; i++) {
				d += (Math.PI + Math.E) / i;
			}
			if (countDown-- == 0) {
				return;
			}
		}
	}

	/**
	 * @return the status
	 */
	private String status() {
		return Thread.currentThread() + " " + countDown;
	}

	public static void main(String[] args){
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i <5 ; i++) {
			exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));
		}
		exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));
 		exec.shutdown();
	}
}
