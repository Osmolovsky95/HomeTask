package homeTaskTen.banking;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BankingApp {

    public static void main(String[] args) {
        Bank bank = new Bank("BankOfAmerica");

        Person person1 = new Person("MP255_____1", "Илья");
        Person person2 = new Person("MP255_____2", "Игорь");
        Person person3 = new Person("MP255_____3", "Света");

        List<Account> accounts = person1.getAccounts();
        List<Account> accountsPerson2 = person2.getAccounts();

        accounts.add(bank.createAccountForPerson(person1, new BigDecimal(100000)));
        accounts.add(bank.createAccountForPerson(person1, new BigDecimal(100000)));

        accountsPerson2.add(bank.createAccountForPerson(person2, new BigDecimal(100000)));
        accountsPerson2.add(bank.createAccountForPerson(person2, new BigDecimal(100000)));

        Account account1 = accounts.get(0);
        Account account2 = accounts.get(1);

        Account account3 = accountsPerson2.get(0);
        Account account4 = accountsPerson2.get(1);


        Thread t1 = new Thread(new TransferTread(account1, account2, bank));
        Thread t2 = new Thread(new TransferTread(account1, account2, bank));
        Thread t3 = new Thread(new TransferTread(account1, account2, bank));
        Thread t4 = new Thread(new TransferTread(account1, account2, bank));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        System.out.println(bank);
        bank.delClient(person1);
        bank.transfer(accounts.get(0).getId(), accounts.get(1).getId(), new BigDecimal(54));


        bank.transfer(account2.getId(), account1.getId(), new BigDecimal(5000));
        System.out.println("Баланс аккаунта 3 = " + account2.getBalance());
        System.out.println("Баланс аккаунта 1 = " + account1.getBalance());
        System.out.println("Денег в банке " + bank.getComissionAmount());

        System.out.println("Количество операций " + bank.getOperationCount());
        bank.transfer(account2.getId(), account1.getId(), new BigDecimal(50));
        System.out.println("Баланс аккаунта 3 = " + account2.getBalance());
        System.out.println("Баланс аккаунта 1 = " + account1.getBalance());
        System.out.println("Денег в банке " + bank.getComissionAmount());
        System.out.println("Банк провел " + bank.getOperationCount() + " операций");

        bank.transfer(account1.getId(), account3.getId(), new BigDecimal(5000));
        System.out.println("Баланс аккаунта 3 = " + account1.getBalance());
        System.out.println("Баланс аккаунта 1 = " + account3.getBalance());
        System.out.println("Денег в банке " + bank.getComissionAmount());
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            double avg = (account1.getBalance().doubleValue() + account2.getBalance().doubleValue()) / 2;
            System.out.println("Acc1 " + account1.getBalance());
            System.out.println("Acc2 " + account2.getBalance());
            System.out.println("AVG " + avg);
        }
    }

    private static class TransferTread implements Runnable {
        private final Account account1;
        private final Account account2;
        private final Bank bank;
        private Random rnd = new Random();

        private TransferTread(Account account1, Account account2, Bank bank) {
            this.account1 = account1;
            this.account2 = account2;
            this.bank = bank;
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                Account acc1 = rnd.nextBoolean() ? account1 : account2;
                Account acc2 = acc1.equals(account1) ? account2 : account1;

                bank.transfer(acc1.getId(), acc2.getId(), new BigDecimal(rnd.nextDouble()).round(new MathContext(2, RoundingMode.DOWN)));
            }
        }
    }
}




