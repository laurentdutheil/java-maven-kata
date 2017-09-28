package fr.octo.bankkata;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TransactionPrinter {
    private Console console;
    DecimalFormat decimalFormat = new DecimalFormat("#.00", new DecimalFormatSymbols(Locale.ENGLISH));

    public TransactionPrinter(Console console) {
        this.console = console;
    }

    public void print(List<Transaction> transactions) {
        console.print("DATE | AMOUNT | BALANCE");

        AtomicInteger totalAmount = new AtomicInteger(0);
        transactions.stream()
                .map(transaction -> formatTransaction(transaction, totalAmount))
                .collect(Collectors.toCollection(LinkedList::new))
                .descendingIterator()
                .forEachRemaining(console::print);
    }

    private String formatTransaction(Transaction transaction, AtomicInteger totalAmount) {
        return transaction.getDate()
                + " | " + decimalFormat.format(transaction.getAmount())
                + " | " + decimalFormat.format(totalAmount.addAndGet(transaction.getAmount()));
    }

}
