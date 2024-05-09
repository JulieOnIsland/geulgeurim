package com.geulgrim.market.market.infrastructure.util;

import com.geulgrim.market.market.infrastructure.contract.Purchase;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;

@Component
@AllArgsConstructor
public class Web3jActivator {

    private final Web3j web3j;
    private final Credentials credentials;
    private final ContractGasProvider contractGasProvider;
    private fnal

    @Bean
    public ContractGasProvider contractGasProvider() {
        return new StaticGasProvider(BigInteger.valueOf(4_100_000_000L), BigInteger.valueOf(4_300_000));
    }

    public String transferOwnership(String contractAddress, String newOwner) throws Exception {
        Ownership ownership = Ownership.load(contractAddress, web3j, credentials, contractGasProvider);
        return ownership.transferOwnership(newOwner).send().getTransactionHash();
    }

    public String purchaseArtwork(String contractAddress, String recipient, BigInteger amount) throws Exception {
        Purchase purchase = Purchase.load(contractAddress, web3j, credentials, contractGasProvider);
        return purchase.transfer(recipient, amount).send().getTransactionHash();
    }

}
