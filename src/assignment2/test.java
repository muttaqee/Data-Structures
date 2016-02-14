package assignment2;

import sandbox.IntArray;

public class test {
	
	private static int[] memory;

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		TapeDrive t = new TapeDrive(20);
		t.printTape();
		t = TapeDrive.generateRandomTape(10);
		t.printTape();
		
		memory = IntArray.genArray();
		IntArray.print(memory);
		quicksortHelper(0, memory.length-1);
		IntArray.print(memory);
	}
	
	private static void quicksortHelper(int left, int right) {
    	// Base case
    	if (right <= left) {
    		return;
    	}
    	
    	// Choose pivot (median of first, middle, and last); swap pivot with memory[left]
    	int pivotIdx = getIdxOfMedian(left, (left+right)/2, right);
    	if (pivotIdx != left) {
    		swap(left, pivotIdx);
    		pivotIdx = left;
    	}
    	
    	// Partition sub-array, then swap pivot element into place
    	int j = left;
    	for (int i = left+1; i <= right; i++) {
    		if (memory[i] < memory[pivotIdx]) {
    			swap(i, ++j);
    		}
    	}
    	swap(pivotIdx, j);
    	
    	// quick-sort sub-arrays
    	quicksortHelper(left, j-1);
    	quicksortHelper(j+1, right);
    }
    
    /**
     * Helper method: swaps array elements at positions i and j
     */
    private static void swap(int i, int j) {
    	int tmp = memory[i];
    	memory[i] = memory[j];
    	memory[j] = tmp;
    }
    
    /**
     * Helper method: choose median element (for use in quick-sort)
     */
    private static int getIdxOfMedian(int idxA, int idxB, int idxC) {
    	int median = idxA;
    	if (memory[idxA] < memory[idxB] && memory[idxA] < memory[idxC]) {
    		if (memory[idxB] < memory[idxC]) {
    			median = idxB;
    		} else {
    			median = idxC;
    		}
    	} else if (memory[idxA] > memory[idxB] && memory[idxA] > memory[idxC]) {
    		if (memory[idxB] > memory[idxC]) {
    			median = idxB;
    		} else {
    			median = idxC;
    		}
    	}
    	return median;
    }

}
