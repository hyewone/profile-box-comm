package com.goorm.profileboxcomm.dto.like.request;

import com.goorm.profileboxcomm.enumeration.LikeType;
import com.goorm.profileboxcomm.exception.ExceptionEnum;
import com.goorm.profileboxcomm.validator.EnumPattern;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateLikeRequestDto {

    @Schema(description = "좋아요 유형")
    @EnumPattern(regexp = "PROFILE|NOTICE", message = "좋아요 유형을 확인해주세요.", enumType= ExceptionEnum.INVALID_LIKE_TARGETTYPE)
    private LikeType likeType;

    @Schema(description = "좋아요 대상 ID")
    @NotNull(message = "좋아요 대상 ID를 입력해 주세요.")
    private Long targetId;
}
