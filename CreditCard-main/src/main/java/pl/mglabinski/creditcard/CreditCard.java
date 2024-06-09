package pl.mglabinski.creditcard;

import java.math.BigDecimal;

public class CreditCard {


    private BigDecimal creditLimit;
    private BigDecimal balance;

    public void assignCredit(BigDecimal creditLimit) {
        if (isCreditAlreadyAssigned()) {
            throw new CreditCantBeReassignedException();
        }
        if (isCreditBelowThreshold(creditLimit)) {
            throw new CreditBelowThresholdException();
        }

        this.creditLimit = creditLimit;
        this.balance = creditLimit;
    }

    private boolean isCreditAlreadyAssigned() {
        return this.creditLimit != null;
    }

    private static boolean isCreditBelowThreshold(BigDecimal creditLimit) {
        return BigDecimal.valueOf(100).compareTo(creditLimit) > 0;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void withdraw(BigDecimal money) {
        if (isNotEnoughMoney(money)) {
            throw new InsufficientFundsException();
        }

        this.balance = balance.subtract(money);
    }

    private boolean isNotEnoughMoney(BigDecimal money) {
        return this.balance.subtract(money).compareTo(BigDecimal.ZERO) < 0;
    }
}
