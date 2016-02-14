package data_structure_implementations;

import sandbox.IntArray;

public class sortTests {
	
	private static int[] arr;

	public static void main(String[] args) {
		IntInsertionSortTest();
		IntBubbleSortTest();
		IntQuickSortTest();
		//IntMergeSortTest();
		IntBucketSortTest();
	}
	
	private static void IntBucketSortTest() {
		System.out.println("Bucket sorting...");
		int size = 20;
		arr = IntArray.genArray(size);
		IntArray.print(arr);
		arr = IntBucketSort.bucketSort(arr, size);
		
		System.out.println();
		IntArray.print(arr);
	}
	
	private static void IntMergeSortTest() {
		System.out.println("Merge sorting...");
		arr = IntArray.genArray();
		IntArray.print(arr);
		arr = IntMergeSort.sort(arr);
		
		System.out.println();
		IntArray.print(arr);
	}

	private static void IntQuickSortTest() {
		System.out.println("Quick sorting...");
		arr = IntArray.genArray();
		IntArray.print(arr);
		arr = IntQuickSort.sort(arr);
		
		System.out.println();
		IntArray.print(arr);
	}
	
	private static void IntInsertionSortTest() {
		System.out.println("Insertion sorting...");
		arr = IntArray.genArray();
		IntArray.print(arr);
		arr = IntInsertionSort.sort(arr);
		
		System.out.println();
		IntArray.print(arr);
	}
	
	private static void IntBubbleSortTest() {
		System.out.println("Bubble sorting...");
		arr = IntArray.genArray();
		IntArray.print(arr);
		arr = IntBubbleSort.sort(arr);
		
		System.out.println();
		IntArray.print(arr);
	}

}
