package data_structure_implementations;

public class IntInsertionSort {
	private static int[] a;
	
	private IntInsertionSort() {
	}
	
	public static int[] sort(int[] arr) {
		// Copy array
		int n = arr.length;
		a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = arr[i];
		}
		// Sort
		int tmp;
		for (int p = 1; p < n; p++) {
			tmp = a[p];
			int i;
			for (i = p; i > 0 && a[i-1] > tmp; i--) {
				a[i] = a[i-1];
			}
			a[i] = tmp;
		}
		return a;
	}
}
