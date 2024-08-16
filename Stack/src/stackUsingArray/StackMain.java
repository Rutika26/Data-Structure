package stackUsingArray;

import java.util.Scanner;

public class StackMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Stack s = new Stack(6);
		int choice, val;
		do {
			System.out.println("\n0. Exit\n1. Push\n2. Pop\n3. Peek\nEnter choice: ");
			choice = sc.nextInt();
			switch(choice) {
			case 1: // push
				try {
					System.out.print("Enter value to push: ");
					val = sc.nextInt();
					s.push(val);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2: // pop
				try {
					val = s.peek();
					s.pop();
					System.out.println("Popped: " + val);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3: // peek
				try {
					val = s.peek();
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
