package selectionSort;

import java.util.Arrays;

public class SelectionSort {

	public static void selectionSorting(int arr[]) {
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					int temp = arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
			System.out.println("After pass " + (i+1)  + " : " +Arrays.toString(arr));
		}
	}
	public static void main(String[] args) {
	int[] arr = {2,4,8,1,5,3,6,9};
	System.out.println("Before Sort = " + Arrays.toString(arr));
	selectionSorting(arr);
	System.out.println("Sorted using selection = " + Arrays.toString(arr));

	}

}
