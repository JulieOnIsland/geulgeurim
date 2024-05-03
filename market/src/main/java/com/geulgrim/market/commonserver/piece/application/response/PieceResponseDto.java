package com.geulgrim.market.commonserver.piece.application.response;

import com.geulgrim.market.commonserver.piece.domain.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PieceResponseDto {

    private Long id;

    private Long ownerId;

    private String thumbnailUrl;

    private String name;

    private String description;

    private Type type;

}
