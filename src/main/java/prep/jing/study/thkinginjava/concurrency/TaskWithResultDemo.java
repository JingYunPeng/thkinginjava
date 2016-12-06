
package prep.jing.study.thkinginjava.concurrency;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.google.common.collect.Lists;

/**
 * @author Administrator
 *
 */
class TaskWithResult implements Callable<String> {
	private final int id;

	/**
	 * 
	 */
	TaskWithResult(int id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.concurrent.Callable#call()
	 */
	public String call() throws Exception {
		return "the result of task is " + id;
	}
}

public class TaskWithResultDemo {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		List<Future<String>> result = Lists.newArrayList();
		for (int i = 0; i < 5; i++) {
			result.add(exec.submit(new TaskWithResult(i)));
		}

		for (Future<String> future : result)
			try {
				System.out.println(future.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				exec.shutdown();
			}
	}
}