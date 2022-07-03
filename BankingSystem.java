package bank;

import java.util.Scanner;
import bank.Bst;

public class BankingSystem extends BstNode {
	
	Scanner sc = new Scanner(System.in);
	
	private LinkedListNode head;
	
	public BankingSystem(String acName, long acIban) {
		super(acName, acIban);
		head = null;
		
		if (!Bst.search(acIban)) { //if the iban is not used before.
			Bst.insert(acName, acIban);
		}
		else
			System.out.println("consider to take another iban. The iban number "+ acIban + " is already being used by another customer");
	}
	
	//to add new iban
	public void addIban(String name, long iban) {
		
		if(this.acIban != iban) {
			
			if (Bst.search(iban))//if the iban is recorded as an account
				if(doesContain(name, iban)){//if this is true, which means if the iban has not previously recorded
					head = new LinkedListNode(name, iban, head);
				}
				else {
					System.out.println("this customer has already been added to the list");
				}
			else {
				System.out.println("this account which has " + iban + " iban number does not exist. "
						+ "Thus, you cannot add this iban to your favorite iban list");
			}
		}
		else
			System.out.println("you cannot add yourself to your favorite iban list");
	}
	
	//to check whether the customer has already been recorded
	public boolean doesContain(String name, long iban) {
		LinkedListNode position = head;
		while(position != null) {
			if(position.getIban() == iban && position.getName().equals(name))/////
				return false;
			position = position.getLink();
		}
		return true;
	}
	//to display all the names and ibans that have been recorded to the list
	public void displayIbans() {
		LinkedListNode position = head;
		while(position != null) {
			System.out.println("Name: " + position.getName() + " Iban: " + position.getIban());
			position = position.getLink();
		}
	}
	
	public void deposit(int amount) {
		if(amount >= 0)
			Bst.getAccount(acIban).total +=amount;
		else
			System.out.println("please enter a valid number to deposit");
	}

	public void withdraw(int amount) {
		if(amount > Bst.getAccount(acIban).total)
			System.out.println("you cannot withdraw "+ amount + "₺ since you have only " + Bst.getAccount(acIban).total + "₺");
		else
			Bst.getAccount(acIban).total -= amount;
	}
	
	public void displayInfo() {
		System.out.println("Name: " + acName + " Iban: " + acIban + " total money: " + Bst.getAccount(acIban).total);//Bst.getAccount(acIban).total
	}
	
	
	
	
	public boolean transfer(String name, long iban, int amount) {
		if (this.acName.equals(name) && this.acIban == iban) {
			System.out.println("you cannot transfer money to yourself");
			return false;
		}
		if (Bst.search(iban)) {//if the other account exists
			if(amount > Bst.getAccount(acIban).total) {
				System.out.println("there is no enough money on your account");
				return false;
			}
			else {
				Bst.getAccount(acIban).total -= amount;
				Bst.acceptMoney(iban, amount);//returns true 
				return true;
			}
		}
		else {
			System.out.println("the account that you want to transfer money does not exist");
			return false;
		}
	}
	
	public void deleteAcc() {
		Bst.delete(super.acIban);
	}
	
	public static void displayAllAcc() {
		Bst.inorder(Bst.getRoot());
	}
	
}
