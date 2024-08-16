package doublyCircularLL;

public class DoublyCircularLinkedList {
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

	public DoublyCircularLinkedList() {
		head = null;
	}

	public void displayForward() {
		if (head == null)
			System.out.println("List is empty");
		else {
			Node trav = head;
			System.out.println("Forward traverse :");
			System.out.println("List : ");
			do {
				System.out.print(" -> " + trav.data);
				trav = trav.next;
			} while (trav != head);
		}
		System.out.println("");
	}

	public void displayBackward() {
		if (head == null)
			System.out.println("List is empty");
		else {
			Node trav = head.prev;
			System.out.println("Backward traverse :");
			System.out.println("List : ");
			do {
				System.out.print(" -> " + trav.data);
				trav = trav.prev;
			} while (trav != head.prev);
		}
	}

	public void addFirst(int val) {
		Node newNode = new Node(val);
		if (head == null) {
			head = newNode;
			newNode.prev = head;
			newNode.next = head;
		} else {
			newNode.prev = head.prev;
			newNode.next = head;
			head.prev.next = newNode;
			head.prev = newNode;
			head = newNode;
		}

	}

	public void addLast(int val) {
		Node newNode = new Node(val);
		if (head == null) {
			head = newNode;
			newNode.prev = head;
			newNode.next = head;
		} else {
			Node trav = head;
			while (trav.next != head) {
				trav = trav.next;
			}

			trav.next = newNode;
			newNode.prev = trav;
			newNode.next = head;
			head.prev = newNode;
		}

	}

	public void addAtPos(int val, int pos) {
		Node newNode = new Node(val);
		Node trav = head;
		if (head == null) {
			head = newNode;
			newNode.prev = head;
			newNode.next = head;
		}
		if (pos == 1)
			addFirst(val);
		else {
			for (int i = 1; i < pos - 1; i++)
				trav = trav.next;

			newNode.prev = trav;
			newNode.next = trav.next;
			trav.next.prev = newNode;
			trav.next = newNode;
		}
	}

	public void delFirst() {
		if (head == null)
			throw new RuntimeException("List is empty");
		if (head.next == head)
			head = null;
		else
			head.prev.next = head.next;
		head.next.prev = head.prev;
		head = head.next;

	}

	public void delLast() {
		Node temp = null;
		if (head == null)
			throw new RuntimeException("List is empty");
		if (head.next == head)
			head = null;
		else
			temp = head.prev;
		head.prev = temp.prev;
		temp.prev.next = head;

	}

	public void delAtPos(int pos) {
		Node trav = null;
		if (head == null)
			throw new RuntimeException("List is empty");
		if (head.next == head)
			head = null;
		if (pos == 1)
			delFirst();
		else
			trav = head;
		for (int i = 1; i < pos; i++) {
			if (trav.next == head)
				throw new RuntimeException("Invalid Position");
			trav = trav.next;

			trav.prev.next = trav.next;
			trav.next.prev = trav.prev;

		}

	}

	public void delAll() {
		head = null;
	}

}
