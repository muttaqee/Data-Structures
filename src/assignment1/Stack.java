package assignment1;

public class Stack<T> {
	Node<T> top;
	
	public Stack() {
		top = null;
	}
	
	public void push(T element) {
		top = new Node<T>(element, top);
	}
	
	public T pop() {
		if (!isEmpty()) {
			T tmp = top.item;
			top = top.next;
			return tmp;
		}
		return null;
	}
	
	public T peek() {
		if (!isEmpty()) {
			return top.item;
		}
		return null;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
}
