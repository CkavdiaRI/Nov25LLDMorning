package Module2.Adapter;

interface BankAPI1 {
    void deposit(double amount);
    double getBalance();
}

class HDFCBank1 implements BankAPI1 {
    @Override
    public void deposit(double amount) {
        System.out.println("Deposited " + amount + " in HDFC Bank.");
    }

    @Override
    public double getBalance() {
        return 1500.0; // Example balance
    }
}

class SBIBank1 implements BankAPI1 {
    @Override
    public void deposit(double amount) {
        System.out.println("Deposited " + amount + " in SBI Bank.");
    }

    @Override
    public double getBalance() {
        return 2500.0; // Example balance
    }
}

class PhonePe{
    void pay(BankAPI1 bankAPI, double amount) {
        bankAPI.deposit(amount);
        System.out.println("Payment of " + amount + " made using PhonePe.");
    }
}

public class Sol1 {
    public static void main(String[] args) {
        BankAPI1 HDFCbankAPI = new HDFCBank1();
        PhonePe phonePe = new PhonePe();
        phonePe.pay(HDFCbankAPI, 500.0);
    }
}


// What if a new bank does not follow the same API structure?