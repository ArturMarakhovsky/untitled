package practice08;



class BankAccount {
    private String iban;
    private String ownerName;
    protected double balance;

    public BankAccount(String iban, String ownerName, double initialBalance) {
        this.iban = iban;
        this.ownerName = ownerName;
        this.balance = Math.max(0.0, initialBalance);
    }

    public String getIban() {
        return iban;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }

        System.out.println("Недостатньо коштів.");
        return false;
    }

    @Override
    public String toString() {
        return "Рахунок[" + iban +
                " | Власник: " + ownerName +
                " | Баланс: " + balance + " грн]";
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;
    private double minBalance;

    public SavingsAccount(String iban,
                          String ownerName,
                          double initialBalance,
                          double interestRate,
                          double minBalance) {
        super(iban, ownerName, initialBalance);
        this.interestRate = interestRate;
        this.minBalance = minBalance;
    }

    @Override
    public boolean withdraw(double amount) {
        if (balance - amount >= minBalance) {
            return super.withdraw(amount);
        }

        System.out.println(
                "ВІДМОВА: незнижуваний залишок " +
                        minBalance +
                        " грн буде порушено."
        );

        return false;
    }

    public void applyInterest() {
        double income = balance * (interestRate / 100.0);
        deposit(income);
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                super.toString() +
                ", Ставка: " + interestRate + "%" +
                ", Мін.залишок: " + minBalance +
                " грн}";
    }
}

class CreditAccount extends BankAccount {
    private double creditLimit;
    private double feePercent;

    public CreditAccount(String iban,
                         String ownerName,
                         double initialBalance,
                         double creditLimit,
                         double feePercent) {
        super(iban, ownerName, initialBalance);
        this.creditLimit = creditLimit;
        this.feePercent = feePercent;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            return false;
        }

        if (balance >= amount) {
            return super.withdraw(amount);
        }

        double borrowed = amount - Math.max(0.0, balance);
        double fee = borrowed * (feePercent / 100.0);

        double newBalance = balance - amount - fee;

        if (newBalance >= -creditLimit) {
            balance = newBalance;
            return true;
        }

        System.out.println("ВІДМОВА: перевищено кредитний ліміт.");
        return false;
    }

    public double getCurrentDebt() {
        return balance < 0 ? Math.abs(balance) : 0.0;
    }

    @Override
    public String toString() {
        return "CreditAccount{" +
                super.toString() +
                ", Ліміт: " + creditLimit +
                " грн, Борг: " + getCurrentDebt() +
                " грн}";
    }
}

public class Task2BankingHierarchy {
    public static void main(String[] args) {

        System.out.println("=============== БАНКІВСЬКА ІЄРАРХІЯ РАХУНКІВ ================");

        SavingsAccount savings = new SavingsAccount(
                "UA101",
                "Олена Коваль",
                5000,
                12.0,
                1000
        );

        System.out.println("1. Ощадний рахунок (початковий стан):");
        System.out.println(savings);

        System.out.print("-> Спроба зняти 4500 грн: ");
        savings.withdraw(4500);

        System.out.println("-> Нарахування річних відсотків (+12%)...");
        savings.applyInterest();
        System.out.println(savings);

        CreditAccount credit = new CreditAccount(
                "UA202",
                "Максим Бондар",
                2000,
                10000,
                2.0
        );

        System.out.println("2. Кредитний рахунок (початковий стан):");
        System.out.println(credit);

        System.out.print("-> Покупка на 5000 грн... ");

        if (credit.withdraw(5000)) {
            System.out.println("УСПІШНО!");
        }

        System.out.println(credit);

        System.out.println("=============================================================");
    }
}
