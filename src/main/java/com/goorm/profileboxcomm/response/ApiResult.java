package com.goorm.profileboxcomm.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.goorm.profileboxcomm.exception.ApiExceptionEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
@ToString
public class ApiResult<T>{
    private String status;
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

//    @JsonInclude(JsonInclude.Include.NON_NULL)
//    private ApiExceptionEntity exception;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int statusCode;

    @Builder
    public ApiResult(String status, String message, T data, ApiExceptionEntity exception, int statusCode) {
        this.status = status;
        this.message = message;
        this.data = data;
//        this.exception = exception;
        this.statusCode = statusCode;
    }

    public static ApiResult getResult(ApiResultType resultType, String func, Object data){
        String message = func;
        message = resultType.equals(ApiResultType.SUCCESS)
                ? func + " 성공했습니다."
                : func + " 실패했습니다.";

        return ApiResult.builder()
                .status(resultType.toString())
                .message(message)
                .data(data)
                .statusCode(HttpStatus.OK.value())
                .build();
    }

    public static ApiResult getResult(ApiResultType resultType, String func, Object data, HttpStatus status){
        String message = func;
        message = resultType.equals(ApiResultType.SUCCESS)
                        ? func + " 성공했습니다."
                        : func + " 실패했습니다.";

        return ApiResult.builder()
                .status(resultType.toString())
                .message(message)
                .data(data)
                .statusCode(status.value())
                .build();
    }
}