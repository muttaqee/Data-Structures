package assignment1;

public class VipQueue<T> {
	Stack<T> s;
	Queue<T> q;
	private int cardinality;
	
	public VipQueue() {
		s = new Stack<T>();
		q = new Queue<T>();
		cardinality = 0;
	}
	
	public boolean isEmpty() {
		return cardinality == 0;
	}
	
	public T peek() {
		return q.peek();
	}
	
	public T dequeue() {
		if (!isEmpty()) {
			T tmp = q.dequeue();
			s.top = q.front; // Update stack (reflect queue change)
			cardinality--;
			return tmp;
		}
		return null;
	}
	
	public void enqueue(T element) {
		q.enqueue(element);
		s.top = q.front; // Update stack (reflect queue change)
		cardinality++;
	}
	
	public void vipEnqueue(T element) {
		s.push(element);
		q.front = s.top; // Update queue (reflect stack change)
		cardinality++;
	}
}
