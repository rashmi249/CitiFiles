
public class LinkedList {
	 Node head;
	
	static class Node {
		int data;
		Node next;
		
		public Node(int data) {
			data=this.data;
		}

	}

	
	public static LinkedList insert(LinkedList list, int data) {
		Node new_node= new Node(data);
		new_node.next=null;
		
		if(list.head==null) {
			list.head=new_node;
		}else {
			Node last =list.head;
			while(last.next!=null) {
				last=last.next;
			}
			last.next = new_node;
		}
		
		
		return list;
		
	}
	
public static void printList(LinkedList list) {
	Node currNode= list.head;
	while(currNode.next!=null) {
		System.out.println(currNode.data);
		currNode =currNode.next;
	}
}

	public static void main(String[] args) {
		LinkedList list =new LinkedList();
		
		insert(list, 1);

	}

}
