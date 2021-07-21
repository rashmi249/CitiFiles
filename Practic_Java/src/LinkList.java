
public class LinkList {
 Node head;
	
	public static class Node{
		
		int data;
		Node next;
		
		public Node(int d){
			data=d;
			next=null;
		}
	}
	
	public static LinkList add(LinkList list, int data) {
		
		//create
		Node new_node= new Node(data);
		new_node.next=null;
		
		//traverse
		if(list.head==null) {
			list.head=new_node;
		}else {
			Node last= list.head;
			while(last.next!=null) {
			last=last.next;
			}
			
	   //add
			last.next=new_node;
			
		}
		
		return list;
		
		
	}
	
	public static void display(LinkList list) {
		Node cNode = list.head;
		
		while(cNode!=null) {
			System.out.println(cNode.data);
			cNode=cNode.next;
		}
	}


	public static void main(String[] args) {
		LinkList list =new LinkList();
		list = add(list, 1);
		list = add(list, 2);
		list = add(list, 3);
		list = add(list, 7);		
		list = add(list, 5);
		list = add(list, 9);

		display(list);
		

	}

}
