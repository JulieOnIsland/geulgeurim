package com.geulgrim.market.market.infrastructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;

@Configuration
public class Web3jConfig {

    @Value("${infura.api-url")
    private static String INFURA_API_URL;

    @Bean
    public Web3j web3j() {
        return Web3j.build(new HttpService(INFURA_API_URL));
    }

    @Bean
    public Credentials credentials() {
        return Credentials.create("YOUR_WALLET_PRIVATE_KEY");
    }

    @Bean
    public ContractGasProvider contractGasProvider() {
        return new StaticGasProvider(BigInteger.valueOf(20_000_000_000L), BigInteger.valueOf(4_300_000));
    }
}

