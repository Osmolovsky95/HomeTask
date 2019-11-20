package homeTaskTen.banking.Comparators;

import homeTaskTen.banking.Bank;

import java.util.Comparator;

public class BankMoneyComparator implements Comparator<Bank> {
    @Override
    public int compare(Bank bank, Bank t1) {
        if(bank.getComissionAmount().doubleValue()>t1.getComissionAmount().doubleValue()){
            return 1;
        }
        if(bank.getComissionAmount().doubleValue()<t1.getComissionAmount().doubleValue()){
            return -1;
        }
        return 0;
    }
}
