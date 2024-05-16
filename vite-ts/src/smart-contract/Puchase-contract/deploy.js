const HDWalletProvider = require("@truffle/hdwallet-provider");

const Web3 = require("./web3");
const compiledFactory = require("./build/VoteFactory.json");

// Metamask Mnemonic, Infura API Key
const provider = new HDWalletProvider(
  import.meta.env.VITE_MNEMONIC ,
  import.meta.env.VITE_NETWORK_URL
);

const web3 = new Web3(provider);
const deploy = async () => {
  const accounts = await web3.eth.getAccounts();
  console.log("Attemping to deploy to accounts ", accounts[0]);
  console.log(compiledFactory.abi);
  const result = await new web3.eth.Contract(compiledFactory.abi)
    .deploy({ data: compiledFactory.evm.bytecode.object })
    .send({ from: accounts[0] });

  console.log("Contract deploy to ", result.options.address);
};

deploy();
