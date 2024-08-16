package circularQueue;

public class CicularQueue {
	private int[] arr;
	private int rear, front;

	public CicularQueue(int size) {
		arr = new int[size];
		rear = -1;
		front = -1;
	}

	public boolean isFull() {
		return (front == -1 && rear == arr.length - 1) ||
				(front == rear && front != -1);
	}

	public boolean isEmpty() {
		return (front == rear && front == -1);
	}

	public void enqueue(int val) {
		if (isFull())
			throw new RuntimeException("Queue is full");
		rear = (rear + 1) % arr.length;
		arr[rear] = val;
	}

	public void dequeue() {
		if (isEmpty())
			throw new RuntimeException("Queue is empty");
		front = (front + 1) % arr.length;
		if (front == rear) {
			rear = -1;
			front = -1;
		}
	}

	public int peek() {
		if (isEmpty())
			throw new RuntimeException("Queue is empty");
		int index = (front + 1) % arr.length;
		return arr[index];
	}
}
