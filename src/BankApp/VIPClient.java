package BankApp;

public class VIPClient extends Client {
    private static final double LOW_CASHBACK_THRESHOLD = 10000;
    private static final double HIGH_CASHBACK_THRESHOLD = 100000;
    private static final double LOW_CASHBACK_RATE = 0.01;
    private static final double MID_CASHBACK_RATE = 0.05;
    private static final double HIGH_CASHBACK_RATE = 0.10;


    public VIPClient(String fullName, String accountNumber, double balance) {
        super(fullName, accountNumber, balance, ClientType.VIP);
    }

    @Override
    public void applyMonthlyFee() {
    }
    @Override
    public double calculateCashback(double amount) {
        if (amount >= HIGH_CASHBACK_THRESHOLD) {
            return amount * HIGH_CASHBACK_RATE;
        } else if (amount >= LOW_CASHBACK_THRESHOLD) {
            return amount * MID_CASHBACK_RATE;
        } else {
            return amount * LOW_CASHBACK_RATE;
        }
    }
}