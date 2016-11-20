/**
 * 
 */
package prep.jing.study.thkinginjava.concurrency;

/**
 * @author Administrator
 *
 */
public class SimplePriorities implements Runnable {
	private int countDown = 5;
	private volatile double d;
	private int priority;

	public SimplePriorities(int priority) {
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
	 * @return
	 */
	private String status() {
		return Thread.currentThread() + " " + countDown;
	}

}
