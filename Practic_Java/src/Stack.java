
public class Stack {
  int MAX=1000;
	int arr[] = new int[MAX];
	int top;
	
	Stack() {
		top=-1;
	}
	
	public boolean push(int data) {
		
		if(top>=(MAX-1)) {
			System.out.println("Stack Overflow");
			return false;
		}else {
			arr[++top]=data;
			System.out.println(data +"Pushed to Stack");
			return true;
		}
	}
	
public void pop() {
		if(top<0) {
			System.out.println("Stack UnderFlow");
		}else {
			int data=arr[top--];
			System.out.println(data +"is removed");
		}
	}
	
	public void peek() {
		if(top<=0) {
			System.out.println("Stack UnderFlow");
		}else {
			int data=arr[top];
			System.out.println(data +"is poped");
		}
	}
	
	
	
	public static void main(String[] args) {
		Stack stack=new Stack();
		stack.push(12);
		stack.push(13);
		stack.push(33);
		stack.pop();
		stack.peek();
		stack.pop();
		stack.pop();
   
	}

}
