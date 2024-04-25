package com.geulgrim.common.email.domain;

public class PushMailText {

    /* 협업 신청 요청*/
    public static final String CREW_REQUEST_TITLE = "님에게 협업 신청이 왔어요!"; //senderID 필요
    public static final String CREW_REQUEST_CONTENT = "좋은 협업 경험이 될거에요 !";

    /* 협업 신청 요청 수락 응답 */
    public static final String CREW_REQUEST_REPLY_OK_TITLE = "협업 신청이 수락되었어요 !";
    public static final String CREW_REQUEST_REPLY_OK_CONTENT = "함께 훌륭한 작품을 만들어볼까요 ?";

    /* 협업 신청 요청 거절 응답 */
    public static final String CREW_REQUEST_REPLY_DENY_TITLE = "협업 신청이 거절되었어요...";
    public static final String CREW_REQUEST_REPLY_DENY_CONTENT = "더 좋은 크루를 만날 수 있을거에요 !";

    /* 관심 공고 등록 */
    public static final String FAVORITE_JOB_UPLOAD_TITLE = "관심 공고가 등록되었어요 !";
    public static final String FAVORITE_JOB_UPLOAD_CONTENT = "를 자세히 확인하러 갈까요 ?"; //공고 제목 필요

    /* 지원자 공고 지원 */
    public static final String JOB_APPLY_TITLE = "새로운 지원자가 등록되었어요 !";
    public static final String JOB_APPLY_CONTENT = "어떤 지원자인지 확인하러 가볼까요 ?";

    /*작품 거래 */
    public static final String SOLD_PIECE_TITLE = "님에게 작품이 판매되었어요 !"; //senderId 필요
    public static final String SOLD_PIECE_CONTENT = "역시 멋있는 작품이에요 !";

}
