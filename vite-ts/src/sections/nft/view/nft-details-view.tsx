import React, { useEffect, useState } from 'react';

import Stack from '@mui/material/Stack';
import Button from '@mui/material/Button';
import Link from '@mui/material/Link/Link';
import Divider from '@mui/material/Divider';
import Container from '@mui/material/Container';
import Typography from '@mui/material/Typography';

import { Avatar, Grid } from '@mui/material';
import { paths } from 'src/routes/paths';

import { RouterLink } from 'src/routes/components';
import { AvatarShape } from 'src/assets/illustrations';

import { useGetPost } from 'src/api/blog';

import Iconify from 'src/components/iconify';
import Markdown from 'src/components/markdown';

import Box from '@mui/material/Box';
import { styled } from '@mui/material/styles';
import { useNavigate } from 'react-router-dom';
import Card from '@mui/material/Card';
// import Purchase from '../../../smart-contract/Puchase-contract/puchase';
import { Web3 } from 'web3';
// import { web3 } from '../../../smart-contract/Puchase-contract/web3';
import HDWalletProvider from '@truffle/hdwallet-provider';
import Purchase from 'src/smart-contract/build/Purchase.json';

// const [wallet_eth, setWallet_eth] = useState(0);
declare global {
  interface Window {
    ethereum: any
    web3: Web3
  }
}
// prettier-ignore
function createDummyData(
  marketId: number, sellerId: number, sellerProfile: string, sellerNickname: string, sellerThumbnail: string, pieceImg: string, pieceTitle: string, pieceContent: string, title: string, content: string, price: number, created_at: Date, views: number) {
  const createdAt = created_at.toLocaleDateString();
  const hit = views.toString();

  return {
    marketId,
    sellerId,
    sellerProfile,
    sellerNickname,
    sellerThumbnail,
    pieceImg,
    pieceTitle,
    pieceContent,
    title,
    content,
    price,
    createdAt,
    hit,
  };
}

