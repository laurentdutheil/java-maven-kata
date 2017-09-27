package fr.octo.bankkata;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TransactionPrinterTest {
    @Mock
    private Console console;
    private TransactionPrinter transactionPrinter;

    @Before
    public void setUp() throws Exception {
        transactionPrinter = new TransactionPrinter(console);
    }

    @Test
    public void should_print_header_when_no_transactions() {
        // given

        // when
        transactionPrinter.print(new ArrayList<>());

        // then
        verify(console).print("DATE | AMOUNT | BALANCE");
    }

    @Test
    public void should_print_transactions() {
        // given
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(1000, "01/04/2014"));
        transactions.add(new Transaction(-100, "02/04/2014"));
        transactions.add(new Transaction(500, "10/04/2014"));

        // when
        transactionPrinter.print(transactions);

        // then
        InOrder inOrder = Mockito.inOrder(console);
        inOrder.verify(console).print("DATE | AMOUNT | BALANCE");
        inOrder.verify(console).print("10/04/2014 | 500.00 | 1400.00");
        inOrder.verify(console).print("02/04/2014 | -100.00 | 900.00");
        inOrder.verify(console).print("01/04/2014 | 1000.00 | 1000.00");
    }

}