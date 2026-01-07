package Module2.Adapter;

interface BankAPI2 {
    void deposit(double amount);
    double getBalance();
}

class HDFCBank2 implements BankAPI2 {
    @Override
    public void deposit(double amount) {
        System.out.println("Deposited " + amount + " in HDFC Bank.");
    }

    @Override
    public double getBalance() {
        return 1500.0; // Example balance
    }
}

class SBIBank2 implements BankAPI2 {
    @Override
    public void deposit(double amount) {
        System.out.println("Deposited " + amount + " in SBI Bank.");
    }

    @Override
    public double getBalance() {
        return 2500.0; // Example balance
    }
}

// Different bank with incompatible API
class ICICBank2{
    public void makeDeposit(double amount){}
    public void checkBalance() {}
}

class PhonePe2 {

    void pay(Object bankAPI, double amount){
        if (bankAPI instanceof ICICBank2) {
            ((ICICBank2) bankAPI).makeDeposit(amount);
            System.out.println("Payment of " + amount + " made using PhonePe with ICICI Bank.");
        } else if (bankAPI instanceof BankAPI2) {
            ((HDFCBank2) bankAPI).deposit(amount);
            System.out.println("Payment of " + amount + " made using PhonePe with HDFC Bank.");
        } else {
            System.out.println("Unsupported bank API.");
        }
    }
}

public class Sol2 {
    public static void main(String[] args) {
        BankAPI2 hdfcBank = new HDFCBank2();
        PhonePe2 phonePeHDFC = new PhonePe2();
        phonePeHDFC.pay(hdfcBank, 500.0);
        System.out.println("HDFC Balance: " + hdfcBank.getBalance());

        BankAPI2 icicBank = new SBIBank2();
        PhonePe2 phonePeSBI = new PhonePe2();
        phonePeSBI.pay(icicBank, 300.0);
        System.out.println("SBI Balance: " + icicBank.getBalance());
    }
}
