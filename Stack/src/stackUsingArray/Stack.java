package stackUsingArray;

public class Stack {
	private int[] arr;
	private int top;
	
	public Stack(int size) {
		arr = new  int[size];
		top = -1;
	}
	
	public void push(int val) {
		if(isFull())
			throw new RuntimeException("Stack is full");
		top++;
		arr[top]=val;
	}
	public void pop() {
		if(isEmpty())
			throw new RuntimeException("Stack is empty");
		top--;
	}
	public int peek() {
		if(isEmpty())
			throw new RuntimeException("Stack is empty");
		return arr[top];
	}
	public boolean isEmpty() {
		return top==-1;
	}
	public boolean isFull() {
		return top == arr.length-1;
	}
}
