package aug20;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class threadscall {
	public static void main(String[] args) {
	ExecutorService executor = Executors.newFixedThreadPool(2);
	
	Callable<String> task = () -> {
		System.out.println("task running "+ Thread.currentThread().getName());
		Thread.sleep(4000);
		return "DATA FROM SERVER";
	};
	
	Future<String> future = executor.submit(task);
	System.out.println("main thread is running ...");
	try {
	var result = future.get(2, TimeUnit.SECONDS);
	System.out.println("received : "+result);
	
	} catch(InterruptedException | ExecutionException | TimeoutException e) {
		System.err.println("taking too long ...");
		//e.printStackTrace();
	} finally {
		executor.close();
		System.out.println("Main thread CONTINUE to run...");
	}
	}
}
