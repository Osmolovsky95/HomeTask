package homeTaskTen.banking;

import java.math.BigDecimal;

public class Account {
    private final String id;
    private BigDecimal balance=new BigDecimal(0);
    private Currency currency;


    public Account(String id, Currency currency) {
        this.id = id;

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
