package bank;

public class Bst {

	private static BstNode root;
	private static int size;
	
	public Bst() {
		root = null;
		size = 0;
	}

	public static BstNode getRoot() {
		return root;
	}

	public int getSize() {
		return size;
	}
	
	public static boolean insert(String acName, long acIban) {
		if (root == null)
			root = new BstNode(acName, acIban);
		else {
			BstNode parent = null;
			BstNode current = root;
			
			while (current != null) {
				if (acIban < current.acIban) {//if acIban were private in BstNode: current.getIban()
					parent = current;
					current = current.getLeft();
				}
				else if (acIban > current.acIban) {
					parent = current;
					current = current.getRight();
				}
				else
					return false;//duplicate iban values are not allowed
			}
			if (acIban < parent.acIban)
				parent.setLeft(new BstNode(acName, acIban));
			else
				parent.setRight(new BstNode(acName, acIban));
		}
		size++;
		return true;
	}
	
	
	
	
	//traversal of the tree
	public static void inorder (BstNode root) {
		if (root == null)
			return;
		inorder(root.getLeft());
		System.out.println("Iban: " + root.acIban + "\t Name: " + root.acName);
		inorder(root.getRight());
	}
	
	//Return true if the element is deleted successfully
	public static boolean delete(long acIban) {
		BstNode parent = null;
		BstNode current = root;
		
		while(current != null) {
			if (acIban < current.acIban) {
				parent = current;
				current = current.getLeft();
			}
			else if (acIban > current.acIban) {
				parent = current;
				current = current.getRight();
			}
			else
				break; //iban to be deleted is in the current node
		}
		if (current == null)
			return false;
		//case 1: if the current node to be deleted has no left child
		if (current.getLeft() == null) {
			if (parent == null)
				root = current.getRight();
			else {
				if (acIban < parent.acIban)
					parent.setLeft(current.getRight());
				else
					parent.setRight(current.getRight());
			}
		}
		//case 2: current node has left child
		else {
			BstNode parentOfRightMost = current;
			BstNode rightMost = current.getLeft();
			
			while (rightMost.getRight() != null) {
				parentOfRightMost= rightMost;
				rightMost= rightMost.getRight();
			}
			current.acIban = rightMost.acIban;
			if (parentOfRightMost.getRight() == rightMost)
				parentOfRightMost.setRight(rightMost.getLeft());
			else
				parentOfRightMost.setLeft(rightMost.getLeft()); 
		}
		size--;
		return true;	
	}
	
	//returns true if acIban is not founded
	public static boolean search(long acIban) {
		BstNode current = root;
		while(current != null) {
			if(acIban < current.acIban)
				current = current.getLeft();
			else if (acIban > current.acIban)
				current = current.getRight();
			else //acIban matches current.acIban
				return true;
		}
		return false;
	}
	
	public static boolean acceptMoney(long iban, int amount) {
		BstNode current = root;
		while(current != null) {
			if(iban < current.acIban) 
				current = current.getLeft();
			else if (iban > current.acIban) 
				current = current.getRight();
			else {
				current.total += amount;
				break;
			}
		}
		return true;
	}
	
	public static BstNode getAccount(long acIban) {
		BstNode current = root;
		while(current != null) {
			if(acIban < current.acIban)
				current = current.getLeft();
			else if (acIban > current.acIban)
				current = current.getRight();
			else //acIban matches current.acIban
				return current;
		}
		return null;
	}

	
}
