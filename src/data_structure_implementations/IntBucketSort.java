package data_structure_implementations;

public class IntBucketSort {
	private IntBucketSort() {
	}
	
	public static int[] bucketSort(int[] arr, int max) {
		int[] buckets = new int[max + 1];
		for (int i = 0; i < arr.length; i++) {
			buckets[arr[i]]++;
		}
		
		int b = 0;
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] > 0) {
				for (int j = buckets[i]; j > 0; j--) {
					arr[b++] = i;
				}
			}
		}
		return arr;
	}
}
