package 面向对象.OOP习题.test05;

public class test05 {
    public static void main(String[] args) {
        CheckingAccount checkingAccount = new CheckingAccount(1000);
        checkingAccount.deposit(10);
        System.out.println(checkingAccount.getBalance());
        checkingAccount.withdraw(10);
        System.out.println(checkingAccount.getBalance());
        checkingAccount.deposit(10);
        System.out.println(checkingAccount.getBalance());


        SavingsAccount savingsAccount = new SavingsAccount(1000);
        savingsAccount.deposit(10);
        System.out.println(savingsAccount.getBalance());
        savingsAccount.withdraw(10);
        System.out.println(savingsAccount.getBalance());
        savingsAccount.deposit(10);
        System.out.println(savingsAccount.getBalance());
        savingsAccount.withdraw(10);
        System.out.println(savingsAccount.getBalance());

        savingsAccount.earnMonthlyInterest();
        System.out.println(savingsAccount.getBalance());
        savingsAccount.withdraw(10);
        System.out.println(savingsAccount.getBalance());

    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class CheckingAccount extends BankAccount {
    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount - 1);
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount + 1);
    }

}

class SavingsAccount extends BankAccount {
    private int count = 3;
    private double rate = 0.01;

    public SavingsAccount(double initialBalance) {
        super(initialBalance);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public void deposit(double amount) {
        if (count > 0)
            super.deposit(amount);
        else
            super.deposit(amount - 1);
        count--;
    }

    @Override
    public void withdraw(double amount) {
        if (count > 0)
            super.withdraw(amount);
        else
            super.withdraw(amount + 1);
        count--;
    }

    public void earnMonthlyInterest() {
        count = 3;
        super.deposit(getBalance() * rate);

    }

}


