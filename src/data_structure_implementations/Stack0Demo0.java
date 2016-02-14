package data_structure_implementations;

public class Stack0Demo0 {
	
	private static Stack0<Integer> list1;

	public static void main(String[] args) {
		list1 = new Stack0Impl0<Integer>(1);
		
		report();
		
		list1.pop();
		
		report();
		
		list1.push(1);
		list1.push(2);
		list1.push(3);
		
		report();
		
		for (int i = 0; i < 4; i++) {
			list1.pop();
			report();
		}
	}
	
	public static void report() {
		print("Is empty? - " + list1.isEmpty());
		print("Topmost item - " + list1.peek());
		print("");
	}
	
	public static void print(String s) {
		System.out.println(s);
	}
	
	public static void print(char c) {
		System.out.println(c);
	}
	
	public static void print(boolean b) {
		System.out.println(b);
	}

}
