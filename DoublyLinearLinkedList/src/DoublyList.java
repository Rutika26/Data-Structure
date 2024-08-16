
public class DoublyList {
	public static class Node {
		private int data;
		private Node next;
		private Node prev;

		public Node() {
			data = 0;
			next = null;
			prev = null;
		}

		public Node(int val) {
			data = val;
			next = null;
			prev = null;
		}
	}

	private Node head;

	public DoublyList() {
		head = null;
	}

	public void displayForward() {
		System.out.println("Forward display ");
		System.out.println("List : ");
		Node trav = head;
		while (trav != null) {
			System.out.print(" -> " + trav.data);
			trav = trav.next;
		}
		System.out.println("");

	}

	public void displayReverse() {
		System.out.println("Reverse display ");
		System.out.println("List : ");
		if (head == null)
			return;
		Node trav = head;
		while (trav.next != null)
			trav = trav.next;
		while (trav != null) {
			System.out.print(" -> " + trav.data);
			trav = trav.prev;
		}
	}

	public void addFirst(int val) {
		Node newNode = new Node(val);
		if (head == null)
			head = newNode;
		else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}

	}

	public void addLast(int val) {
		Node newNode = new Node(val);
		if (head == null)
			head = newNode;
		else {
			Node trav = head;
			while (trav.next != null)
				trav = trav.next;
			trav.next = newNode;
			newNode.prev = trav;
		}
	}

	public void addAtPos(int val, int pos) {
		Node trav = head, temp;
		Node newNode = new Node(val);
		if (head == null || pos <= 1)
			addFirst(val);
		else {
			for (int i = 1; i < pos-1; i++) {
				if (trav.next == null)
					break;
				trav = trav.next;
			}

			temp = trav.next;
			newNode.next = temp;
			newNode.prev = trav;
			trav.next = newNode;
			if (temp != null)//if add node at last position
				temp.prev = newNode;
		}

	}

	public void delFirst() {
		if(head==null)
			throw new RuntimeException("List is empty");
		if(head.next==null)
			head=null;
		head=head.next;
		head.prev=null;

	}

	public void delAtPos(int pos) {
		Node trav=head;
		if(head==null)
			throw new RuntimeException("List is empty");
		if(head.next==null)
			head=null;
		if( pos==1)
			delFirst();
		for(int i=1;i<pos;i++) {
			if(trav.next== null)
				break;
			trav=trav.next;
		}
		trav.prev.next=trav.next;
		trav.next.prev=trav.prev;
		trav=null;

	}

	public void delLast() {
		Node trav = head,temp=null;
		if(head==null)
			throw new RuntimeException("List is empty");
		if(head.next==null)
			head=null;
		while(trav.next!=null) {
			temp=trav;
			trav=trav.next;
		}
		temp.next=null;
		trav=null;
		
			
		
	}
}
