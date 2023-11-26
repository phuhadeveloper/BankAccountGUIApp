package bankGUI;

public class BankAccount {
	private String firstName;
	private String lastName;
	private int accountID;
	private double balance;
	
	public BankAccount() {
		this.balance = 0;
	}
	
	// getters and setters
	public String getFirstName() {return this.firstName;}
	public String getLastName() {return this.lastName;}
	public int getAccountID() {return this.accountID;}
	public void setFirstName(String firstName) {this.firstName = firstName;}
	public void setLastName(String lastName) {this.lastName = lastName;}
	public void setAccountID(int accountID) {this.accountID = accountID;}
	
	//getBalance
	public double getBalance() {return this.balance;}
	
	// deposit method 
	public String deposit(double amount) {
		if (amount >= 0) {
			this.balance += amount;
			return amount + " was deposited successfully.";
		} else {
			return "Invalid amount";
		}
	};
	
	public String withdraw(double amount) {
		
		if (amount > this.balance) {
			return "Not enough in balance for withdrawal.";
		} else if ( amount < 0) {
			return "Invalid amount!";
		} else {
			balance -= amount;
			return amount + " was withdrawn successfully.";
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
