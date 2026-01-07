package Module2.Adapter;

// Adapter Design Pattern
// This code is an example of the Adapter Design Pattern, which allows incompatible interfaces to work together.

interface BankAPI3 {
    void deposit(double amount);
    double getBalance();
}

class HDFCBank3 implements BankAPI3 {
    @Override
    public void deposit(double amount) {
        System.out.println("Deposited " + amount + " in HDFC Bank.");
    }

    @Override
    public double getBalance() {
        return 1500.0; // Example balance
    }
}

class SBIBank3 implements BankAPI3 {
    @Override
    public void deposit(double amount) {
        System.out.println("Deposited " + amount + " in SBI Bank.");
    }

    @Override
    public double getBalance() {
        return 2500.0; // Example balance
    }
}

class ICICBank3 {
    public void makeDeposit(double amount) {
        System.out.println("Deposited " + amount + " in ICICI Bank.");
    }

    public double checkBalance() {
        return 3000.0; // Example balance
    }
}

// Adapter class to adapt ICICBank3 to BankAPI3
class ICICBankAdapter implements BankAPI3 {
    private ICICBank3 icicBank;

    public ICICBankAdapter(ICICBank3 icicBank) {
        this.icicBank = icicBank;
    }

    @Override
    public void deposit(double amount) {
        icicBank.makeDeposit(amount);
    }

    @Override
    public double getBalance() {
        return icicBank.checkBalance();
    }
}

class PhonePe3 {
    void pay(BankAPI3 bankAPI, double amount) {
        bankAPI.deposit(amount);
        System.out.println("Payment of " + amount + " made using PhonePe.");
    }
}

public class Sol3 {
    public static void main(String[] args) {
        BankAPI3 hdfcBank = new HDFCBank3();
        PhonePe3 phonePeHDFC = new PhonePe3();
        phonePeHDFC.pay(hdfcBank, 500.0);
        System.out.println("HDFC Balance: " + hdfcBank.getBalance());

        BankAPI3 sbiBank = new SBIBank3();
        PhonePe3 phonePeSBI = new PhonePe3();
        phonePeSBI.pay(sbiBank, 300.0);
        System.out.println("SBI Balance: " + sbiBank.getBalance());

        ICICBank3 icicBank = new ICICBank3();
        BankAPI3 icicAdapter = new ICICBankAdapter(icicBank);
        PhonePe3 phonePeICICI = new PhonePe3();
        phonePeICICI.pay(icicAdapter, 700.0);
        System.out.println("ICICI Balance: " + icicAdapter.getBalance());
    }
}


// Components of adapter pattern:
// 1. Target Interface: BankAPI3
// 2. Adaptee: ICICBank3
// 3. Adapter: ICICBankAdapter
// 4. Client: PhonePe3