package com.geulgrim.market.market.infrastructure.contract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.5.3.
 */
@SuppressWarnings("rawtypes")
public class IERC20 extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506040516108723803806108728339818101604052810190610032919061015a565b336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555081600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555080600181905550505061019a565b600080fd5b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b60006100f1826100c6565b9050919050565b610101816100e6565b811461010c57600080fd5b50565b60008151905061011e816100f8565b92915050565b6000819050919050565b61013781610124565b811461014257600080fd5b50565b6000815190506101548161012e565b92915050565b60008060408385031215610171576101706100c1565b5b600061017f8582860161010f565b925050602061019085828601610145565b9150509250929050565b6106c9806101a96000396000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c8063893d20e81461004657806398d5fdca14610064578063f2fde38b14610082575b600080fd5b61004e61009e565b60405161005b91906103cf565b60405180910390f35b61006c6100c7565b6040516100799190610403565b60405180910390f35b61009c6004803603810190610097919061044f565b6100d1565b005b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905090565b6000600154905090565b60008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461015f576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610156906104d9565b60405180910390fd5b600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff16036101ce576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016101c59061056b565b60405180910390fd5b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166323b872dd8260008054906101000a900473ffffffffffffffffffffffffffffffffffffffff166001546040518463ffffffff1660e01b815260040161024f9392919061058b565b6020604051808303816000875af115801561026e573d6000803e3d6000fd5b505050506040513d601f19601f8201168201806040525081019061029291906105fa565b6102d1576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016102c890610673565b60405180910390fd5b8073ffffffffffffffffffffffffffffffffffffffff1660008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a3806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b60006103b98261038e565b9050919050565b6103c9816103ae565b82525050565b60006020820190506103e460008301846103c0565b92915050565b6000819050919050565b6103fd816103ea565b82525050565b600060208201905061041860008301846103f4565b92915050565b600080fd5b61042c816103ae565b811461043757600080fd5b50565b60008135905061044981610423565b92915050565b6000602082840312156104655761046461041e565b5b60006104738482850161043a565b91505092915050565b600082825260208201905092915050565b7f43616c6c6572206973206e6f7420746865206f776e6572000000000000000000600082015250565b60006104c360178361047c565b91506104ce8261048d565b602082019050919050565b600060208201905081810360008301526104f2816104b6565b9050919050565b7f4e6577206f776e65722063616e6e6f7420626520746865207a65726f2061646460008201527f7265737300000000000000000000000000000000000000000000000000000000602082015250565b600061055560248361047c565b9150610560826104f9565b604082019050919050565b6000602082019050818103600083015261058481610548565b9050919050565b60006060820190506105a060008301866103c0565b6105ad60208301856103c0565b6105ba60408301846103f4565b949350505050565b60008115159050919050565b6105d7816105c2565b81146105e257600080fd5b50565b6000815190506105f4816105ce565b92915050565b6000602082840312156106105761060f61041e565b5b600061061e848285016105e5565b91505092915050565b7f5061796d656e74207472616e73666572206661696c6564000000000000000000600082015250565b600061065d60178361047c565b915061066882610627565b602082019050919050565b6000602082019050818103600083015261068c81610650565b905091905056fea26469706673582212202397ea68422eab07a378a90c5bef184d889e2cd633c489dfea8738fc35402e1264736f6c63430008130033";

    private static String librariesLinkedBinary;

    public static final String FUNC_TRANSFERFROM = "transferFrom";

    @Deprecated
    protected IERC20(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected IERC20(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected IERC20(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected IERC20(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> transferFrom(String sender, String recipient, BigInteger amount) {
        final Function function = new Function(
                FUNC_TRANSFERFROM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, sender), 
                new org.web3j.abi.datatypes.Address(160, recipient), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static IERC20 load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new IERC20(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static IERC20 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new IERC20(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static IERC20 load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new IERC20(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static IERC20 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new IERC20(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<IERC20> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IERC20.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<IERC20> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IERC20.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    public static RemoteCall<IERC20> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IERC20.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<IERC20> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IERC20.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

//    public static void linkLibraries(List<Contract.LinkReference> references) {
//        librariesLinkedBinary = linkBinaryWithReferences(BINARY, references);
//    }

    public static String getDeploymentBinary() {
        if (librariesLinkedBinary != null) {
            return librariesLinkedBinary;
        } else {
            return BINARY;
        }
    }
}
