package mr.design.service;

import org.springframework.util.SimpleIdGenerator;

public class WalletRpcService {
    public String moveMoney(String transactionId,Long buyerId,Long sellerId,double amount){
        return new SimpleIdGenerator().generateId().toString();
    }
}
