/**
 * 
 */
package prep.jing.study.thkinginjava.concurrency;

/**
 * @author Administrator
 *
 */
public class BasicThread {
	public static void main(String[] args) {
		Thread t = new Thread(new LiftOff());
		t.start();
		System.out.println("waiting for liftOff!");
	}
}
