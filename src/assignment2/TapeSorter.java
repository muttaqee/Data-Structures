package assignment2;

/**
 * Represents a machine with limited memory that can sort tape drives.
 */
public class TapeSorter {

    private int memorySize;
    private int tapeSize;
    public int[] memory;

    public TapeSorter(int memorySize, int tapeSize) {
        this.memorySize = memorySize;
        this.tapeSize = tapeSize;
        this.memory = new int[memorySize];
    }

    /**
     * Sorts the first `size` items in memory via quicksort
     */
    public void quicksort(int size) {
        // TODO: Implement me for 10 points
    	quicksortHelper(0, size-1);
    }
    
    /**
     * Primary quick sort helper method: performs recursive quick sort on given 'memory' sub-array
     */
    private void quicksortHelper(int left, int right) {
    	// Base case
    	if (right <= left) {
    		return;
    	}
    	
    	// Choose pivot (median of first, middle, and last elements); swap pivot with memory[left]
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
    	
    	// Quick-sort sub-arrays
    	quicksortHelper(left, j-1);
    	quicksortHelper(j+1, right);
    }
    
    /**
     * Helper method: swaps array elements at positions i and j
     */
    private void swap(int i, int j) {
    	int tmp = memory[i];
    	memory[i] = memory[j];
    	memory[j] = tmp;
    }
    
