public abstract class BankAccount {
	private double balance;
	private double annualInterestRate;

	private int deposits = 0;
	private int withdrawals = 0;

	public BankAccount(double balance, double rate){
		this.balance = balance;
		this.annualInterestRate = rate;
	}
	
	public void deposit(double amount){
		balance += amount;
		deposits++;
	}
	
	public void withdraw(double amount){
		balance -= amount;
		withdrawals++;
	}
	
	public double calcInterest(){
		double monthlyInterest = balance * annualInterestRate / 12;
		balance += monthlyInterest;
		
		return monthlyInterest;
	}
	
	public double calcDebt(){
		double serviceDebt = 0;
		
		for(int i = 0; i < withdrawals; i++){
			if(i > 4) {
				serviceDebt++;
			}
		}
		
		deposits = 0;
		withdrawals = 0;
		
		return serviceDebt;
	}
	
	public double getBalance(){
		return balance;
	}
	
	public double getAnnualInterestRate(){
		return annualInterestRate;
	}

	public int getDeposits(){
		return deposits;
	}
	
	public int getWithdrawals(){
		return withdrawals;
	}
}
