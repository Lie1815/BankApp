package BankApp;

import java.sql.SQLException;
import java.util.Scanner;

public class Account {
    private String accountNumber;
    private static double balance;

    private DB db;



    public Account(String accountNumber, double balance) {
        this.db = db;
        this.accountNumber = accountNumber;

    }






    public void transferMoney(Account sender, int recipient, double amount) throws SQLException, ClassNotFoundException {
        System.out.println("from trtansfder money " + balance);


        Scanner scanner = new Scanner(System.in);




    }

    public void addToBalance(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("должно быть больше нуля");
        }
        this.balance += amount;

    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("должно быть больше нуля");
        }
        this.balance -= amount;
    }
    public static void payService(Client client, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("должно быть больше нуля");
        }
        client.getAccount().withdraw(amount);
        if (client.getAccount().getBalance() == 1000) {
            client.getAccount().addToBalance(1000);
            System.out.println("бонус зачислен");
        }
        double cashbackAmount = client.calculateCashback(amount);
        client.getAccount().addToBalance(cashbackAmount);
    }

    public static double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
