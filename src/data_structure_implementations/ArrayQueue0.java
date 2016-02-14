package data_structure_implementations;

public interface ArrayQueue0<c> {
	public void enqueue(c item);
	public void dequeue();
	public c peek();
	public boolean isEmpty();
	public boolean isFull();
	public void print();
}
