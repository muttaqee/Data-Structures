package data_structure_implementations;

public class TreeNode<T> {
	T element;
	TreeNode<T> firstChild;
	TreeNode<T> nextSibling;
	
	public TreeNode (T element) {
		this.element = element;
	}
}
