import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FixedThreadExecutor {

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
	ExecutorService ex = Executors.newFixedThreadPool(7);
	
	for(int i=0;i<20;i++) {
		
	Future<String> future = ex.submit(new Task1());
	String nn= future.get();
	System.out.println(nn);
	}

	}

}

class Task1 implements Callable<String>{
 //  int value=0;
	@Override
	public String call() throws Exception {
		
			return "Hi";
	}

	/*
	 * @Override public void run() { System.out.println("Thread Name : " +
	 * Thread.currentThread().getName());
	 * 
	 * }
	 */
	
	
}