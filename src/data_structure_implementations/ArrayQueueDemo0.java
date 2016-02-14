package data_structure_implementations;

public class ArrayQueueDemo0 {
	
	private static ArrayQueue0<Integer> a;

	public static void main(String[] args) {
		a = new ArrayQueueImpl0<Integer>(3);
		a.print();
		
		a.dequeue();
		a.print();
		
		a.enqueue(0);
		a.print();
		
		a.enqueue(1);
		a.print();
		
		a.enqueue(2);
		a.print();
		
		a.enqueue(3);
		a.print();
	}

}
