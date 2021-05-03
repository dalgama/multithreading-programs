public class primeNumbers implements Runnable {

	int userInput;
	/* Constructor */
	primeNumbers (int userInput) {
		this.userInput = userInput;
	}

	public void run(){
		// Empty String to store Prime numbers
		String  pNumbers = "";
		for (int i = 1; i <= userInput; i++) {
			int counter = 0;
			for(int num = i; num>=1; num--){
				if(i%num==0) {
					counter = counter + 1;
				}
			}
			if (counter == 2) {
				//Appending the Prime number to the String storing the prime numbers.
				pNumbers = pNumbers + i + " ";
			}
		}	
       	System.out.println("---------------------------------------");
       	System.out.print("Thread ID: ");
       	System.out.printf("%d%n",Thread.currentThread().getId());
       	System.out.println("Prime numbers from 1 to "+userInput+" are : "+pNumbers);
       	System.out.println("---------------------------------------");
    }
}
