public class Driver {
	private static void displayMenu(){
		System.out.println("\nSelect one of the following options:\n"
				+ "1. Make a deposit\n"
				+ "2. Make a withdrawal\n"
				+ "3. Display balance\n"
				+ "4. Monthly process\n"
				+ "5. Exit\n"
				);
	}
	
	public static void main(String[] args) {
		InputHandler inputHandler = new InputHandler();
		
		double startBalance = 0;
		double annualInterestRate = 0;
		
		System.out.println("Welcome to the COP2800 Official Bank\n");
		
		System.out.println("Enter your starting balance:");
		startBalance = inputHandler.getNextDouble();
		
		while(startBalance < 25){
			System.out.println("Starting balance must be greater than $25, please try again:");
			startBalance = inputHandler.getNextDouble();
		}
		
		System.out.println("Enter your annual interest rate:");
		annualInterestRate = inputHandler.getNextDouble();
		
		SavingsAccount account = new SavingsAccount(startBalance, annualInterestRate);	
		System.out.println("\nYour new account has been created with a starting balance of"
				+ " $"
				+ startBalance
				+ " and an interest rate of "
				+ annualInterestRate
				+ "%"
				);
		
		//
		
		int choice;
		
		displayMenu();
		choice = inputHandler.getNextInt();
		
		while(choice != 5){
			if(choice > 0 && choice < 6){
				switch(choice){
				case 1:
					System.out.println("Enter the amount to deposit:");
					double depositAmount = inputHandler.getNextDouble();	
					
					if(depositAmount + account.getBalance() < account.getMinimumBalance()){
						System.out.println("Your account is currently inactive, "
								+ "your balance must be above $"
								+ String.format("%.2f", account.getMinimumBalance()) 
								+ " for your account to be active"
								);
						
						System.out.println("Your balance is: $"
								+ String.format("%.2f", account.getBalance()) 
								+ ", make a deposit of at least $"
								+ String.format("%.2f", account.getMinimumBalance() - account.getBalance())
								+ " to reinstate your account"
								);
					} else {
						account.deposit(depositAmount);
						
						System.out.println("You have deposited $"
								+ String.format("%.2f", depositAmount) 
								+ ", your balance is: $"
								+ String.format("%.2f", account.getBalance()) 
								);
					}
					
					break;
				case 2:
					if(account.getActive() == true){
						System.out.println("Enter the amount to withdraw:");
						
						double withdrawAmount = inputHandler.getNextDouble();				
						account.withdraw(withdrawAmount);
						
						System.out.println("You have withdrawn $"
								+ String.format("%.2f", withdrawAmount) 
								+ ", your balance is: $"
								+ String.format("%.2f", account.getBalance()) 
								);
						
						account.activeCheck();
					} else {
						System.out.println("Your account is currently inactive, "
								+ "your balance must be above $"
								+ String.format("%.2f", account.getMinimumBalance()) 
								+ " for your account to be active"
								);
						
						System.out.println("Your balance is: $"
								+ String.format("%.2f", account.getBalance()) 
								);
					}
					
					break;
				case 3:
					System.out.println("Your account is currently "
							+ account.getActiveString()
							+ " and your balance is: $"
							+ String.format("%.2f", account.getBalance()) 
							);
					break;
				case 4:
					double[] infoArray = account.monthlyProcess();
					
					System.out.println("You paid a monthly service fee of: "
							+ "$"
							+ infoArray[0]
							+ "\n"
							+ "Balance gained from monthly interest: "
							+ "$"
							+ String.format("%.2f", infoArray[1])	
							);
					
					account.activeCheck();
					break;
				}
				
			} else {
				System.out.println("Invalid selection, try again");
			}
			
			displayMenu();
			choice = inputHandler.getNextInt();
		}
		
		System.out.println("Thank you for choosing COP2800 Official Bank");
		inputHandler.close();
	}
}
