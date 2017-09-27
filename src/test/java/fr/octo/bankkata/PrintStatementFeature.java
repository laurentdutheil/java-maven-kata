package fr.octo.bankkata;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class PrintStatementFeature {
    @Mock
    private Console console;
    @Mock
    private Clock clock;
    private Account account;

    @Before
    public void setUp() throws Exception {
        account = new Account(new TransactionRepository(clock), new TransactionPrinter(console));
    }

    @Test
    public void should_print_statement() {
        // given
        given(clock.currentDate())
                .willReturn("01/04/2014")
                .willReturn("02/04/2014")
                .willReturn("10/04/2014");

        account.deposit(1000);
        account.withdraw(100);
        account.deposit(500);

        // when
        account.printStatement();

        // then
        InOrder inOrder = Mockito.inOrder(console);
        inOrder.verify(console).print("DATE | AMOUNT | BALANCE");
        inOrder.verify(console).print("10/04/2014 | 500.00 | 1400.00");
        inOrder.verify(console).print("02/04/2014 | -100.00 | 900.00");
        inOrder.verify(console).print("01/04/2014 | 1000.00 | 1000.00");    }
}
