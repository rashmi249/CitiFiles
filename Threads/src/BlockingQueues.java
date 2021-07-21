import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueues {

	static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
			
				try {
					produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	
	
	Thread t2 = new Thread(new Runnable() {
		
		@Override
		public void run() {
		
			try {
				consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	});
	
	t1.start();
	t2.start();

	}
	
 public static void produce() throws InterruptedException {
	 
	 while(true) {
		 Random random = new Random();
		
		 
		int val= random.nextInt(100);
		System.out.println(val +"Added");
		queue.add(val);
		 Thread.sleep(2000);
		 
	 }
	 
		 
	 }
 
 public static void consume() throws InterruptedException {
	 
	 while(true) {
		
		 Thread.sleep(2000);
		 
		int val= queue.remove();
		System.out.println(val +"Removed");
		
		 
	 }
	 
		 
	 }
	

}
