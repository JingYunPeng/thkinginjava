package prep.jing.study.thkinginjava.concurrency;

import java.util.concurrent.TimeUnit;

/**simple daemons
 * Created by Administrator on 2016/12/4.
 */
public class SimpleDeamons implements Runnable {
    public void run() {
        try {
            //noinspection InfiniteLoopStatement
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            System.out.println("sleep() interrupted");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDeamons());
            daemon.setDaemon(true);
            daemon.start();
        }
        System.out.println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(250);
    }
}
