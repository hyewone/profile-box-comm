package com.goorm.profileboxcomm.validator;

import com.goorm.profileboxcomm.exception.ApiException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class EnumPatternValidator implements
        ConstraintValidator<EnumPattern, Enum<?>> {

    private Pattern pattern;

    @Override
    public void initialize(EnumPattern annotation) {
        try {
            pattern = Pattern.compile(annotation.regexp());
        } catch (PatternSyntaxException e) {
            throw new ApiException(annotation.enumType());
//            throw ApiResult.getResult(ApiResultType.ERROR, "프로필 리스트 조회", null);


//            "status": "ERROR",
//                    "message": "Validation failed for argument [0] in public com.goorm.profileboxcomm.response.ApiResult<com.goorm.profileboxcomm.entity.Member> com.goorm.profileboxapiauth.controller.AuthController.login(com.goorm.profileboxcomm.dto.auth.requset.LoginRequestDto): [Field error in object 'loginRequestDto' on field 'memberEmail': rejected value [hyeneeOh]; codes [Email.loginRequestDto.memberEmail,Email.memberEmail,Email.java.lang.String,Email]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [loginRequestDto.memberEmail,memberEmail]; arguments []; default message [memberEmail],[Ljakarta.validation.constraints.Pattern$Flag;@37a7a932,.*]; default message [이메일을 확인해주세요.]] ",
//                    "statusCode": 500
//            throw new IllegalArgumentException("pattern regex is invalid", e);
        }
    }

    @Override
    public boolean isValid(Enum<?> value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        Matcher m = pattern.matcher(value.name());
        return m.matches();
    }
}