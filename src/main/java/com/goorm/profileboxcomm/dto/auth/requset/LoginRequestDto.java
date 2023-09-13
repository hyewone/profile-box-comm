package com.goorm.profileboxcomm.dto.auth.requset;

import com.goorm.profileboxcomm.validator.EnumPattern;
import com.goorm.profileboxcomm.enumeration.MemberType;
import com.goorm.profileboxcomm.enumeration.ProviderType;
import com.goorm.profileboxcomm.exception.ExceptionEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class LoginRequestDto {

    @Schema(description = "이메일")
    @Email(message = "이메일을 확인해주세요.")
    private String memberEmail;
    @Schema(description = "멤버 유형")
    @EnumPattern(regexp = "ADMIN|ACTOR|PRODUCER", message = "멤버 유형을 확인해주세요.", enumType=ExceptionEnum.INVALID_MEMBERTYPE)
    private MemberType memberType;
    @Schema(description = "OAuth Provider 유형")
    @EnumPattern(regexp = "GOOGLE|KAKAO|NAVER", message = "OAuth 공급자 유형을 확인해주세요.", enumType=ExceptionEnum.INVALID_PROVIDERTYPE)
    private ProviderType providerType;

}
