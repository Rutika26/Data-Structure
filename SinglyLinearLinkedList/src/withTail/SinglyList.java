package withTail;

public class SinglyList {
	static class Node {
		// node class fields
		private int data;
		private Node next;

		public Node() {
			data = 0;
			next = null;
		}

		public Node(int val) {
			data = val;
			next = null;
		}
	}

//list class fields
	private Node head;
	private Node tail;

//List class methods
	public SinglyList() {
		head = null;
		tail = null;
	}

	public void display() {
		Node trav;
		if (head == null)
			System.out.println("List is empty");
		else {
			trav = head;
			System.out.println("List ");
			while (trav != null) {
				System.out.print(" -> " + trav.data);
				trav = trav.next;
			}

		}

	}

	// add node at first
	public void addFirst(int val) {
		Node newNode = new Node(val);
		if (head == null) {// if list is empty then add newNode as first node
			head = newNode;
			tail = newNode;
		}
			
		else { // add newNode at first
			newNode.next = head;
			head = newNode;
			
		}
	}

	// add node at last
	public void addLast(int val) {
		Node newNode = new Node(val);
		if (head == null) {// if list is empty then add newNode as first node
			head = newNode;
			tail = newNode;
		}
		else { // add newNode at last
		tail.next=newNode;
		tail=newNode;
		}
	}

	// add node at given position
	public void addAtPos(int val, int pos) {
		if (head == null || pos <= 1)// if list is empty then add newNode as first node
			addFirst(val);
		else {
			Node newNode = new Node(val);
			Node trav = head;
			for (int i = 1; i < pos - 1; i++) {
				if (trav.next == null)
					break;
				trav = trav.next;
			}
			// 1. newNode's next should point to trav's next
			newNode.next = trav.next;
			// 2. trav's next should point to newNode
			trav.next = newNode;
		}
	}

	public void delFirst() {
		if (head == null)
			throw new RuntimeException("List is empty");
		Node temp = head;
		head = head.next;
		temp = null;
	}

	public void delLast() {
		if (head == null)
			throw new RuntimeException("List is empty");
		else {
//			Node trav = head, prev = null;
//			while (trav.next != null) {
//				prev = trav;
//				trav = trav.next;
//			}
//			prev.next = null;
//			trav = null;
			Node secondLast = head;
			while(secondLast.next.next!=null) {
				secondLast = secondLast.next;
			}
			secondLast.next=null;
			tail=secondLast;
		}
	}

	public void delAll() {
		head = null;
	}

	public void delAtPos(int pos) {
		Node prev = null, trav = head;
		if (head == null)
			throw new RuntimeException("List is empty");
		if (pos == 1)
			delFirst();
		else {
			for (int i = 1; i < pos; i++) {
				prev = trav;
				trav = trav.next;

			}
			prev.next = trav.next;
			trav = null;
		}

	}

}
