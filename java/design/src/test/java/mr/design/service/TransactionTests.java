package mr.design.service;

import mr.design.enums.Status;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.SimpleIdGenerator;

import javax.transaction.InvalidTransactionException;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TransactionTests {
      

    @Test
    public void testExecuteSuccess() throws InvalidTransactionException {
        Long buyerId = 123L;
        Long sellerId = 234L;
        Long productId = 345L;
        String orderId = "456";
        Transaction transaction = new Transaction(null, buyerId, sellerId, productId, orderId);
        transaction.setWalletRpcService(new WalletRpcService());
        transaction.setAmount(10.0);
        boolean execute = transaction.execute();
        assertTrue(execute);
    }

    @Test
    public void testExecuteFail() throws InvalidTransactionException {

        Calendar.getInstance();

        Long buyerId = 123L;
        Long sellerId = 234L;
        Long productId = 345L;
        String orderId = "456";
        Transaction transaction = new Transaction(null, buyerId, sellerId, productId, orderId);
        WalletRpcService mock = Mockito.mock(WalletRpcService.class);
        transaction.setAmount(10.0);
        transaction.setWalletRpcService(mock);

        transaction.setId(new SimpleIdGenerator().generateId().toString());
        String id = transaction.getId();
        Double amount = transaction.getAmount();
//        Mockito.doReturn(null).when(transaction.getWalletRpcService()).moveMoney("1",1L,1L,1.1);
        Mockito.when(transaction.getWalletRpcService().moveMoney("1",1L,1L,1.1)).thenReturn(null);
        boolean execute = transaction.execute();
        assertEquals(Status.FAILED, transaction.getStatus());
        assertFalse(execute);
    }
}
