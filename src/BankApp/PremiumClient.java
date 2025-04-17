package BankApp;

public class PremiumClient extends Client {
    private static final double CASHBACK_THRESHOLD = 10000 ;
    private static final double CASHBACK_RATE = 0.01;

    public PremiumClient(String fullName, String accountNumber, double balance) {
        super(fullName, accountNumber, balance, ClientType.PREMIUM);
    }
    @Override
    public void applyMonthlyFee() {

    }
    @Override
    public double calculateCashback(double amount) {
        if (amount >= CASHBACK_THRESHOLD) {
            return amount * CASHBACK_RATE;
        }
        return 0;
    }
}