package data_structure_implementations;

public class IntBubbleSort {
	private static int[] a;
	
	private IntBubbleSort() {
	}
	
	public static int[] sort(int[] arr) {
		// Copy array
		int n = arr.length;
		a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = arr[i];
		}
		
		// Sort
		boolean sorted;
		int tmp;
		int i = 0;
		do {
			sorted = true;
			for (int j = 0; j < n - 1 - i; j++) {
				if (a[j] > a[j+1]) {
					sorted = false;
					tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
				}
			}
			i++;
		} while (!sorted);
		return a;
	}
}
