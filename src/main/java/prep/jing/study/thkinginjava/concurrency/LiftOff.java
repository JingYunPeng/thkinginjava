/**
 * 
 */
package prep.jing.study.thkinginjava.concurrency;

import com.google.common.base.Preconditions;

/**
 * @author Administrator
 *
 */
public class LiftOff implements Runnable {

	protected int countDown = 10; // Default
	private static int taskCount = 0;
	private final int id = taskCount++;

	public LiftOff() {
	}

	public LiftOff(int countDown) {
		Preconditions.checkArgument(countDown > 0);
		this.countDown = countDown;
	}

	public String status() {
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
