package data_structure_implementations;

public class IntQuickSortDraft {
	public static int[] a;

	private IntQuickSortDraft() {
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

	private static void quickSort(int[] a, int start, int end) {
		int n = end - start + 1;
		if (n <= 1) {
			return;
		}
		
		int tmp;
		
		// Choose pivot (find median)
		int p = start;
		if (a[p] < a[end] && a[p] < a[(start+end)/2]) {
			if (a[end] < a[(start+end)/2]) {
				p = end;
			} else {
				p = (start+end)/2;
			}
		} else if (a[p] > a[end] && a[p] > a[(start+end)/2]) {
			if (a[end] > a[(start+end)/2]) {
				p = end;
			} else {
				p = (start+end)/2;
			}
		}
		
		// Set pivot at a[start]
		if (p != start) {
			tmp = a[start];
			a[start] = a[p];
			a[p] = tmp;
			p = start;
		}
		
		// Partition so that [a[1], a[i]] < pivot < [a[i+1], a[n-1]]
		int i = start;
		for (int j = start + 1; j <= end; j++) {
			if (a[j] < a[p]) {
				i++;
				tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
			}
		}
		// Put pivot in place: swap a[start] with a[i]; a[i] holds pivot
		tmp = a[i];
		a[i] = a[start];
		a[start] = tmp;
		
		// Recursively sort sub-arrays on either side of pivot
		quickSort(a, start, i-1);
		quickSort(a, i+1, end);
	}
	
}
