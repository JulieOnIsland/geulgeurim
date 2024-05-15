package com.geulgrim.common.portfolio.application.dto.response;

import com.geulgrim.common.portfolio.domain.entity.enums.Format;
import com.geulgrim.common.portfolio.domain.entity.enums.OpenState;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @Setter
public class PortfolioResponse {

    private Long pofolId;
    private String pofolName;
    private OpenState openState;
    private Format format;
    private LocalDate createdAt;
    private LocalDate updatedAt;

}