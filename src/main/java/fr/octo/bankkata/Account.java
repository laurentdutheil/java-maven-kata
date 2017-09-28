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
}
