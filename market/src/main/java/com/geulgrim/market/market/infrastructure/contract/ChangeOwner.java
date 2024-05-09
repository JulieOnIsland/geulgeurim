package com.geulgrim.market.market.infrastructure.contract;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
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
public class ChangeOwner extends Contract {
    public static final String BINARY = "608060405234801561000f575f80fd5b506040516108343803806108348339818101604052810190610031919061014f565b335f806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508160025f6101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555080600181905550505061018d565b5f80fd5b5f73ffffffffffffffffffffffffffffffffffffffff82169050919050565b5f6100eb826100c2565b9050919050565b6100fb816100e1565b8114610105575f80fd5b50565b5f81519050610116816100f2565b92915050565b5f819050919050565b61012e8161011c565b8114610138575f80fd5b50565b5f8151905061014981610125565b92915050565b5f8060408385031215610165576101646100be565b5b5f61017285828601610108565b92505060206101838582860161013b565b9150509250929050565b61069a8061019a5f395ff3fe608060405234801561000f575f80fd5b506004361061003f575f3560e01c8063893d20e81461004357806398d5fdca14610061578063f2fde38b1461007f575b5f80fd5b61004b61009b565b60405161005891906103be565b60405180910390f35b6100696100c2565b60405161007691906103ef565b60405180910390f35b61009960048036038101906100949190610436565b6100cb565b005b5f805f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905090565b5f600154905090565b5f8054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614610158576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161014f906104bb565b60405180910390fd5b5f73ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff16036101c6576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016101bd90610549565b60405180910390fd5b60025f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166323b872dd825f8054906101000a900473ffffffffffffffffffffffffffffffffffffffff166001546040518463ffffffff1660e01b815260040161024593929190610567565b6020604051808303815f875af1158015610261573d5f803e3d5ffd5b505050506040513d601f19601f8201168201806040525081019061028591906105d1565b6102c4576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016102bb90610646565b60405180910390fd5b8073ffffffffffffffffffffffffffffffffffffffff165f8054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a3805f806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b5f73ffffffffffffffffffffffffffffffffffffffff82169050919050565b5f6103a88261037f565b9050919050565b6103b88161039e565b82525050565b5f6020820190506103d15f8301846103af565b92915050565b5f819050919050565b6103e9816103d7565b82525050565b5f6020820190506104025f8301846103e0565b92915050565b5f80fd5b6104158161039e565b811461041f575f80fd5b50565b5f813590506104308161040c565b92915050565b5f6020828403121561044b5761044a610408565b5b5f61045884828501610422565b91505092915050565b5f82825260208201905092915050565b7f43616c6c6572206973206e6f7420746865206f776e65720000000000000000005f82015250565b5f6104a5601783610461565b91506104b082610471565b602082019050919050565b5f6020820190508181035f8301526104d281610499565b9050919050565b7f4e6577206f776e65722063616e6e6f7420626520746865207a65726f206164645f8201527f7265737300000000000000000000000000000000000000000000000000000000602082015250565b5f610533602483610461565b915061053e826104d9565b604082019050919050565b5f6020820190508181035f83015261056081610527565b9050919050565b5f60608201905061057a5f8301866103af565b61058760208301856103af565b61059460408301846103e0565b949350505050565b5f8115159050919050565b6105b08161059c565b81146105ba575f80fd5b50565b5f815190506105cb816105a7565b92915050565b5f602082840312156105e6576105e5610408565b5b5f6105f3848285016105bd565b91505092915050565b7f5061796d656e74207472616e73666572206661696c65640000000000000000005f82015250565b5f610630601783610461565b915061063b826105fc565b602082019050919050565b5f6020820190508181035f83015261065d81610624565b905091905056fea264697066735822122073a079d2cd271ab4d9c027178a472502d5f4cea2d18a486f200008651580225664736f6c63430008190033";

    private static String librariesLinkedBinary;

    public static final String FUNC_GETOWNER = "getOwner";

    public static final String FUNC_GETPRICE = "getPrice";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    @Deprecated
    protected ChangeOwner(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ChangeOwner(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ChangeOwner(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ChangeOwner(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<OwnershipTransferredEventResponse> getOwnershipTransferredEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, transactionReceipt);
        ArrayList<OwnershipTransferredEventResponse> responses = new ArrayList<OwnershipTransferredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static OwnershipTransferredEventResponse getOwnershipTransferredEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, log);
        OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
        typedResponse.log = log;
        typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
        return typedResponse;
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getOwnershipTransferredEventFromLog(log));
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OWNERSHIPTRANSFERRED_EVENT));
        return ownershipTransferredEventFlowable(filter);
    }

    public RemoteFunctionCall<String> getOwner() {
        final Function function = new Function(FUNC_GETOWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> getPrice() {
        final Function function = new Function(FUNC_GETPRICE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> transferOwnership(String newOwner) {
        final Function function = new Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static ChangeOwner load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ChangeOwner(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ChangeOwner load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ChangeOwner(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ChangeOwner load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ChangeOwner(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ChangeOwner load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ChangeOwner(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ChangeOwner> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _paymentToken, BigInteger _price) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _paymentToken), 
                new org.web3j.abi.datatypes.generated.Uint256(_price)));
        return deployRemoteCall(ChangeOwner.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), encodedConstructor);
    }

    public static RemoteCall<ChangeOwner> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _paymentToken, BigInteger _price) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _paymentToken), 
                new org.web3j.abi.datatypes.generated.Uint256(_price)));
        return deployRemoteCall(ChangeOwner.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ChangeOwner> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _paymentToken, BigInteger _price) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _paymentToken), 
                new org.web3j.abi.datatypes.generated.Uint256(_price)));
        return deployRemoteCall(ChangeOwner.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ChangeOwner> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _paymentToken, BigInteger _price) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _paymentToken), 
                new org.web3j.abi.datatypes.generated.Uint256(_price)));
        return deployRemoteCall(ChangeOwner.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), encodedConstructor);
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

    public static class OwnershipTransferredEventResponse extends BaseEventResponse {
        public String previousOwner;

        public String newOwner;
    }
}
