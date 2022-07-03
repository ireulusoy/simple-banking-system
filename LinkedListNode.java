package bank;

public class LinkedListNode {

	private String name;
	private long iban;
	private LinkedListNode link;
	
	public LinkedListNode() {
		link = null;
		name = null;
		iban = 0;	
	}
	
	public LinkedListNode(String name, long iban, LinkedListNode link) {
		this.name = name;
		this.iban = iban;
		this.link = link;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getIban() {
		return iban;
	}

	public void setIban(long iban) {
		this.iban = iban;
	}

	public LinkedListNode getLink() {
		return link;
	}

	public void setLink(LinkedListNode link) {
		this.link = link;
	}
	
	
	

	
}
