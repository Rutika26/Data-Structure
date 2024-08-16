package insertionSort;

import java.util.Arrays;

public class InsertionSort {
	public static void insertionSorting(int arr[]) {
		for(int i=1;i<arr.length;i++) {
			int j,temp=arr[i];
			for(j=i-1;j>=0 && arr[j]>temp ;j--) {
				arr[j+1]=arr[j];
			}
			arr[j+1]=temp;
			System.out.println("After pass " + i   + " : " +Arrays.toString(arr));
		}
	}
	public static void main(String[] args) {
		int[] arr = {6,4,2,8,3,1};
		System.out.println(arr.length);
		System.out.println("Before Sort = " + Arrays.toString(arr));
		insertionSorting(arr);
		System.out.println("Sorted using insertion = " + Arrays.toString(arr));

	}

}
