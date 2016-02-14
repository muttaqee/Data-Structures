package assignment2;

public class Tester {
	
	private static long test(int memSize, int test_size) {
        // Example of how to test
        TapeSorter tapeSorter = new TapeSorter(memSize, test_size);
        TapeDrive t1 = TapeDrive.generateRandomTape(test_size);
        TapeDrive t2 = new TapeDrive(test_size);
        TapeDrive t3 = new TapeDrive(test_size);
        TapeDrive t4 = new TapeDrive(test_size);
        /*
        if (test_size <= 50)
        	t1.printTape();
        */
        // TEST
        long time0, time1;
        time0 = System.nanoTime();
        tapeSorter.sort(t1, t2, t3, t4);
        time1 = System.nanoTime();
        
        int last = Integer.MIN_VALUE;
        boolean sorted = true;
        for (int i = 0; i < test_size; i++) {
            int val = t1.read();
            sorted &= last <= val; // <=> sorted = sorted && (last <= val);
            last = val;
        }
        if (!sorted)
            System.out.println("Not sorted!");
        /*else
        	System.out.println("Sorted!");*/
        //t1.printTape();
        
        return time1 - time0;
	}
	
	private static void textbookTest() {
        // Example of how to test
        TapeSorter tapeSorter = new TapeSorter(12, 13);
        TapeDrive t1 = new TapeDrive(13);
        TapeDrive t2 = new TapeDrive(13);
        TapeDrive t3 = new TapeDrive(13);
        TapeDrive t4 = new TapeDrive(13);
        
        int[] arr = {81, 94, 11, 96, 12, 35, 17, 99, 28, 58, 41, 75, 15};
        for (int i = 0; i < arr.length; i++) {
        	t1.write(arr[i]);
        }

        tapeSorter.sort(t1, t2, t3, t4);
        
        t1.printTape();
        t2.printTape();
        t3.printTape();
        t4.printTape();
        
        int last = Integer.MIN_VALUE;
        boolean sorted = true;
        for (int i = 0; i < 13; i++) {
            int val = t1.read();
            sorted &= last <= val; // <=> sorted = sorted && (last <= val);
            last = val;
        }
        if (sorted)
            System.out.println("Sorted!");
        else
            System.out.println("Not sorted!");
	}
	
	private static void problemTest1() {
        // Example of how to test
		int n = 5;
        TapeSorter tapeSorter = new TapeSorter(10, n);
        TapeDrive t1 = new TapeDrive(n);
        TapeDrive t2 = new TapeDrive(n);
        TapeDrive t3 = new TapeDrive(n);
        TapeDrive t4 = new TapeDrive(n);
        
        int[] arr = {559704035, 987999338, 876831816, 122767395, -1172920418};
        for (int i = 0; i < arr.length; i++) {
        	t1.write(arr[i]);
        }

        tapeSorter.sort(t1, t2, t3, t4);
        
        t1.printTape();
        t2.printTape();
        t3.printTape();
        t4.printTape();
        
        int last = Integer.MIN_VALUE;
        boolean sorted = true;
        for (int i = 0; i < n; i++) {
            int val = t1.read();
            sorted &= last <= val; // <=> sorted = sorted && (last <= val);
            last = val;
        }
        if (sorted)
            System.out.println("Sorted!");
        else
            System.out.println("Not sorted!");
	}
	
	private static void problemTest2() {
        // Example of how to test
		int n = 21;
        TapeSorter tapeSorter = new TapeSorter(10, n);
        TapeDrive t1 = new TapeDrive(n);
        TapeDrive t2 = new TapeDrive(n);
        TapeDrive t3 = new TapeDrive(n);
        TapeDrive t4 = new TapeDrive(n);
        
        int[] arr = {-67823107, 332855399, 63038068, 1259424844, 7499937, 63054393, 656425537, -1461190573, -1764867301, 1006601059, -236232699, -1952283140, -2059727755, -1698520586, -1335387078, -1392308027, -437874850, 1032132212, 1280189494, -1711686577, 272581677};
        for (int i = 0; i < arr.length; i++) {
        	t1.write(arr[i]);
        }

        tapeSorter.sort(t1, t2, t3, t4);
        
        t1.printTape();
        t2.printTape();
        t3.printTape();
        t4.printTape();
        
        int last = Integer.MIN_VALUE;
        boolean sorted = true;
        for (int i = 0; i < n; i++) {
            int val = t1.read();
            sorted &= last <= val; // <=> sorted = sorted && (last <= val);
            last = val;
        }
        if (sorted)
            System.out.println("Sorted!");
        else
            System.out.println("Not sorted!");
	}
	
	private static void problemTest3()  {
        // Example of how to test
		
		int test_size = 11, memSize = 3;
        TapeSorter tapeSorter = new TapeSorter(memSize, test_size);
        TapeDrive t1 = TapeDrive.generateRandomTape(test_size);
        TapeDrive t2 = new TapeDrive(test_size);
        TapeDrive t3 = new TapeDrive(test_size);
        TapeDrive t4 = new TapeDrive(test_size);
        
        t1.printTape();

        tapeSorter.sort(t1, t2, t3, t4);
        
        int last = Integer.MIN_VALUE;
        boolean sorted = true;
        for (int i = 0; i < test_size; i++) {
            int val = t1.read();
            sorted &= last <= val; // <=> sorted = sorted && (last <= val);
            last = val;
        }
        if (sorted)
            System.out.println("Sorted!");
        else
            System.out.println("Not sorted!");
	}
	
	private static void borrowedTest() {
		long epoch1 = System.currentTimeMillis();
		for(int i=50;i<1000;i++){
			for (int k=1;k<50;k++){
				TapeSorter tapeSorter = new TapeSorter(k, i);
				TapeDrive t1 = TapeDrive.generateRandomTape(i);
				TapeDrive t2 = new TapeDrive(i);
				TapeDrive t3 = new TapeDrive(i);
				TapeDrive t4 = new TapeDrive(i);

				tapeSorter.sort(t1, t2, t3, t4);

				int last = Integer.MIN_VALUE;
				boolean sorted = true;
				for (int j = 0; j < i; j++) {
					int val = t1.read();
					sorted &= (last <= val);
					if (!sorted){
						//System.out.println( val + " " + j);
					}
					last = val;
				}
				if (sorted){}
				//System.out.println("Sorted!");
				else
					System.out.println("Not sorted! Failed at tapesize " + i + " and memory size " + k);
			}
		}
		long epoch2 = System.currentTimeMillis();
		System.out.println("Runtime is " + ((epoch2 - epoch1)/1000) + " seconds.");
		System.out.println("Done: No Output = tests passed!");
	}

	public static void main(String[] args) {
		//textbookTest();
		/*
		for (int i = 1; i < 1000; i++) {
			//System.out.println("\nSize = " + i + "...");
			for (int j = 1; j < 10; j++) {
				test(j, i);
			}
		}
		for (int i = 0; i < 5; i++)
			System.out.println(test(10, 1000000) + " nanoseconds");
		*/
		//problemTest1();
		//problemTest2();
		//problemTest3();
		borrowedTest();
	}

}
