package bubbleSort;

import java.util.Arrays;

public class BubbleSort {

	public static void bubbleSorting(int[] arr) {
		boolean swapFlag=false;
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					swapFlag=true;
				}
			}
			 // check if array is already sorted
			//best case time complexity = O(n)
			if(!swapFlag)
				break;
			System.out.println("After pass " + (i+1)  + " : " +Arrays.toString(arr));
		}
	}
	public static void main(String[] args) {
		int[] arr = {6,4,2,8,3,1};
		System.out.println(arr.length);
		System.out.println("Before Sort = " + Arrays.toString(arr));
		bubbleSorting(arr);
		System.out.println("Sorted using bubble = " + Arrays.toString(arr));

	}

}
