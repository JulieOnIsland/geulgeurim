import web3 from "./web3";
import Purchase from "./build/Purchase.json";

export default (address) => {
  return new web3.eth.Contract(Purchase.abi, address);
};
