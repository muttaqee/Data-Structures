package assignment1;

public class Queue<T> {
	Node<T> front;
	Node<T> rear;
	
	public Queue() {
		front = null;
		rear = null;
	}
	
	public boolean isEmpty() {
		return front == null;
	}
	
	public T peek() {
		if (!isEmpty()) {
			return front.item;
		}
		return null;
	}
	
	public T dequeue() {
		if (!isEmpty()) {
			T tmp = front.item;
			if (front == rear) { // Only one node
				front = rear = null;
			} else { // More than one node
				front = front.next;
			}
			return tmp;
		}
		return null;
	}
	
	public void enqueue(T element) {
		if (!isEmpty()) {
			rear.next = new Node<T>(element, null); // Append new node to rear
			rear = rear.next; // Rear becomes new node
			return;
		}
		front = rear = new Node<T>(element, null);
	}
}
