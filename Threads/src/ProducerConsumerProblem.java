import java.util.LinkedList;

public class ProducerConsumerProblem {

	public static void main(String[] args) throws InterruptedException {
	
	final	ProdConsum pc=new ProdConsum();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
			try {
				pc.producer();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			}
		});
		
		Thread t2= new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					pc.consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();

	}
	
	
public static class ProdConsum{
	LinkedList<Integer> list = new LinkedList<Integer>();
	int capacity=2;
	
	public void producer() throws InterruptedException {
		int value=0;
		while(true) {
			synchronized (this) {
				while(list.size()==capacity) {
					wait();
				}
				list.add(value++);
				System.out.println("Producer Produced :" + value);
			}
		}
		
	}
	
	public void consumer() throws InterruptedException {
		while(true) {
			
			synchronized (this) {
				
			while(list.size()==0)
				wait();
		
			int value = list.removeFirst();
			System.out.println("Consumer Consumed :" + value);
			notify();
			Thread.sleep(1000);
			}
			
		}
	}
	
}
	
	
	

}
