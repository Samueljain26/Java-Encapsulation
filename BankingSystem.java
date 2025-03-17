// Main class
public class BankingSystem {
    public static void main(String[] args) {
        BankAccount savings = new SavingsAccount(101, "Alice", 5000);
        BankAccount current = new CurrentAccount(102, "Bob", 10000);

        savings.deposit(2000);
        savings.withdraw(1000);
        System.out.println("Interest: " + savings.calculateInterest());

        current.deposit(5000);
        current.withdraw(3000);
        System.out.println("Interest: " + current.calculateInterest());

        System.out.println("Loan Eligibility (Savings): " + savings.calculateLoanEligibility());
        System.out.println("Loan Eligibility (Current): " + current.calculateLoanEligibility());
    }
}

// Abstract class
abstract class BankAccount implements Loanable {
    private int accountNumber;
    private String holderName;
    private double balance;

    BankAccount(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }

    abstract double calculateInterest();
}

// Interface
interface Loanable {
    double calculateLoanEligibility();
}

// Subclass
class SavingsAccount extends BankAccount {
    SavingsAccount(int accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    double calculateInterest() {
        return getBalance() * 0.04;
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 5;
    }
}

// Subclass
class CurrentAccount extends BankAccount {
    CurrentAccount(int accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    double calculateInterest() {
        return getBalance() * 0.02;
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 3;
    }
}
/*Interest: 240.0
Interest: 240.0
Loan Eligibility (Savings): 30000.0
Loan Eligibility (Current): 36000.0

 */