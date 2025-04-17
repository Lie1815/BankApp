package BankApp;

abstract class Client {
    private String fullname;
    private Account account;
    private ClientType type;

    public String getFullname() {
        return fullname;
    }

    public Account getAccount() {
        return account;
    }

    public ClientType getType() {
        return type;
    }

    public Client(String fullname, String accountNumber, double balance,  ClientType type) {
        this.fullname = fullname;
        this.account = new Account(accountNumber, balance);
        this.type = type;
    }

    public abstract void applyMonthlyFee();

    public abstract double calculateCashback(double amount);

    enum ClientType {
        BASE, PREMIUM, VIP
    }



    @Override
    public String toString() {
        return "Client{" +
                "fullName='" + fullname + '\'' +
                ", account=" + account +
                ", type=" + type +
                '}';
    }
}