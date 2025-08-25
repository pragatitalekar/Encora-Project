package aug20;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class completeThread {

	public static void main(String[] args) {
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			System.out.println("step 1 : fetching "+ Thread.currentThread().getName());
			try {
				TimeUnit.SECONDS.sleep(3);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "raw data";
			});
		
		CompletableFuture<String> processingFuture = future.thenApply((rawdata) -> {
			System.out.println("step 1 : processing data receiving from thread one -- "+Thread.currentThread().getName());
			//var processdata = rawdata.toUpperCase();
			try {
				TimeUnit.SECONDS.sleep(3);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return rawdata;
		});
		
		processingFuture.thenAccept((finalResult) -> {
			System.out.println("final result : "+finalResult);
		});
		
		processingFuture.join();
	}

}
