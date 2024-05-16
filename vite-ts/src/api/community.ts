import useSWR from 'swr';
import { useMemo } from 'react';

import { customFetcher, endpoints } from 'src/utils/custom-axios';

import { communityMainItem } from 'src/types/blog';

// ----------------------------------------------------------------------

export function useGetCommunityMain() {
  const URL = "/api/v1/community"

  const token = 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhY2Nlc3MtdG9rZW4iLCJ1c2VySWQiOjMzLCJ1c2VyVHlwZSI6IklORElWSURVQUwiLCJpYXQiOjE3MTU1Njk1OTEsImV4cCI6MTcxNTYwNTU5MX0.Nt9nKvEV8TyY7uU1xrCeWtEbmjEeHk2gdaWj_czPRas'

  const { data, isLoading, error, isValidating } = useSWR([URL, { headers: { Authorization: `Bearer ${token}` } }], customFetcher);
  console.log('Community Main' ,data)

  const memoizedValue = useMemo(
    () => ({
      community: (data) || [],
      communityLoading: isLoading,
      communityError: error,
      communityValidating: isValidating,
      newBoardEmpty: !isLoading && !data?.newBoard.length,
      popBoardEmpty: !isLoading && !data?.popBoard.length,
      newShareEmpty: !isLoading && !data?.newShare.length,
    }),
    [data, error, isLoading, isValidating]
  );

  return memoizedValue;
}

// ----------------------------------------------------------------------

export function useGetBoardList() {
  const URL = "/api/v1/community/board"

  const token = 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhY2Nlc3MtdG9rZW4iLCJ1c2VySWQiOjMzLCJ1c2VyVHlwZSI6IklORElWSURVQUwiLCJpYXQiOjE3MTU1Njk1OTEsImV4cCI6MTcxNTYwNTU5MX0.Nt9nKvEV8TyY7uU1xrCeWtEbmjEeHk2gdaWj_czPRas'

  const { data, isLoading, error, isValidating } = useSWR([URL, { headers: { Authorization: `Bearer ${token}` } }], customFetcher);
  console.log('Board List' ,data)

  const memoizedValue = useMemo(
    () => ({
      board: (data) || [],
      boardLoading: isLoading,
      boardError: error,
      boardValidating: isValidating,
      boardEmpty: !isLoading && !data?.length,
    }),
    [data, error, isLoading, isValidating]
  );

  return memoizedValue;

}

// ----------------------------------------------------------------------

export function useGetBoardDetail(boardId: string) {
  const URL = `/api/v1/community/board/${boardId}`

  const token = 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhY2Nlc3MtdG9rZW4iLCJ1c2VySWQiOjMzLCJ1c2VyVHlwZSI6IklORElWSURVQUwiLCJpYXQiOjE3MTU1Njk1OTEsImV4cCI6MTcxNTYwNTU5MX0.Nt9nKvEV8TyY7uU1xrCeWtEbmjEeHk2gdaWj_czPRas'

  const { data, isLoading, error, isValidating } = useSWR([URL, { headers: { Authorization: `Bearer ${token}` } }], customFetcher);
  console.log('Board Detail' ,data)

  const memoizedValue = useMemo(
    () => ({
      board: (data?.board) || [],
      commentList: (data?.commentList) || [],
      imageList: (data?.imageList) || [],
      boardLoading: isLoading,
      boardError: error,
      boardValidating: isValidating,
      boardEmpty: !isLoading && !data?.board,
    }),
    [data, error, isLoading, isValidating]
  );

  return memoizedValue;
  
}

// ----------------------------------------------------------------------

export function useGetShareList() {
  const URL = `/api/v1/community/share`

  const token = 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhY2Nlc3MtdG9rZW4iLCJ1c2VySWQiOjMzLCJ1c2VyVHlwZSI6IklORElWSURVQUwiLCJpYXQiOjE3MTU1Njk1OTEsImV4cCI6MTcxNTYwNTU5MX0.Nt9nKvEV8TyY7uU1xrCeWtEbmjEeHk2gdaWj_czPRas'

  const { data, isLoading, error, isValidating } = useSWR([URL, { headers: { Authorization: `Bearer ${token}` } }], customFetcher);
  console.log('Share List' ,data)

  const memoizedValue = useMemo(
    () => ({
      share: (data) || [],
      shareLoading: isLoading,
      shareError: error,
      shareValidating: isValidating,
      shareEmpty: !isLoading && !data,
    }),
    [data, error, isLoading, isValidating]
  );

  return memoizedValue;

}

// ----------------------------------------------------------------------

export function useGetShareDetail(shareId: string) {
  const URL = `/api/v1/community/share/${shareId}`

  const token = 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhY2Nlc3MtdG9rZW4iLCJ1c2VySWQiOjMzLCJ1c2VyVHlwZSI6IklORElWSURVQUwiLCJpYXQiOjE3MTU1Njk1OTEsImV4cCI6MTcxNTYwNTU5MX0.Nt9nKvEV8TyY7uU1xrCeWtEbmjEeHk2gdaWj_czPRas'

  const { data, isLoading, error, isValidating } = useSWR([URL, { headers: { Authorization: `Bearer ${token}` } }], customFetcher);
  console.log('Share List' ,data)

  const memoizedValue = useMemo(
    () => ({
      share: (data?.share) || [],
      commentList: (data?.commentList) || [],
      imageList: (data?.imageList) || [],
      shareLoading: isLoading,
      shareError: error,
      shareValidating: isValidating,
      shareEmpty: !isLoading && !data?.share,
    }),
    [data, error, isLoading, isValidating]
  );

  return memoizedValue;

}

// ----------------------------------------------------------------------

// ----------------------------------------------------------------------

// ----------------------------------------------------------------------

// ----------------------------------------------------------------------

// ----------------------------------------------------------------------