import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolProblems {

	public static void main(String[] args) {
		//create a thread pool
		ExecutorService service= Executors.newSingleThreadExecutor();
		
		// submit a task for execution
		for(int i=0;i<10;i++) {
			service.execute(new Task());
		}
		System.out.println("Thread Name: "+ Thread.currentThread().getName());
        
	}

}


class Task implements Runnable{

	@Override
	public void run() {
		
		System.out.println("Thread name :"+Thread.currentThread().getName());
	}
	
}
