package data_structure_implementations;

public class Stack0Impl0<c> implements Stack0<c> {
	
	Node0<c> top;
	
	public Stack0Impl0(c first_item) {
		top = new Node0Impl0<c>(first_item, null);
	}
	
	@Override
	public void push(c item) {
		top = new Node0Impl0<c>(item, top);
	}

	@Override
	public c pop() {
		if (top != null) {
			Node0<c> popped = top;
			top = top.next();
			return popped.getItem();
		}
		return null;
	}

	@Override
	public c peek() {
		if (top != null) {
			return top.getItem();
		}
		return null;
	}
	
	@Override
	public boolean isEmpty(){
		return (top == null);
	}

}
