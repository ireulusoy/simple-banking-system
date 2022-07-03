package bank;

public class BstNode {

	String acName;
	long acIban;
	int total;
	private BstNode right;
	private BstNode left;
	
	
	public BstNode(String acName, long acIban) {
		this.acName = acName;
		this.acIban = acIban;
		this.total = 0;
		right = null;
		left = null;
	}

	

	public BstNode getRight() {
		return right;
	}


	public void setRight(BstNode right) {
		this.right = right;
	}


	public BstNode getLeft() {
		return left;
	}


	public void setLeft(BstNode left) {
		this.left = left;
	}

}
