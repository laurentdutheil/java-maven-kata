package fr.octo.bankkata;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;

public class TransactionPrinter {
    private Console console;
    DecimalFormat decimalFormat = new DecimalFormat("#.00", new DecimalFormatSymbols(Locale.ENGLISH));

    public TransactionPrinter(Console console) {
        this.console = console;
    }

    public void print(List<Transaction> transactions) {
        console.print("DATE | AMOUNT | BALANCE");

        int totalAmount = 0;
        Stack<String> printedTransactions = calculateBalancesAndFormat(transactions, totalAmount);

        while (printedTransactions.size() > 0) {
            String printedTransaction = printedTransactions.pop();
            console.print(printedTransaction);
        }
    }

    private Stack<String> calculateBalancesAndFormat(List<Transaction> transactions, int totalAmount) {
        Stack<String> printedTransactions = new Stack<>();
        for (Transaction transaction : transactions) {
            totalAmount += transaction.getAmount();
            printedTransactions.push(transaction.getDate()
                    + " | " + decimalFormat.format(transaction.getAmount())
                    + " | " + decimalFormat.format(totalAmount));
        }
        return printedTransactions;
    }
}
