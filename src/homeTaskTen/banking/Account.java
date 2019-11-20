package homeTaskTen.banking;

import java.io.Serializable;
import java.math.BigDecimal;

public class Account implements Serializable {
    private final String id;
    private BigDecimal balance=new BigDecimal(0);
    private Currency currency=Currency.BLR;


    public Account(String id, Currency currency) {
        this.id = id;
        this.currency=currency;

    }

    public Account(String id, BigDecimal balance) {
        this.id = id;
        this.balance = balance;

    }

    public String getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void deposit(BigDecimal sum){
        this.balance=this.balance.add(sum);
    }

    public void withdraw(BigDecimal sum){
        this.balance=this.balance.subtract(sum) ;
    }
}
