import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadExecutor {

	public static void main(String[] args) {
		
ExecutorService service = Executors.newCachedThreadPool();

for(int i=0;i<15;i++) {
	service.execute(new Task());
}
	}

}

class Task2 implements Runnable{

	@Override
	public void run() {
		System.out.println("Thread Name :"+ Thread.currentThread().getName());
		
	}
	
	
	
}
