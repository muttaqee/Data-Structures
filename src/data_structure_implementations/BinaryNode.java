package data_structure_implementations;

public class BinaryNode<T> {
	T element;
	BinaryNode<T> left;		// Left child
	BinaryNode<T> right;	// Right child
	
	public BinaryNode(T element) {
		this.element = element;
	}
}
