package fr.octo.bankkata;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {
    private Clock clock;
    private List<Transaction> transactions = new ArrayList<>();

    public TransactionRepository(Clock clock) {
        this.clock = clock;
    }

    public void deposit(int amount) {
        Transaction transaction = new Transaction(amount, clock.currentDate());
        transactions.add(transaction);
    }

    public void withdraw(int amount) {
        Transaction transaction = new Transaction(-amount, clock.currentDate());
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