    /**
     * Helper method: choose median element (for use in quick-sort)
     */
    private int getIdxOfMedian(int idxA, int idxB, int idxC) {
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

    /**
     * Reads in numbers from drive `in` into memory (a chunk), sorts it, then writes it out to a different drive.
     * It writes chunks alternatively to drives `out1` and `out2`.
     *
     * If there are not enough numbers left on drive `in` to fill memory, then it should read numbers until the end of
     * the drive is reached.
     *
     * Example 1: Tape size = 8, memory size = 2
     * ------------------------------------------
     *   BEFORE:
     * in: 4 7 8 6 1 3 5 7
     *
     *   AFTER:
     * out1: 4 7 1 3 _ _ _ _
     * out2: 6 8 5 7 _ _ _ _
     *
     *
     * Example 2: Tape size = 10, memory size = 3
     * ------------------------------------------
     *   BEFORE:
     * in: 6 3 8 9 3 1 0 7 3 5
     *
     *   AFTER:
     * out1: 3 6 8 0 3 7 _ _ _ _
     * out2: 1 3 9 5 _ _ _ _ _ _
     *
     *
     * Example 3: Tape size = 13, memory size = 4
     * ------------------------------------------
     *   BEFORE:
     * in: 6 3 8 9 3 1 0 7 3 5 9 2 4
     *
     *   AFTER:
     * out1: 3 6 8 9 2 3 5 9 _ _ _ _ _
     * out2: 0 1 3 7 4 _ _ _ _ _ _ _ _
     */
    public void initialPass(TapeDrive in, TapeDrive out1, TapeDrive out2) {
        // TODO: Implement me for 15 points!
    	
    	int wholeChunks = tapeSize / memorySize; // Number of chunks to read
    	int lastChunkSize = tapeSize % memorySize; // Size of last chunk
    	int c = 0; // Counter (chunk number)
    	int i; // Counter (for reading/writing)
    	
    	while (c < wholeChunks) {
    		// Read into memory
    		i = 0;
    		while (i < memorySize) memory[i++] = in.read();
    		
    		// Sort in memory
    		quicksort(memorySize);
    		
    		// Write to out1 if even-numbered chunk, out2 if odd-numbered chunk
    		i = 0;
    		if (c % 2 == 0) {
    			while (i < memorySize) out1.write(memory[i++]);
    		} else {
    			while (i < memorySize) out2.write(memory[i++]);
    		}
    		
    		c++;
    	}
    	
    	// Read, sort, and write "leftover" partial chunk:
    	if (lastChunkSize > 0) {
    		// Read into memory
    		i = 0;
    		while (i < lastChunkSize) memory[i++] = in.read();
    		
    		// Sort in memory
    		quicksort(lastChunkSize);
    		
    		// Write to out1 if even-numbered chunk, out2 if odd-numbered chunk
    		i = 0;
    		if (c % 2 == 0) {
    			while (i < lastChunkSize) out1.write(memory[i++]);
    		} else {
    			while (i < lastChunkSize) out2.write(memory[i++]);
    		}
    	}
    }

    /**
     * Merges the first chunk on drives `in1` and `in2` and writes the sorted, merged data to drive `out`.
     * The size of the chunk on drive `in1` is `size1`.
     * The size of the chunk on drive `in2` is `size2`.
     *
     *          Example
     *       =============
     *
     *  (BEFORE)
     * in1:  [ ... 1 3 6 8 9 ... ]
     *             ^
     * in2:  [ ... 2 4 5 7 8 ... ]
     *             ^
     * out:  [ ... _ _ _ _ _ ... ]
     *             ^
     * size1: 4, size2: 4
     *
     *   (AFTER)
     * in1:  [ ... 1 3 6 8 9 ... ]
     *                     ^
     * in2:  [ ... 2 4 5 7 8 ... ]
     *                     ^
     * out:  [ ... 1 2 3 4 5 6 7 8 _ _ _ ... ]
     *                             ^
     */
    public void mergeChunks(TapeDrive in1, TapeDrive in2, TapeDrive out, int size1, int size2) {
        // TODO: Implement me for 10 points
    	
    	int i1 = 0, i2 = 0; // Counters
    	int tmp1, tmp2; // Holds integers read from input drives
    	
    	// Merge by comparing integers from both chunks
    	if (i1 < size1 && i2 < size2) {		// Only run comparisons if both chunks at least size 1
    		
    		tmp1 = in1.read();
    		tmp2 = in2.read();
    		
    		// Begin merging
    		while (true) {
    			if (tmp1 < tmp2) {			// in1 has smaller int
    				out.write(tmp1);		// So write from in1
    				if (++i1 < size1) {
    					tmp1 = in1.read();	// Read next from in1 if not at its end
    				} else {
    					break;
    				}
    			} else {					// in2 has smaller int
    				out.write(tmp2);		// So write from in2
    				if (++i2 < size2) {
    					tmp2 = in2.read();	// Read next from in2 if not at its end
    				} else {
    					break;
    				}
    			}
    		}
    		
    		// tmp1 or tmp2 still contains element yet to be written
    		if (i1 < size1) {
    			out.write(tmp1);
    			i1++;
    		} else if (i2 < size2) {
    			out.write(tmp2);
    			i2++;
    		}
    	}
    	
    	// If end of either chunk not reached yet, write remaining elements from that chunk
    	while (i1 < size1) { out.write(in1.read()); i1++; }
    	while (i2 < size2) { out.write(in2.read()); i2++; }
    }

    /**
     * Merges chunks from drives `in1` and `in2` and writes the resulting merged chunks alternatively to drives `out1`
     * and `out2`.
     *
     * The `runNumber` argument denotes which run this is, where 0 is the first run.
     *
     * -- Math Help --
     * The chunk size on each drive prior to merging will be: memorySize * (2 ^ runNumber)
     * The number of full chunks on each drive is: floor(tapeSize / (chunk size * 2))
     *   Note: If the number of full chunks is 0, that means that there is a full chunk on drive `in1` and a partial
     *   chunk on drive `in2`.
     * The number of leftovers is: tapeSize - 2 * chunk size * number of full chunks
     *
     * To help you better understand what should be happening, here are some examples of corner cases (chunks are
     * denoted within curly braces {}):
     *
     * -- Even number of chunks --
     * in1 ->   { 1 3 5 6 } { 5 7 8 9 }
     * in2 ->   { 2 3 4 7 } { 3 5 6 9 }
     * out1 ->  { 1 2 3 3 4 5 6 7 }
     * out2 ->  { 3 5 5 6 7 8 9 9 }
     *
     * -- Odd number of chunks --
     * in1 ->   { 1 3 5 } { 6 7 9 } { 3 4 8 }
     * in2 ->   { 2 4 6 } { 2 7 8 } { 0 3 9 }
     * out1 ->  { 1 2 3 4 5 6 } { 0 3 3 4 8 9 }
     * out2 ->  { 2 6 7 7 8 9 }
     *
     * -- Number of leftovers <= the chunk size --
     * in1 ->   { 1 3 5 6 } { 5 7 8 9 }
     * in2 ->   { 2 3 4 7 }
     * out1 ->  { 1 2 3 3 4 5 6 7 }
     * out2 ->  { 5 7 8 9 }
     *
     * -- Number of leftovers > the chunk size --
     * in1 ->   { 1 3 5 6 } { 5 7 8 9 }
     * in2 ->   { 2 3 4 7 } { 3 5 }
     * out1 ->  { 1 2 3 3 4 5 6 7 }
     * out2 ->  { 3 5 5 7 8 9 }
     *
     * -- Number of chunks is 0 --
     * in1 ->   { 2 4 5 8 9 }
     * in2 ->   { 1 5 7 }
     * out1 ->  { 1 2 4 5 5 7 8 9 }
     * out2 ->
     */
    public void doRun(TapeDrive in1, TapeDrive in2, TapeDrive out1, TapeDrive out2, int runNumber) {
        // TODO: Implement me for 15 points
    	
    	int chunkSize = memorySize * (int)Math.pow(2, runNumber);
    	int numFullChunks = tapeSize / (2 * chunkSize); // (On each drive.) If 0, partial chunk on in2
    	int numLeftovers = tapeSize - (2 * chunkSize * numFullChunks);
    	
    	// Drives must be read from and written to from beginning
		in1.reset();
		in2.reset();
		out1.reset();
		out2.reset();
    	
    	int c = 0; // Counter: chunk-merge number
    	
    	while (c < numFullChunks) {
    		if (c % 2 == 0) { // Even-number chunk-merge: merge to out1
    			mergeChunks(in1, in2, out1, chunkSize, chunkSize);
    		} else { // Odd-number chunk-merge: merge to out2
    			mergeChunks(in1, in2, out2, chunkSize, chunkSize);
    		}
    		c++;
    	}
    	
    	// Handle remaining partial chunk
    	if (numLeftovers > 0) {
        	
        	TapeDrive writeTo;
    		
        	if (numFullChunks == 0 || numLeftovers > chunkSize) { // Partial chunk on in2
        		if (c % 2 == 0) {
        			writeTo = out1;
        		} else {
        			writeTo = out2;
        		}
        		mergeChunks(in1, in2, writeTo, chunkSize, numLeftovers - chunkSize);
    		} else { // Partial chunk on in1
        		if (c % 2 == 0) {
        			writeTo = out1;
        		} else {
        			writeTo = out2;
        		}
        		while (numLeftovers > 0) { writeTo.write(in1.read()); numLeftovers--; }
    		}
    	}
    	
    }

    /**
     * Sorts the data on drive `t1` using the external sort algorithm. The sorted data should end up on drive `t1`.
     *
     * Initially, drive `t1` is filled to capacity with unsorted numbers.
     * Drives `t2`, `t3`, and `t4` are empty and are to be used in the sorting process.
     */
    public void sort(TapeDrive t1, TapeDrive t2, TapeDrive t3, TapeDrive t4) {
        // TODO: Implement me for 15 points
    	
    	if (tapeSize < 1 || memorySize < 1) { // Corner case: cannot perform sort
    		return;
    	}
    	
    	initialPass(t1, t3, t4);
    	
    	if (tapeSize <= memorySize) { // Corner case: sort in memory; write back to t1
    		mergeChunks(t3, t4, t1, tapeSize, 0);
    	} else {
    		int c = 0; // Counter: run number
    		
    		// Computer number of passes necessary, p (after initial run-constructing pass)
    		int p = (int)Math.ceil(Math.log(tapeSize / (double)memorySize) / Math.log(2));
    		
    		// Perform q passes
    		while (c < p) {
    			if (c % 2 == 0) {
    				doRun(t3, t4, t1, t2, c++);
    			} else {
    				doRun(t1, t2, t3, t4, c++);
    			}
    		}
    		
    		// If p even, must copy from t3 back to t1
    		if (p % 2 == 0) {
    			mergeChunks(t3, t4, t1, tapeSize, 0);
    		}
    	}
    }

    public static void main(String[] args) {
        // Example of how to test
        TapeSorter tapeSorter = new TapeSorter(10, 80);
        TapeDrive t1 = TapeDrive.generateRandomTape(80);
        TapeDrive t2 = new TapeDrive(80);
        TapeDrive t3 = new TapeDrive(80);
        TapeDrive t4 = new TapeDrive(80);

        tapeSorter.sort(t1, t2, t3, t4);
        int last = Integer.MIN_VALUE;
        boolean sorted = true;
        for (int i = 0; i < 80; i++) {
            int val = t1.read();
            sorted &= last <= val; // <=> sorted = sorted && (last <= val);
            last = val;
        }
        if (sorted)
            System.out.println("Sorted!");
        else
            System.out.println("Not sorted!");
    }

}
