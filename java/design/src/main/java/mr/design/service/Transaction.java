package mr.design.service;

import lombok.Data;
import mr.design.enums.Status;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.util.SimpleIdGenerator;

import javax.transaction.InvalidTransactionException;

@Data
public class Transaction {
    private String id;
    private Long buyerId;
    private Long sellerId;
    private Long productId;
    private String orderId;
    private Long createTimestamp;
    private Double amount;
    private Status status;
    private String walletTransactionId;
    private WalletRpcService walletRpcService;

    public Transaction(String preAssignedId, Long buyerId, Long sellerId, Long productId, String orderId) {
        if (preAssignedId != null && !preAssignedId.isEmpty()) {
            this.id = preAssignedId;
        } else {
            this.id = new SimpleIdGenerator().generateId().toString();
        }
        if (!this.id.startsWith("t_")) {
            this.id = "t_" + this.id;
        }
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.productId = productId;
        this.orderId = orderId;
        this.status = Status.TO_BE_EXECUTED;
        this.createTimestamp = System.currentTimeMillis();
    }

    public boolean execute() throws InvalidTransactionException {
        if (buyerId == null || sellerId == null || amount < 0.0) {
            throw new InvalidTransactionException();
        }
        if (status == Status.EXECUTED) return true;
        RLock lock = Redisson.create().getLock(id);

        try {
            if (!lock.tryLock()) {
                return false;
            }
            long executionInvokedTimestamp = System.currentTimeMillis();
            if (executionInvokedTimestamp - createTimestamp > 14 * 3600* 24 * 1000) {
                this.status = Status.EXPIRED;
                return false;
            }
            String walletTransactionId = walletRpcService.moveMoney(id, buyerId, sellerId, amount);
            if (walletTransactionId != null) {
                this.walletTransactionId = walletTransactionId;
                this.status = Status.EXECUTED;
                return true;
            }
            this.status = Status.FAILED;
            return  false;
        } finally {
            lock.unlock();
        }
    }
}
