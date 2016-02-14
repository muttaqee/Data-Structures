package data_structure_implementations;

public class IntQuickSort {
	public static int[] a;

	private IntQuickSort() {
	}
	
	public static int[] sort(int[] arr) {
		// Copy array
		int n = arr.length;
		a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = arr[i];
		}
		
		// Sort
		quickSort(a, 0, n-1);
		
		return a;
	}
	
	private static void quickSort(int[] arr, int a, int b) {
		if (b - a < 1)
			return;
		
		int tmp;
		
		// Choose median pivot (may be omitted)
		{
			int p = a;
			if (arr[a] < arr[b] && arr[a] < arr[(a+b)/2])
				if (arr[b] < arr[(a+b)/2])
					p = b;
				else
					p = (a+b)/2;
			else if (arr[a] > arr[b] && arr[a] > arr[(a+b)/2])
				if (arr[b] > arr[(a+b)/2])
					p = b;
				else
					p = (a+b)/2;
			// Set pivot at beginning of array
			if (p != a) {
				tmp = arr[a];
				arr[a] = arr[p];
				arr[p] = tmp;
			}
		}
		
		// Partition sub-array around pivot
		int i = a;
		for (int j = a + 1; j <= b; j++)
			if (arr[j] < arr[a]) {
				tmp = arr[++i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		// Put pivot in place
		tmp = arr[i];
		arr[i] = arr[a];
		arr[a] = tmp;
		
		// Recursively Quick-Sort sub-arrays on either side of pivot
		quickSort(arr, a, i-1);
		quickSort(arr, i+1, b);
	}
	
}
