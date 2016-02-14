package assignment1;

public class Node<T> {
	T item;
	Node<T> next;
	
	public Node(T item, Node<T> next) {
		this.item = item;
		this.next = next;
	}
}
