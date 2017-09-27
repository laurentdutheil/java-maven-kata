package fr.octo.bankkata;

import java.util.List;

public class Account {
    private TransactionRepository transactionRepository;
    private TransactionPrinter transactionPrinter;

    public Account(TransactionRepository transactionRepository, TransactionPrinter transactionPrinter) {
        this.transactionRepository = transactionRepository;
        this.transactionPrinter = transactionPrinter;
    }

    public void deposit(int amount) {
        transactionRepository.deposit(amount);
    }

    public void withdraw(int amount) {
        transactionRepository.withdraw(amount);
    }

    public void printStatement() {
        List<Transaction> transactions = transactionRepository.getTransactions();
        transactionPrinter.print(transactions);
    }

    public static void main(String[] args) {
        Clock clock = new Clock();
        TransactionRepository transactionRepository = new TransactionRepository(clock);
        Console console = new Console();
        TransactionPrinter transactionPrinter = new TransactionPrinter(console);
        Account account = new Account(transactionRepository, transactionPrinter);

        account.deposit(1000);
        account.withdraw(100);
        account.deposit(500);

        account.printStatement();
    }
}
