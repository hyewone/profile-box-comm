package com.goorm.profileboxcomm.dto.like.request;

import com.goorm.profileboxcomm.enumeration.LikeType;
import com.goorm.profileboxcomm.exception.ExceptionEnum;
import com.goorm.profileboxcomm.validator.EnumPattern;
import lombok.Data;

@Data
public class SelectLikeRequestDto {

    @EnumPattern(regexp = "PROFILE|NOTICE", message = "좋아요 유형을 확인해주세요.", enumType= ExceptionEnum.INVALID_LIKE_TARGETTYPE)
    private LikeType likeType;
}
