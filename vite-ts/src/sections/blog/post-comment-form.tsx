import axios from 'axios';
import * as Yup from 'yup';
import { useForm } from 'react-hook-form';
import { yupResolver } from '@hookform/resolvers/yup';

import Stack from '@mui/material/Stack';
import LoadingButton from '@mui/lab/LoadingButton';

import FormProvider, { RHFTextField } from 'src/components/hook-form';

// ----------------------------------------------------------------------
type props = {
  id: string;
  type: string;
};

export default function PostCommentForm({ id, type }: props) {
  const CommentSchema = Yup.object().shape({
    comment: Yup.string().required('Comment is required'),
  });

  const defaultValues = {
    comment: '',
  };

  const methods = useForm({
    resolver: yupResolver(CommentSchema),
    defaultValues,
  });

  const {
    reset,
    handleSubmit,
    formState: { isSubmitting },
  } = methods;

  const onSubmit = handleSubmit(async (data) => {
    if (type === 'board') {
      const boardCommentWriteRequest = {
        boardId: id,
        content: data.comment,
      };
      try {
        await axios
          .post(`/api/v1/community/comment/${type}`, boardCommentWriteRequest, {
            headers: {
              // "Authorization": '토큰',
            },
            // baseURL: 'https://글그림.com',
            baseURL: 'http://localhost:8080',
          })
          .then((response) => {
            const { commentList } = response.data;
            console.log(response.data);
          })
          .catch((error) => {
            alert('댓글 작성 중 오류가 발생했습니다.');
            console.log(error);
          });
        reset();
        console.info('DATA', data);
      } catch (error) {
        console.error(error);
      }
    } else if (type === 'share') {
      const shareCommentWriteRequest = {
        shareId: id,
        content: data.comment,
      };
      try {
        await axios
          .post(`/api/v1/community/comment/${type}`, shareCommentWriteRequest, {
            headers: {
              // "Authorization": '토큰',
            },
            // baseURL: 'https://글그림.com',
            baseURL: 'http://localhost:8080',
          })
          .then((response) => {
            const { commentList } = response.data;
            console.log(response.data);
          })
          .catch((error) => {
            alert('댓글 작성 중 오류가 발생했습니다.');
            console.log(error);
          });
        reset();
        console.info('DATA', data);
      } catch (error) {
        console.error(error);
      }
    }
  });

  return (
    <FormProvider methods={methods} onSubmit={onSubmit}>
      <Stack spacing={3}>
        <RHFTextField
          name="comment"
          placeholder="Write some of your comments..."
          multiline
          rows={4}
        />

        <Stack direction="row" justifyContent="right">
          <LoadingButton type="submit" variant="contained" loading={isSubmitting}>
            Post comment
          </LoadingButton>
        </Stack>
      </Stack>
    </FormProvider>
  );
}
