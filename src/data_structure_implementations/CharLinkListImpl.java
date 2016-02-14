package data_structure_implementations;

public class CharLinkListImpl implements CharLinkList {
	
	private CharLink first_link;
	
	public CharLinkListImpl(char first_char) {
		first_link = new CharLinkImpl(first_char, null);
	}

	@Override
	public void addLink(char c) {
		first_link = new CharLinkImpl(c, first_link);
	}

	@Override
	// Maybe not the correct implementation
	public void removeLink(char c) {
		if (first_link != null && first_link.get() == c) {
			first_link = first_link.next();
			return;
		}
		
		CharLink temp = first_link;
		
		while (temp != null) {
			if (temp.get() == c) {
				temp = temp.next();
			}
			return;
		}
		return;
	}
	
}
