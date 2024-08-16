package sortingSLL;
import java.util.Scanner;

public class SinglyListMain {

	public static void main(String[] args) {
		int choice, val, pos;
		SinglyList list = new SinglyList();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println(
					"\n0. Exit\n1. Display\n2. Add First\n3. Add Last\n4. Add At Pos\n5. Del First\n6. Del Last\n7. Del At Pos\n8. Del All"+
					"\n9. Sort ascending list using selection sort \n10. Reverse list \n11. Reverse SLL using Recursion"+
							"\n12. Display reverse \n13. Find middle of SLL \nEnter choice: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1: // Display
				list.display();
				break;
			case 2: // Add First
				System.out.print("Enter new element: ");
				val = sc.nextInt();
				list.addFirst(val);
				break;
			case 3: // Add Last
				System.out.print("Enter new element: ");
				val = sc.nextInt();
				list.addLast(val);
				break;
			case 4: // Add At Pos
				System.out.print("Enter new element: ");
				val = sc.nextInt();
				System.out.print("Enter element position: ");
				pos = sc.nextInt();
				list.addAtPos(val, pos);				
				break;
			case 5: // Del First
				try {
					list.delFirst();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 6: // Del Last
				try {
					list.delLast();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 7: // Del At Pos
				System.out.print("Enter element position: ");
				pos = sc.nextInt();
				try {
					list.delAtPos(pos);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 8: // Del All
				list.delAll();
				break;
			case 9: // display ascending using selection sort 
				list.selectionAscendingSort();
				break;
			case 10: // display reverse using delFirst() & addFirst()
				list.reverseList();
				break;
			case 11: // reverse SLL using recursion
				list.revRecursionWrapperFun();
				break;
			case 12:
				list.displayReverseWrapperFun();
				break;
			case 13:
				int middleEle = list.findMiddleElement();
				System.out.println("Middle element is : " + middleEle);
				break;
			}
		} while (choice!=0);
		sc.close();
	}
}
