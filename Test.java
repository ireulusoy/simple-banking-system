package bank;

public class Test {
	
	public static void main(String[] args) {
		
		
		BankingSystem acc1 = new BankingSystem("güneş", 345);
		BankingSystem acc2 = new BankingSystem("ırmak", 123);
		BankingSystem acc4 = new BankingSystem("ateş", 789);
		BankingSystem acc3 = new BankingSystem("su", 123);
		BankingSystem acc5 = new BankingSystem("as", 45);
		BankingSystem acc6 = new BankingSystem("sd", 56);
		BankingSystem acc7 = new BankingSystem("xs", 9);
		BankingSystem acc20 = new BankingSystem("giver", 100);
		BankingSystem acc25 = new BankingSystem("receiver", 101);
		BankingSystem acc30 = new BankingSystem("heyThere", 109);
		
		BankingSystem.displayAllAcc();
		
		
		
		
		acc7.deleteAcc();
		System.out.println("after deletion");
		BankingSystem.displayAllAcc();
		
		acc1.addIban("güneş", 345);
		acc1.addIban("heyThere", 109);
		acc1.displayIbans();
		acc1.addIban("aa", 12);
		acc1.displayIbans();
		
		acc1.deposit(100);
		acc1.displayInfo();
		acc1.withdraw(50);
		acc1.displayInfo();
		
		acc1.transfer("ırmak", 123, 30);
		acc1.displayInfo();
		acc2.displayInfo();
		acc1.transfer("aa", 00, 20);
		
		
	
		
	}

}
