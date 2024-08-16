package linearQueue;

import java.util.Scanner;


public class LinearQueueMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinearQueue q = new LinearQueue(6);
		int choice, val;
		do {
			System.out.println("\n0. Exit\n1. Enqueue\n2. Dequeue\n3. Peek\nEnter choice: ");
			choice = sc.nextInt();
			switch(choice) {
			case 1: // enqueue
				try {
					System.out.print("Enter value to enqueue: ");
					val = sc.nextInt();
					q.enqueue(val);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2: // dequeue
				try {
					val = q.peek();
					q.dequeue();
					System.out.println("Dequeued: " + val);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3: // peek
				try {
					val = q.peek();
					System.out.println("Peek: " + val);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			}
		}while(choice != 0);
		sc.close();

	}

}
