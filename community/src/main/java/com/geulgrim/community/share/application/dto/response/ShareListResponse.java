package com.geulgrim.community.share.application.dto.response;

import com.geulgrim.community.share.domain.entity.QShareImage;
import com.geulgrim.community.share.domain.entity.ShareImage;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShareListResponse {
    private long shareId;
    private long userId;
    private String userNickname;
    private String userFileUrl;
    private List<ShareImage> imageList;
    private String title;
    private long hit;
    private long commentCnt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ShareListResponse(long shareId, long userId, String userNickname, String userFileUrl, String title, long hit, long commentCnt, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.shareId = shareId;
        this.userId = userId;
        this.userNickname = userNickname;
        this.userFileUrl = userFileUrl;
        this.title = title;
        this.hit = hit;
        this.commentCnt = commentCnt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}
