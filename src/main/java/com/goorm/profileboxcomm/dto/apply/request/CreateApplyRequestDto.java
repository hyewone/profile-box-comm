package com.goorm.profileboxcomm.dto.apply.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateApplyRequestDto {

    @Schema(description = "지원자 ID")
    private Long profileId;

    @Schema(description = "지원 대상 작품 공고 ID")
    @NotNull(message = "지원 대상 작품 공고 ID를 확인해주세요.")
    private Long noticeId;
}