package com.geulgrim.recruit.job.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetMyApplyedJobsResponses {
    private List<GetMyApplyedJobsResponse> getMyApplyedJobsResponses;
    private int totalPage;
}