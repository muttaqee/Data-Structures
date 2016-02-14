package data_structure_implementations;

public class IntMergeSort {
	
	private IntMergeSort() {
	}
	
	public static int[] sort(int[] array) {
		int n = array.length;
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = array[i];
		}
		
		arr = mergeSort(arr, 0, n-1);
		
		return arr;
	}
	
	private static int[] mergeSort(int[] arr, int l, int r) {
		if (l >= r) {
			return arr;
		}
		int m = (r - l)/2;
		mergeSort(arr, l, m);
		mergeSort(arr, m + 1, r);
		
		// Merge
		int[] tmp = new int[r - l + 1];
		int lStart = l, lEnd = m, rStart = m+1, rEnd = r, tmpPos = 0;
		while (lStart <= lEnd && rStart <= rEnd) {
			if (arr[lStart] < arr[rStart]) {
				tmp[tmpPos++] = arr[lStart++];
			} else {
				tmp[tmpPos++] = arr[rStart++];
			}
		}
		// Copy remaining
		while (lStart < lEnd) tmp[tmpPos++] = arr[lStart++];
		while (rStart < rEnd) tmp[tmpPos++] = arr[rStart++];
		
		for (int i = 0; i < r - 1 + 1; i++, rEnd--) {
			arr[rEnd] = tmp[rEnd];
		}
		
		return arr;
	}
}
