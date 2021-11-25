package step3.model;

public class Money {

    private static final int LOTTO_PRICE = 1000;
    private static final String RANGE_VIOLATION_ERROR_MESSAGE = "돈은 양수여야 합니다";
    private static final int MIN = 0;

    public static Money fromLottoBundleSize(int bundleSize) {
        return new Money(LOTTO_PRICE * bundleSize);
    }

    private int money;

    public Money(int money) {
        checkPositive(money);
        this.money = money;
    }

    private void checkPositive(int money) {
        if (money < MIN) {
            throw new IllegalArgumentException(RANGE_VIOLATION_ERROR_MESSAGE);
        }
    }

    public boolean canPurchase() {
        return money >= LOTTO_PRICE;
    }

    public void purchase() {
        money -= LOTTO_PRICE;
    }

    public boolean isUnableToYield() {
        return money == 0;
    }

    public int won() {
        return money;
    }

    public void add(long money) {
        this.money += money;
    }
}
