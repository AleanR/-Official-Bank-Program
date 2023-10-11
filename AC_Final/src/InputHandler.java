import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandler {
	private Scanner scanner;
	
	InputHandler(){
		scanner = new Scanner(System.in);
	}
	
	public int getNextInt(){
		int input = -1;
		
		while(input < 0){
			try {
				input = scanner.nextInt();
			} catch(InputMismatchException Exception) {
				System.out.println("Invalid input, please try again");
				scanner.nextLine();
			} 
		}
		
		return input;
	}
	
	public double getNextDouble(){
		double input = -1;
		
		while(input < 0){
			try {
				input = scanner.nextDouble();
			} catch(InputMismatchException Exception) {
				System.out.println("Invalid input, please try again");
				scanner.nextLine();
			} 
		}
		
		return input;
	}
	
	public void close(){
		scanner.close();
	}
	
}
