package withoutTail;

public class SinglyCircularList {
	// Node class
	static class Node {
		// Node class fields
		private int data;
		private Node next;

		// Node class methods
		public Node() {
			data = 0;
			next = null;
		}

		public Node(int val) {
			data = val;
			next = null;
		}
	}

	// List class fields
	private Node head;

	// List class methods
	public SinglyCircularList() {
		head = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void display() {
		System.out.println("List ");
		if (isEmpty())
			return;
		Node trav = head;
		do {
			System.out.print(" -> " + trav.data);
			trav = trav.next;
		} while (trav != head);

	}

	public void addFirst(int val) {
		Node newNode = new Node(val);
		if (head == null) {
			head = newNode;
			newNode.next = head;
		}
		Node trav = head;
		while (trav.next != head)
			trav = trav.next;
		trav.next = newNode;
		newNode.next = head;
		head = newNode;

	}

	public void addLast(int val) {
		Node newNode = new Node(val);
		if (head == null) {
			head = newNode;
			newNode.next = head;
		}
		Node trav = head;
		while (trav.next != head)
			trav = trav.next;
		trav.next = newNode;
		newNode.next = head;

	}

	public void addAtPos(int val, int pos) {
		Node newNode = new Node(val);
		Node trav = head;
		if (head == null) {
			head = newNode;
			newNode.next = head;
		}
		if (pos == 1)
			addFirst(val);

		for (int i = 1; i < pos - 1; i++) {
			trav = trav.next;
		}
		newNode.next = trav.next;
		trav.next = newNode;
	}

	public void delFirst() {

		if (head == null)
			throw new RuntimeException("List is Empty");
		if (head.next == head)
			head = null;
		else {
			Node trav = head;
			while (trav.next != head)
				trav = trav.next;

			head = head.next;
			trav.next = head;
		}
	}

	public void delLast() {
		if (head == null)
			throw new RuntimeException("List is Empty");
		if(head.next==head) //if there is only one node in LL
			head=null;
		Node trav = head, prev = null;
		while (trav.next != head) {
			prev = trav;
			trav = trav.next;
		}
		prev.next = head;
		trav = null;

	}

	public void delAtPos(int pos) {
		Node trav = head, prev = null;
		if (pos == 1)
			delFirst();
		if (head == null || pos < 1)
			throw new RuntimeException("List is empty");
		else {
			for (int i = 1; i < pos; i++) {
				if (trav.next == head)
					throw new RuntimeException("Invalid Position");
				prev = trav;
				trav = trav.next;
			}
			prev.next = trav.next;
			trav = null;

		}

	}

	public void delAll() {
		head.next = null;
		head = null;
	}

}