// prettier-ignore
const dummy = [
  createDummyData(1, 1, 'https://geulgrim.s3.ap-northeast-2.amazonaws.com/profile/notion-avatar-1708927389233.png', '닉넴닉넴', 'https://geulgrim.s3.ap-northeast-2.amazonaws.com/profile/notion-avatar-1708927389233.png',
    'https://geulgrim.s3.ap-northeast-2.amazonaws.com/Untitled%20%282%29.png', '작품 제목입니다', '작품 내용입니다', '지갑열어sdflkdsjflsdfkskjfgsdlfkdjfladjkfldakfjalfjfaljf', '응애응애', 0.0002, new Date('2024-05-14'), 10),

  createDummyData(2, 1, 'https://geulgrim.s3.ap-northeast-2.amazonaws.com/profile/notion-avatar-1708927389233.png', '닉넴닉넴', 'https://geulgrim.s3.ap-northeast-2.amazonaws.com/profile/notion-avatar-1708927389233.png',
    'https://geulgrim.s3.ap-northeast-2.amazonaws.com/Untitled%20%282%29.png', '작품 제목입니다', '작품 내용입니다', '지갑열어sdflkdsjflsdfkskjfgsdlfkdjfladjkfldakfjalfjfaljf', '응애응애', 0.0002, new Date('2024-05-14'), 10),

  createDummyData(3, 1, 'https://geulgrim.s3.ap-northeast-2.amazonaws.com/profile/notion-avatar-1708927389233.png', '닉넴닉넴', 'https://geulgrim.s3.ap-northeast-2.amazonaws.com/profile/notion-avatar-1708927389233.png',
    'https://geulgrim.s3.ap-northeast-2.amazonaws.com/Untitled%20%282%29.png', '작품 제목입니다', '작품 내용입니다', '지갑열어sdflkdsjflsdfkskjfgsdlfkdjfladjkfldakfjalfjfaljf', '응애응애', 0.0002, new Date('2024-05-14'), 10),

  createDummyData(4, 1, 'https://geulgrim.s3.ap-northeast-2.amazonaws.com/profile/notion-avatar-1708927389233.png', '닉넴닉넴', 'https://geulgrim.s3.ap-northeast-2.amazonaws.com/profile/notion-avatar-1708927389233.png',
    'https://geulgrim.s3.ap-northeast-2.amazonaws.com/Untitled%20%282%29.png', '작품 제목입니다작품 제목입니다작품 제목입니다작품 제목입니다작품 제목입니다작품 제목입니다작품 제목입니다작품 제목입니다작품 제목입니다작품 제목입니다작품 제목입니다작품 제목입니다작품 제목입니다작품 제목입니다작품 제목입니다작품 제목입니다', '작품 내용입니다', '지갑열어sdflkdsjflsdfkskjfgsdlfkdjfladjkfldakfjalfjfaljf', '응애응애', 0.0002, new Date('2024-05-14'), 10),

  createDummyData(5, 1, 'https://geulgrim.s3.ap-northeast-2.amazonaws.com/profile/notion-avatar-1708927389233.png', '닉넴닉넴', 'https://geulgrim.s3.ap-northeast-2.amazonaws.com/profile/notion-avatar-1708927389233.png',
    'https://geulgrim.s3.ap-northeast-2.amazonaws.com/Untitled%20%282%29.png', '작품 제목입니다', '작품 내용입니다', '지갑열어sdflkdsjflsdfkskjfgsdlfkdjfladjkfldakfjalfjfaljf', '응애응애', 0.0002, new Date('2024-05-14'), 10),

  createDummyData(6, 1, 'https://geulgrim.s3.ap-northeast-2.amazonaws.com/profile/notion-avatar-1708927389233.png', '닉넴닉넴', 'https://geulgrim.s3.ap-northeast-2.amazonaws.com/profile/notion-avatar-1708927389233.png',
    'https://geulgrim.s3.ap-northeast-2.amazonaws.com/Untitled%20%282%29.png', '작품 제목입니다', '작품 내용입니다', '지갑열어sdflkdsjflsdfkskjfgsdlfkdjfladjkfldakfjalfjfaljf', '응애응애', 0.0002, new Date('2024-05-14'), 10),

  createDummyData(7, 1, 'https://geulgrim.s3.ap-northeast-2.amazonaws.com/profile/notion-avatar-1708927389233.png', '닉넴닉넴', 'https://geulgrim.s3.ap-northeast-2.amazonaws.com/profile/notion-avatar-1708927389233.png',
    'https://geulgrim.s3.ap-northeast-2.amazonaws.com/Untitled%20%282%29.png', '작품 제목입니다', '작품 내용입니다', '지갑열어sdflkdsjflsdfkskjfgsdlfkdjfladjkfldakfjalfjfaljf', '응애응애', 0.0002, new Date('2024-05-14'), 10),

  createDummyData(8, 1, 'https://geulgrim.s3.ap-northeast-2.amazonaws.com/profile/notion-avatar-1708927389233.png', '닉넴닉넴', 'https://geulgrim.s3.ap-northeast-2.amazonaws.com/profile/notion-avatar-1708927389233.png',
    'https://geulgrim.s3.ap-northeast-2.amazonaws.com/Untitled%20%282%29.png', '작품 제목입니다', '작품 내용입니다', '지갑열어sdflkdsjflsdfkskjfgsdlfkdjfladjkfldakfjalfjfaljf', '응애응애', 0.0002, new Date('2024-05-14'), 10),

  createDummyData(9, 1, 'https://geulgrim.s3.ap-northeast-2.amazonaws.com/profile/notion-avatar-1708927389233.png', '닉넴닉넴', 'https://geulgrim.s3.ap-northeast-2.amazonaws.com/profile/notion-avatar-1708927389233.png',
    'https://geulgrim.s3.ap-northeast-2.amazonaws.com/Untitled%20%282%29.png', '작품 제목입니다', '작품 내용입니다', '지갑열어sdflkdsjflsdfkskjfgsdlfkdjfladjkfldakfjalfjfaljf', '응애응애', 0.0002, new Date('2024-05-14'), 10),

];

