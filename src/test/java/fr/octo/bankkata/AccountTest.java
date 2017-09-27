package fr.octo.bankkata;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {
    @Mock
    private TransactionRepository transactionRepository;
    @Mock
    private TransactionPrinter transactionPrinter;
    private Account account;

    @Before
    public void setUp() throws Exception {
        account = new Account(transactionRepository, transactionPrinter);
    }

    @Test
    public void deposit_should_add_record_in_repository() {
        // given
        int amount = 100;

        // when
        account.deposit(amount);

        // then
        verify(transactionRepository).deposit(amount);
    }

    @Test
    public void withdraw_should_add_record_in_repository() {
        // given
        int amount = 100;

        // when
        account.withdraw(amount);

        // then
        verify(transactionRepository).withdraw(amount);
    }

    @Test
    public void should_print_statements() {
        // given
        List<Transaction> transactions = new ArrayList<>();
        given(transactionRepository.getTransactions()).willReturn(transactions);

        // when
        account.printStatement();

        // then
        verify(transactionPrinter).print(transactions);
    }
}