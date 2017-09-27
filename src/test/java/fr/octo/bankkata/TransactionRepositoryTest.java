package fr.octo.bankkata;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class TransactionRepositoryTest {
    @Mock
    private Clock clock;
    private TransactionRepository transactionRepository;

    @Before
    public void setUp() throws Exception {
        transactionRepository = new TransactionRepository(clock);
    }

    @Test
    public void should_store_deposit() {
        // given
        given(clock.currentDate()).willReturn("01/04/2010");
        Transaction expectedTransaction = new Transaction(100, "01/04/2010");
        List<Transaction> transactions = transactionRepository.getTransactions();
        assertThat(transactions).isEmpty();

        // when
        transactionRepository.deposit(100);

        // then
        transactions = transactionRepository.getTransactions();
        assertThat(transactions).containsExactly(expectedTransaction);
    }

    @Test
    public void should_store_withdraw() {
        // given
        given(clock.currentDate()).willReturn("01/04/2010");
        Transaction expectedTransaction = new Transaction(-100, "01/04/2010");
        List<Transaction> transactions = transactionRepository.getTransactions();
        assertThat(transactions).isEmpty();

        // when
        transactionRepository.withdraw(100);

        // then
        transactions = transactionRepository.getTransactions();
        assertThat(transactions).containsExactly(expectedTransaction);
    }
}