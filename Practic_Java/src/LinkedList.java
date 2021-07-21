
public class LinkedList {
 Node head;
	
	
	
	 static class Node{
		 int data;
		 Node next;
		 
		 Node(int d){
			 data =d;
			 next=null;
		 }
	 }
	 
	 
	 public static LinkedList  add(LinkedList list,int data) {
		//create node
		 Node new_node=new Node(data);
		 new_node.next=null;
		 
		 //Traverse node
		 if(list.head==null) {
			list.head=new_node; 
		 }else {
			 Node last= list.head;
			 while(last.next!=null) {
				last= last.next;
			 }
			 
			 //insert the new node
			 last.next=new_node;
			 
		 }
		return list;
				 
	 }
	 
	 public static void display(LinkedList list) {
		 Node currentNode=list.head;
		 System.out.println("LinkedList: ");
		 while(currentNode!=null) {
			 System.out.println(currentNode.data);
			 currentNode=currentNode.next;
		 }
		 
		 
	 }
	public static void main(String[] args) {
  LinkedList list = new LinkedList();
  
list=  add(list, 2);
list=  add(list, 5);
list=  add(list, 9);
list=  add(list, 3);
list=  add(list, 33);
list=  add(list, 18);

display(list);
	}

}
