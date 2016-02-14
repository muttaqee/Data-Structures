package data_structure_implementations;

public class ArrayQueueImpl0<c> implements ArrayQueue0<c> {
	
	private c[] array;
	private int frontOfQueue, rearOfQueue;
	
	public ArrayQueueImpl0(int size) {
		array = (c[]) new Object[size];
		frontOfQueue = rearOfQueue = -1;
	}

	@Override
	public void enqueue(c item) {
		if (!isFull()) {
			rearOfQueue = (rearOfQueue + 1) % array.length;
			array[rearOfQueue] = item;
		}
	}

	@Override
	public void dequeue() {
		if (!isEmpty()) {
			array[frontOfQueue] = null;
			frontOfQueue = (frontOfQueue + 1) % array.length;
		}
	}

	@Override
	public c peek() {
		return array[frontOfQueue];
	}

	@Override
	public boolean isEmpty() {
		return array[frontOfQueue] == null;
	}

	@Override
	public boolean isFull() {
		return frontOfQueue == (rearOfQueue + 1) % array.length;
	}
	
	@Override
	public void print() {
		System.out.print("[ ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("]");
	}

}
