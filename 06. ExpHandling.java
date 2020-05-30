/*

Design and implement a Java program for the following requirements:	
a)	An Exception class called Demonetization Exception which returns the statement that says “Deposit of Old currency of 
    (Rs_____) crosses Rs. 5,000 and cannot be deposited”.   
b)	A class called ‘Account’ that creates account with 500 Rs minimum balance with following methods.
	i.	 Deposit (amount, currencyType) method to deposit amount. This class should handle “Demonetization Exception” and print the 
	     message defined in this Exception class. If a currency type is “OLD” and the amount is greater than 5,000 then throw the 
	     Demonetization Exception, otherwise update the balance. 
	ii.	 currBalance() method that displays balance amount in the account.
	iii. withdraw(amount) method to withdraw amount and update the balance. Use proper control structure to check Balance should not 
	     go less than 500.  
c)	A ‘Customer’ class that creates Account object and call the methods deposit(), withdraw() and currBalance() based on the user choice. 

*/

import java.util.Scanner;

class Account {
    double balance;
    void deposit(double amt, String curr) {
        curr = curr.toUpperCase();
        curr = curr.trim();
        try {
        	if (curr.equals("OLD") && amt > 5000)
        		throw new DemonitizationException(amt);
        	else {
        		System.out.println("Depositing Rs."+amt+" in the Account.");
        		balance += amt;
        	}
        }
        catch (DemonitizationException ex) {
        	System.out.println("Message :: "+ex);
        }
    }
    void withdraw(double amt){
        try{
            if(balance-amt < 500){
                throw new DemonitizationException("Account has minimum amount of Rs.500");
            }
            else{
                System.out.println("Withdrawing Rs."+amt+" from your account.");
                balance -= amt;
            }
        }
        catch (DemonitizationException ex){
            System.out.println(ex.getMessage());
        }
    }
    void currBalance(){
        System.out.println("The current balance is Rs."+balance+" only.");
    }
}

class DemonitizationException extends Exception{
    double amount;
    DemonitizationException(double amount){
        this.amount = amount;
    }
    DemonitizationException(String s){
        super(s);
    }
    public String toString(){
        return "Deposit of old currency of Rs."+(int)amount+" crosses Rs.5000 limit";
    }
}

// Main
public class prgm6 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String cont = "yes";
        Account acc = new Account();
        while(true){
            System.out.println("\nMenu::\n1.Deposit\n2.Withdraw\n3.Current Balance\n4.Exit");
            int ch = in.nextInt();
            switch(ch){
                case 1: double amt = in.nextDouble();
                        String curr = in.nextLine();
                        acc.deposit(amt, curr);
                        break;
                case 2: amt = in.nextDouble();
                        acc.withdraw(amt);
                        break;
                case 3: acc.currBalance();
                        break;
                default:System.exit(1);
                		System.out.println("\nInvalid choice");
            }
//            cont = in.nextLine();
//            cont.toLowerCase();
        }
    }
}
