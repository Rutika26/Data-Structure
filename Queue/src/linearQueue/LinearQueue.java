package linearQueue;

public class LinearQueue {
	private int[] arr;
	private int rear,front;
	public LinearQueue(int size) {
		arr = new int[size];
		rear=-1;
		front=-1;
	}
	public boolean isFull() {
		return rear==arr.length-1;
	}
	public boolean isEmpty() {
		return rear==front;
	}
	public void enqueue(int val) {
		if(isFull())
			throw new RuntimeException("Queue is full");
		rear++;
		arr[rear]=val;
	}
	public void dequeue() {
		if(isEmpty())
			throw new RuntimeException("Queue is empty");
		front++;
	}
	public int peek() {
		if(isEmpty())
			throw new RuntimeException("Queue is empty");
		return arr[front+1];
	}
}
