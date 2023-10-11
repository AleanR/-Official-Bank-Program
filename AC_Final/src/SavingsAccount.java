public class SavingsAccount extends BankAccount {
	private boolean active = false;
	final private double minimumBalance = 25;
	
	public SavingsAccount(double balance, double rate) {
		super(balance, rate);
		active = true;
	}

	private void activeUpdate(){
		if(getBalance() >= minimumBalance){
			active = true;
		} else {
			active = false;
		}
	}
	
	public void deposit(double amount){
		if (active || amount + getBalance() > minimumBalance){
			super.deposit(amount);
		}
		
		activeUpdate();
	}
	
	public void withdraw(double amount){
		if (active){
			super.withdraw(amount);
		}
		
		activeUpdate();
	}
	
	public double[] monthlyProcess(){
		double monthlyInterest = super.calcInterest();
		double serviceDebt = super.calcDebt();
		
		activeUpdate();
		
		double[] infoArray = {serviceDebt, monthlyInterest};
		return infoArray;
	}
	
	public boolean getActive(){
		return active;
	}
	
	public String getActiveString(){
		return (active == true) ? "active" : "inactive";
	}
	
	public double getMinimumBalance(){
		return minimumBalance;
	}
	
	public void activeCheck(){
		if(getBalance() < minimumBalance){
			System.out.println("Your balance is below "
					+ "$"
					+ minimumBalance
					+ ", your account is "
					+ getActiveString()
					);
		}
	}
}
