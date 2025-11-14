package Module1.IntroToOOP;

public class BankAccount {
    //attributes
    String ownerName;
    double balance;

    //Methods
    void deposit(double amount){
       if(amount>0){
           balance += amount;
           System.out.println("Deposited amount " + amount + ". Updated balance is "+balance);
       }else{
           System.out.println("Amount can't be negative");
       }
    }

    void withdrawal(double amount){
        if(amount<=balance){
            balance -= amount;
            System.out.println("Withdrawn amount " + amount + ". Updated balance is "+balance);
        }else{
            System.out.println("Not enough balance");
        }
    }
}