type MarketDetail = {
  marketId: number;
  sellerId: number;
  sellerProfile: string;
  sellerNickname: string;
  sellerThumbnail: string;
  pieceImg: string;
  pieceTitle: string;
  pieceContent: string;
  title: string;
  content: string;
  price: number;
  hit: string;
  createdAt: Date | string | number;
};

type Props = {
  id: string;
};

export default function PostDetailsView({ id }: Props) {
  console.log('marketId: ', id);

  const navigate = useNavigate();
  const [marketDetails, setMarketDetails] = useState<MarketDetail | undefined>();
  // var nftEvent = await new window.Web3.eth.Contract(account);

  useEffect(() => {
    console.log('Checking id:', id);
    console.log('Dummy Data:', dummy);
    // Simulate fetching data
    const foundData = dummy.find(item => item.marketId === parseInt(id, 10));
    console.log('Found Data:', foundData);
    setMarketDetails(foundData);
  }, [id]);

  const handleApplyClick = () => {
    // navigate(`/nft/${}`, { state: { marketDetails } });
    // 블록체인의 스마트 컨트랙트 부분 시작
  };

  const ProductImage = styled('img')({
    width: '90%',
    height: '90%',
    objectFit: 'cover',
  });

  if (!marketDetails) return <div>마켓 상세정보 가져오는 중...</div>;

  // 작성자 프로필로 이동
  // const toProfile = paths.mypage.root;
  const toProfile = () => {
    console.log(marketDetails.sellerId);
  };

  // const [open, setOpen] = useState(false);
  const handleOpen = async () => {
    // setOpen(true);
    try {
      console.log('연동 시작');
      const currentProvider = detectCurrentProvider();
      if (currentProvider) {
        if (currentProvider !== window.ethereum) {
          console.log(
            "Non-Ethereum browser detected. You should consider trying MetaMask!"
          );
        }

        // 메타마스크 연결
        await currentProvider.request({ method: "eth_requestAccounts" });

        // const useWeb3 = new Web3(currentProvider);
        // const provider = new HDWalletProvider(
        //   import.meta.env.VITE_MNEMONIC ,
        //   import.meta.env.VITE_NETWORK_URL
        // );

        const useWeb3 = new Web3(currentProvider);
        console.log("currentProvider", currentProvider.meta.cur)
        const userAccount = await useWeb3.eth.getAccounts();
        const account = userAccount[0];
        let ethBalance: string = String(await useWeb3.eth.getBalance(account)); // Get wallet balance
        ethBalance = useWeb3.utils.fromWei(ethBalance, "ether");
        // setWallet_eth(Number(ethBalance));
        if (userAccount.length === 0) {
          console.log("Please connect to meta mask");
        } else {
          console.log("지갑 잔액: ", ethBalance);
        }


        // 컨트랙트 인스턴스 생성
        const contractEvent = new window.web3.eth.Contract(Purchase.abi, import.meta.env.VITE_CONTRACT_ADDRESS);
        console.log(contractEvent.currentProvider);

      }
    } catch (err) {
      console.log(
        "There was an error fetching your accounts. Make sure your Ethereum client is configured correctly."
      );
    }
  };


  const detectCurrentProvider = () => {
    let provider;
    if (window.ethereum) {
      console.log(window.ethereum, "을 provider에 넣기")
      provider = window.ethereum;
    } else if (window.web3) {
      console.log(window.web3.currentProvider, "을 provider에 초기화")
      provider = window.web3.currentProvider;
    } else {
      console.log(
        "Non-Ethereum browser detected. You should consider trying MetaMask!"
      );
    }
    return provider;
  };

  // async function onSubmit(data) {
  //   alert("작품을 구매할까요?");
  //
  //   try {
  //     const myIdx = localStorage.getItem("idx");
  //
  //     const accounts = await web3.eth.getAccounts();
  //     setLoading(true);
  //     setOpen(false);
  //
  //     const result = await campaignItem.methods.contribute().send({
  //       from: accounts[0],
  //       value: web3.utils.toWei(String(data.donation), "ether"),
  //     });
  //     setAmountInUSD(null);
  //     reset("", {
  //       keepValues: false,
  //     });
  //     setIsSubmitted(true);
  //
  //     await putDonation(
  //       {
  //         donationIdx: infos.donationIdx,
  //         donAmount: web3.utils.toWei(String(data.donation), "ether"),
  //       },
  //       (response) => {
  //         setComment(response.data.data);
  //       },
  //       (err) => {
  //         console.log(err);
  //       }
  //     );
  //
  //     await postPurchase(
  //       {
  //         donationIdx: infos.donationIdx,
  //         myDonationAmount: web3.utils.toWei(String(data.donation), "ether"),
  //         myDonationName: infos.donationName,
  //         userIdx: localStorage.getItem("idx"),
  //       },
  //       (response) => {
  //         console.log("성공", response);
  //       },
  //       (err) => {
  //         console.log("postMyDonation 실패", err);
  //       }
  //     );
  //
  //     await putUserDonate(
  //       {
  //         userIdx: localStorage.getItem("idx"),
  //         donateAmount: web3.utils.toWei(String(data.donation), "ether"),
  //       },
  //       (response) => {
  //         console.log("유저 도네이트 갱신 성공", response);
  //       },
  //       (err) => {
  //         console.log("유저 도네이트 갱신 실패", err);
  //       }
  //     );
  //
  //     alert("기부자님의 따뜻한 마음이 퍼져나갑니다.");
  //     setLoading(false);
  //     window.location.reload();
  //   } catch (err) {
  //     alert("스마트 컨트랙트 오류입니다. 기부금을 제대로 입력하셨나요?");
  //     setError(err.message);
  //     console.log(err);
  //   }
  // }



  return (
    <Container>

      <Grid item xs={12} sx={{ mt: 5 }}>
        <Box marginBottom={2} sx={{ display: 'flex', justifyContent: 'center', flexWrap: 'wrap', gap: 2 }}>
          <Card sx={{
            width: '50%', // Make the Card take full width of the Grid item
            minHeight: 500, // Set a fixed height, or use min/max height as needed
            boxShadow: 3, // Optional: add shadow for better visibility
          }}>

            <Stack spacing={2} paddingLeft={2} sx={{ textAlign: 'left', display: 'flex' }}>
              <ProductImage src={marketDetails.pieceImg} alt={marketDetails.pieceTitle} />
              <Typography variant="h6" component="div">
                {marketDetails.pieceTitle}
              </Typography>
              <Typography variant="body2" color="text.secondary">
                {marketDetails.pieceContent}
              </Typography>

            </Stack>
          </Card>

          <Card sx={{
            width: '100%', // Adjust to make the Card take full width of the parent container
            maxWidth: 300,
            boxShadow: 3, // Optional: add shadow for better visibility
            alignItems: 'center',  // Centers content horizontally
            display: 'flex',
            flexDirection: 'column', // Ensure content is arranged vertically
            wordBreak: 'break-all',

          }}>

            <Stack spacing={2} sx={{ p: 2, flexGrow: 1 }}>
              <Typography variant="h6" component="div">
                {marketDetails.title}
              </Typography>
              <Typography variant="body2">
                {marketDetails.content}
              </Typography>

              <Box sx={{ display: 'flex', alignItems: 'center' }}>

                <Link
                  component={RouterLink}
                  href=""
                  onClick={toProfile}
                  sx={{ display: 'flex', alignItems: 'center', mr: 1 }}
                >
                  <Avatar
                    alt="유저이미지"
                    src={marketDetails.sellerProfile}
                    sx={{
                      zIndex: 9,
                    }}
                  />
                </Link>
                <Typography variant="subtitle2" color="text.secondary">
                  {marketDetails.sellerNickname}
                </Typography>

              </Box>

              <Button variant="contained" fullWidth sx={{ mt: 'auto' }} onClick={handleOpen}>
                구매하기
              </Button>
            </Stack>
          </Card>
        </Box>

      </Grid>

    </Container>

  );
}
