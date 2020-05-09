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
