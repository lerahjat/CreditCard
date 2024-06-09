package pl.mglabinski.creditcard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

public class CreditCardTest {

    @Test
    void itAllowsAssignCredit() {
        //Arrange
        var card = new CreditCard();
        //Act
        card.assignCredit(BigDecimal.valueOf(1000));
        //Assert
        assertEquals(
                BigDecimal.valueOf(1000),
                card.getBalance(),
                "Current balance doesn't match expectations"
        );
    }

    @Test
    void itAllowsAssignCreditV2() {
        //Arrange
        var card = new CreditCard();
        //Act
        card.assignCredit(BigDecimal.valueOf(2000));
        //Assert
        assertEquals(
                BigDecimal.valueOf(2000),
                card.getBalance()
        );
    }

    @Test
    void itDenyCreditBelowThresholdV1() {
        var card = new CreditCard();

        try {
            card.assignCredit(BigDecimal.valueOf(50));
            assert false;
        } catch(CreditBelowThresholdException e) {
            assert true;
        }
    }

    @Test
    void itDenyCreditBelowThresholdV2() {
        var card = new CreditCard();
        //python: //lambda x: x + 2
        //java: // (x) -> x + 2
        assertThrows(
                CreditBelowThresholdException.class,
                () -> card.assignCredit(BigDecimal.valueOf(50))
        );
    }

    @Test
    void itDenyModifyingCreditLimit() {
        var card = new CreditCard();
        card.assignCredit(BigDecimal.valueOf(1000));

        assertThrows(
                CreditCantBeReassignedException.class,
                () -> card.assignCredit(BigDecimal.valueOf(1500))
        );
    }

    @Test
    void itAllowToWithdrawSomeMoney() {
        var card = new CreditCard();
        card.assignCredit(BigDecimal.valueOf(1000));

        card.withdraw(BigDecimal.valueOf(500));

        assertEquals(
                BigDecimal.valueOf(500),
                card.getBalance()
        );
    }

    @Test
    void cantReachInsufficientFunds() {
        var card = new CreditCard();
        card.assignCredit(BigDecimal.valueOf(1000));
        card.withdraw(BigDecimal.valueOf(500));

        assertThrows(
                InsufficientFundsException.class,
                () -> card.withdraw(BigDecimal.valueOf(600))
        );
    }
}