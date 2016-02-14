package data_structure_implementations;

public class CharLinkImpl implements CharLink {
	
	private char c;
	private CharLink next;
	
	public CharLinkImpl(char c, CharLink next) {
		this.c = c;
		this.next = next;
	}

	@Override
	public char get() {
		return c;
	}

	@Override
	public CharLink next() {
		return next;
	}

}
