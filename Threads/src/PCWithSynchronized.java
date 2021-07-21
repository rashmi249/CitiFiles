import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class PCWithSynchronized {
	
	LinkedList<Integer> list = new LinkedList<Integer>();
     int capacity=2;
	
	public void producer() throws InterruptedException {
		//Random random = new Random();
		int value=0;
		while(true) {
			synchronized (this) {
				
				while(list.size()==capacity) {	
					wait();
				//	int produce = random.nextInt();
					System.out.println("producer Produced :"+ value);
					list.add(value++);
				
				     
				 	notify();
				 	Thread.sleep(3000);
				     
				}
			}
		}
}
	
	public void consumer() throws InterruptedException{
	
		while(true) {
			synchronized (this) {
				while(list.size()==0) {
					wait();
					int value= list.removeFirst();
					System.out.println("Consumer consumed :"+value);
					notify();
				     Thread.sleep(3000);
				}
			}
		}
		
	}
}
