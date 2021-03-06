
package prep.jing.study.thkinginjava.concurrency;

import com.google.common.base.Preconditions;

/**
 * @author Administrator
 *
 */
class LiftOff implements Runnable {

	int countDown = 10; // Default
	private static int taskCount = 0;
	private final int id = taskCount++;

	LiftOff() {
	}

	public LiftOff(int countDown) {
		Preconditions.checkArgument(countDown > 0);
		this.countDown = countDown;
	}

	String status() {
		return "#" + id + "(" + (countDown > 0 ? countDown : "Lift Off!") + ")";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		while (countDown-- > 0) {
			System.out.println(status());
			Thread.yield();
		}
	}

}
