import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class BlockingQueuePractice {
	
	static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
	
	

	
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1= new Thread(new Runnable() {
			
			@Override
			public void run() {
			try {
				producer();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		});
		
		
		Thread t2=new Thread(new Runnable() {
			
			@Override
			public void run() {
			try {
				consumer();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		});
		t1.start();
		t2.start();

		
	}
	
	
	public static void producer() throws InterruptedException {
		
		while(true) {
	
		Thread.sleep(2000);
		Random random = new Random();
		Integer produce  =	random.nextInt(100);
	    queue.put(produce);	
		System.out.println("Producer Produced :"+ produce);	
		}
		
	}
	
	
public static void consumer() throws InterruptedException {
		
		while(true) {
	
		Thread.sleep(2000);
	   Integer consume = queue.take();
		System.out.println("Consumer Consumed :" + consume);	
		}
		
	}
	
	
	

}
