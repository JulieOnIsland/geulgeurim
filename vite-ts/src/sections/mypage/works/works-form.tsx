import * as Yup from 'yup';
import { useForm } from 'react-hook-form';
// import { useMemo, useEffect, useCallback, useContext, useState  } from 'react';
import { useMemo, useCallback  } from 'react';
import { yupResolver } from '@hookform/resolvers/yup';
// import { useLocation, useNavigate, UNSAFE_NavigationContext as NavigationContext } from 'react-router-dom';

import { useBlocker } from 'react-router-dom';

import Card from '@mui/material/Card';
import Stack from '@mui/material/Stack';
import Button from '@mui/material/Button';
import Divider from '@mui/material/Divider';
import MenuItem from '@mui/material/MenuItem';
import Grid from '@mui/material/Unstable_Grid2';
import Typography from '@mui/material/Typography';
import LoadingButton from '@mui/lab/LoadingButton';

import { paths } from 'src/routes/paths';
import { useRouter } from 'src/routes/hooks';

// import { useCallbackPrompt } from 'src/hooks/use-callbackprompt';

// import { useBlocker } from 'src/hooks/use-blocker';

import { useSnackbar } from 'src/components/snackbar';
import FormProvider, {
  RHFUpload,
  RHFSelect,
  RHFTextField
} from 'src/components/hook-form';

import WorksRHFSwitch from './works-form-switch';
// import WorksFormEscape from './works-form-escape';

// ----------------------------------------------------------------------

type SelectCatgory = {
  label: string,
  value: string
}

const typeList:SelectCatgory[] = [
  {label:'선화', value:'PEN'},
  {label:'채색', value:'COLOR'},
  {label:'배경', value:'BG'},
  {label:'PD', value:'PD'},
  {label:'스토리', value:'STORY'},
  {label:'콘티', value:'CONT'}
]


export default function WorksForm() {
  const router = useRouter();


  const a = true
  const blocker = useBlocker((
    {currentLocation, nextLocation}) =>
    a && currentLocation.pathname !== nextLocation.pathname
  )



  // unstable_usePrompt({
  //   message: "Are you sure?",
  //   when: ({ currentLocation, nextLocation }) =>
  //     a &&
  //     currentLocation.pathname !== nextLocation.pathname,
  // });

  // const [showPrompt, confirmNavigation, cancelNavigation] = useCallbackPrompt(true);


  const { enqueueSnackbar } = useSnackbar();

  const NewWorksSchema = Yup.object().shape({
    name: Yup.string().required('제목을 입력해주세요'),
    description: Yup.string().required('설명을 입력해주세요'),
    type: Yup.string().required('카테고리를 선택해주세요'),
    // not required
    fileUrl: Yup.mixed<any>().nullable(),
    status: Yup.string().oneOf(['PRIVATE', 'PUBLIC'], '공개 상태를 선택해주세요')
  });

  const defaultValues = useMemo(
    () => ({
      name: '',
      description: '',
      type: '',
      status: 'PRIVATE',

      fileUrl: null
    }),
    []
  );

  const methods = useForm({
    resolver: yupResolver(NewWorksSchema),
    defaultValues,
    mode: 'onChange'
  });


  const {
    reset,
    setValue,
    handleSubmit,
    formState: { isSubmitting, isDirty },
  } = methods;

  console.log(isDirty, isSubmitting)

  console.log('도착')

  // usePreventPageChangeWhenDirty(isDirty);


  const onSubmit = handleSubmit(async (data) => {
    try {
      // api로 바꿔야함
      await new Promise((resolve) => setTimeout(resolve, 500));
      reset();
      enqueueSnackbar('작품 등록 성공!');
      // nft 등록 화면으로 이동하자!
      router.push(paths.mypage.works);
      console.log('DATA', data);
    } catch (error) {
      console.error(error);
    }
  });

  const handleDrop = useCallback(
    (acceptedFiles: File[]) => {
      const file = acceptedFiles[0];

      const newFile = Object.assign(file, {
        preview: URL.createObjectURL(file),
      });

      if (file) {
        setValue('fileUrl', newFile, { shouldValidate: true });
      }
    },
    [setValue]
  );

  const handleRemoveFile = useCallback(() => {
    setValue('fileUrl', null);
  }, [setValue]);

  const renderDetails = (
    <Grid xsOffset={1} mdOffset={2} xs={10} md={8}>
      {!isDirty && '확인중'}
      <Typography variant="h3" sx={{display:'flex',  justifyContent: 'space-between',}}>
          작품 등록
          <WorksRHFSwitch name="status" label="공개여부" />
      </Typography>
      <Card sx={{marginBottom: 4}}>
        <Stack spacing={3} sx={{ p: 3 }}>

          {/* 제목 */}
          <RHFTextField name="name" label="제목" />

          {/* 설명 */}
          <RHFTextField name="description" label="설명" multiline rows={8} />

          {/* 카테고리 */}
          <RHFSelect name="type" label="카테고리">
            <MenuItem value="">None</MenuItem>
            <Divider sx={{ borderStyle: 'dashed' }} />
            {typeList.map((option) => (
              <MenuItem key={option.value} value={option.value}>
                {option.label}
              </MenuItem>
            ))}
          </RHFSelect>

        </Stack>
      </Card>
      <Stack spacing={1.5} mb={4}>
        <Typography variant="h5">작품</Typography>
        {/* 업로드 */}
        <RHFUpload
          name="fileUrl"
          onDrop={handleDrop}
          onDelete={handleRemoveFile}
        />
      </Stack>
      <LoadingButton
          type="submit"
          style={{height:'2.8rem', fontSize:'1rem'}} variant="outlined" color="success" size="medium" sx={{marginRight:3}}
          loading={isSubmitting}
      >
        등록하기
      </LoadingButton>


    </Grid>
  );



  return (
    <>
      <FormProvider methods={methods} onSubmit={onSubmit}>
        <Grid container spacing={3}>
          {renderDetails}
        </Grid>
      </FormProvider>
      {/* {blocker.state === 'blocked' && (
        <Grid>
          <Button onClick={() => blocker.proceed()}>과연</Button>
          <Button onClick={() => blocker.reset()}>되랏</Button>
        </Grid>
      )} */}
        {/* <WorksFormEscape
        open={showPrompt}
        onClose={() => cancelNavigation}
        onOpen={() => showPrompt}
        onMove={confirmNavigation}
        selectVariant='zoomIn'
      /> */}
    </>
  );
}
