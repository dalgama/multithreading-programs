import java.util.Scanner;
public class q1{
	public static void main(String[] args){

		Scanner myObj = new Scanner(System.in);
    	int userInput;

    	System.out.println("Enter a number: "); 
    	userInput = Integer.parseInt(myObj.nextLine());

    	primeNumbers t1 = new primeNumbers(userInput);

		Thread thread_obj = new Thread(t1);
		thread_obj.start();
	}
}