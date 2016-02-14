package data_structure_implementations;

public class Node0Impl0<c> implements Node0<c> {
	private c item;
	private Node0<c> next;
	
	public Node0Impl0(c item, Node0<c> next) {
		this.item = item;
		this.next = next;
	}
	
	@Override
	public c getItem() {
		return item;
	}

	@Override
	public Node0<c> next() {
		return next;
	}
	
}

