package homeTaskTen.banking;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Bank implements IBank{
    private final String name;
    private Map<Person, List<Account>> data = new HashMap<>();
    private  BigDecimal comissionAmount=new BigDecimal(0);
    private AtomicInteger operationCount=new AtomicInteger(0);

    public AtomicInteger getOperationCount() {
        return operationCount;
    }

    public BigDecimal getComissionAmount() {
        return comissionAmount;
    }

    public Bank(String name) {
        this.name = name;
    }

    public void addClient(Person p) throws IllegalArgumentException {
        if(!data.containsKey(p)){
            data.put(p, new ArrayList<>());
        } else {
            throw new IllegalArgumentException("Клиент уже имеет счета в банке");
        }
    }

    public Account createAccountForPerson(Person p, BigDecimal startAmount){
        Account account =new Account(UUID.randomUUID().toString(), startAmount);
        addAccount(p, account);

        return account;
    }

    private void addAccount(Person p, Account account) throws IllegalArgumentException {
        try {
            this.addClient(p);
        } catch (IllegalArgumentException ignored){
            //У пользователя уже есть учетка
        }
        //Готово
        //TODO проверить что счета с таким номером в банке больше уже нет
        for (List<Account> list:data.values()){
            for(Account search:list){
                if((search.getId().equals(account.getId()))){
                    System.out.println("Счет с id: "+account.getId()+ "уже есть в банке");
                }
            }
        }
        List<Account> accounts = this.data.get(p);
        accounts.add(account);
    }

    public void delClient(Person p) throws IllegalStateException {
        if(!data.containsKey(p)){
            throw new IllegalArgumentException(String.format("Данный человек не имеет счетов в банке %s", this.name));
        } else {
            //Готово
            //TODO Впилить проверку что нельзя удалить клиента пока у него есть деньги на счету
            BigDecimal balance=new BigDecimal(0);
            for(Account account:p.getAccounts()){
               balance=balance.add(account.getBalance());
            }
            if(balance.doubleValue()>0){
                System.out.println("Нельзя удалить клиеньа "+ p.getName()+" y клиента остались деньги на счету");
            }
            else {
                data.remove(p);
                System.out.println("Клиет "+ p.getName()+" успешно удален");
            }
        }
    }

    public void transfer(final String idFrom, final String idTo, BigDecimal sum) {
        Account accountFrom=null;
        Account accountTo=null;
        List listFrom=null;
        List listTo=null;
        BigDecimal n=new BigDecimal(0);
        for (List<Account> list : data.values()) {
            for (Account search : list) {
                if (search.getId().equals(idFrom)) {
                    accountFrom = search;
                    break;
                }
            }
        }
        for (List<Account> list : data.values()) {
            for (Account search : list) {
                if (search.getId().equals(idTo)) {
                    accountTo = search;
                }
            }
        }
        System.out.println("Готов перевод с аккаунта "+accountFrom.getId()+" на аккаунт "+ accountTo.getId());
        System.out.println("Сумма перевода "+sum);
        for(List<Account> list:data.values()) {
            if (list.contains(accountFrom)) {
                listFrom = list;
            }
            if (list.contains(accountTo)) {
                listTo = list;
            }
        }
        if(listFrom==listTo) {
            synchronized (accountFrom) {
                synchronized (accountTo) {
                    if (accountFrom.getBalance().doubleValue() > sum.doubleValue()) {
                        accountFrom.withdraw(sum);
                        System.out.println("Списание суммы без процента "+ sum);
                        accountTo.deposit(sum);
                        System.out.println("Зачисление суммы "+ sum);
                        operationCount.incrementAndGet();
                    }
                }
            }
        }
        else {
            if((sum.doubleValue()*0.1)<5){
             n.setScale(5);
                comissionAmount=comissionAmount.add(n);
                System.out.println("Списание суммы с процентом "+ (sum.add(n)));
            }
            else {
                 n=sum.multiply(BigDecimal.valueOf(0.01));
                comissionAmount=comissionAmount.add(n);
                System.out.println("Списание суммы с процентом "+(sum.add(n)));
            }
            synchronized (accountFrom) {
                synchronized (accountTo) {
                    if (accountFrom.getBalance().doubleValue() > sum.add(n).doubleValue()) {
                        accountFrom.withdraw(sum.add(n));
                        System.out.println("Списание суммы "+ (sum.add(n)));
                        accountTo.deposit(sum);
                        System.out.println("Зачисление суммы "+ sum);
                        operationCount.incrementAndGet();
                    }

                }
            }
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        int countPersons=0;
        for (List<Account> list:data.values()){
            for(Account account:list){
                countPersons++;
            }
        }
        return "Bank has " + data.size()+" persons and "+countPersons+" accounts";
    }
}

