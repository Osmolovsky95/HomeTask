package homeTaskTen.banking.Comparators;

import homeTaskTen.banking.Bank;

import java.util.Comparator;

public class BankCountOperationComparator implements Comparator<Bank> {

    @Override
    public int compare(Bank bank, Bank t1) {
        if(bank.getOperationCount().intValue()>t1.getOperationCount().intValue()){
            return 1;
        }
        if(bank.getOperationCount().intValue()<t1.getOperationCount().intValue()){
            return -1;
        }
        return 0;
    }
}
