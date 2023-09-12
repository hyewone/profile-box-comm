package com.goorm.profileboxcomm.dto.auth.requset;

import com.goorm.profileboxcomm.validator.EnumPattern;
import com.goorm.profileboxcomm.enumeration.MemberType;
import com.goorm.profileboxcomm.enumeration.ProviderType;
import com.goorm.profileboxcomm.exception.ExceptionEnum;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class LoginRequestDto {

    @Email(message = "이메일을 확인해주세요.")
    private String memberEmail;
    @EnumPattern(regexp = "ADMIN|ACTOR|PRODUCER", message = "멤버 유형을 확인해주세요.", enumType=ExceptionEnum.INVALID_MEMBERTYPE)
    private MemberType memberType;
    @EnumPattern(regexp = "GOOGLE|KAKAO|NAVER", message = "OAuth 공급자 유형을 확인해주세요.", enumType=ExceptionEnum.INVALID_PROVIDERTYPE)
    private ProviderType providerType;

}
