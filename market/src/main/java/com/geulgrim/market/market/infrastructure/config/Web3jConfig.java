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

    // Credentials 빈을 설정합니다. 이는 개인키를 통해 Ethereum 지갑에 접근합니다.
    @Bean
    public Credentials credentials() {
        return Credentials.create("your_private_key"); //
    }

    // StaticGasProvider를 통해 트랜잭션의 가스 가격과 한도를 설정합니다.
    @Bean
    public ContractGasProvider contractGasProvider() {
        return new StaticGasProvider(
                BigInteger.valueOf(22_000_000_000L), // 가스 가격 (Wei 단위)
                BigInteger.valueOf(4_500_000));      // 가스 한도
    }
}

