package com.goorm.profileboxcomm.exception;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public enum ExceptionEnum {

    RUNTIME_EXCEPTION(HttpStatus.BAD_REQUEST, "런타임 에러입니다."),
    INVALID_REQUEST(HttpStatus.BAD_REQUEST, "유효하지 않는 요청입니다."),
    INVALID_DATE_FORMAT(HttpStatus.BAD_REQUEST, "데이트 포맷 파싱 에러입니다."),
    PROFILE_ALREADY_EXIST(HttpStatus.BAD_REQUEST,  "프로필이 이미 존재합니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "알 수 없는 에러가 발생했습니다."),
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "멤버가 존재하지 않습니다."),
    PROFILE_NOT_FOUND(HttpStatus.NOT_FOUND, "프로필이 존재하지 않습니다."),
    NOTICE_NOT_FOUND(HttpStatus.NOT_FOUND, "공지사항이 존재하지 않습니다."),
    IMAGE_NOT_FOUND(HttpStatus.NOT_FOUND, "이미지가 존재하지 않습니다."),
    VIDEO_NOT_FOUND(HttpStatus.NOT_FOUND,  "동영상이 존재하지 않습니다."),
    FILMO_NOT_FOUND(HttpStatus.NOT_FOUND,  "필모그래피가 존재하지 않습니다."),
    LINK_NOT_FOUND(HttpStatus.NOT_FOUND, "링크가 존재하지 않습니다."),

    SECURITY(HttpStatus.UNAUTHORIZED,  "로그인이 필요합니다."),
    LOGIN_FAILED(HttpStatus.UNAUTHORIZED, "멤버가 존재하지 않거나 패스워드가 일치하지 않습니다."),
    ACCESS_DENIED_EXCEPTION(HttpStatus.UNAUTHORIZED,  ""),
    NOT_RESPONSE_ADMIN_API(HttpStatus.UNAUTHORIZED,  "ADMIN API 통신 오류입니다."),
    TOKEN_NOT_FOUND(HttpStatus.UNAUTHORIZED,  "토큰이 존재하지 않습니다."),
    EXFIRED_TOKEN(HttpStatus.UNAUTHORIZED, "토큰이 만료되었습니다."),
    MEMBER_ALREADY_EXIST(HttpStatus.INTERNAL_SERVER_ERROR, "이미 회원가입된 이메일입니다.");

    private final HttpStatus status;
    private String message;

    ExceptionEnum(HttpStatus status){
        this.status = status;
    }

    ExceptionEnum(HttpStatus status, String message){
        this.status = status;
        this.message = message;
    }
}
