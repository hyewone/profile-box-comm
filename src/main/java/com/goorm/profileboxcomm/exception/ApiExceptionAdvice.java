package com.goorm.profileboxcomm.exception;

import com.goorm.profileboxcomm.response.ApiResult;
import com.goorm.profileboxcomm.response.ApiResultType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;

@RestControllerAdvice
public class ApiExceptionAdvice {
    @ExceptionHandler({ApiException.class})
    public ResponseEntity<ApiResult> exceptionHandler(final ApiException e) {
        ApiExceptionEntity apiExceptionEntity = ApiExceptionEntity.builder()
                .errorMessage(e.getError().getMessage())
                .build();
        e.printStackTrace();
        return ResponseEntity
                .status(e.getError().getStatus())
                .body(ApiResult.builder()
                        .status(ApiResultType.ERROR.toString())
                        .statusCode(e.getError().getStatus().value())
                        .message(apiExceptionEntity.getErrorMessage())
//                        .exception(apiExceptionEntity)
                        .build());
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ApiResult> exceptionHandler(final RuntimeException e) {
        ApiExceptionEntity apiExceptionEntity = ApiExceptionEntity.builder()
                .errorMessage(e.getMessage())
                .build();
        e.printStackTrace();
        return ResponseEntity
                .status(ExceptionEnum.RUNTIME_EXCEPTION.getStatus())
                .body(ApiResult.builder()
                        .status(ApiResultType.ERROR.toString())
                        .statusCode(ExceptionEnum.RUNTIME_EXCEPTION.getStatus().value())
                        .message(apiExceptionEntity.getErrorMessage())
//                        .exception(apiExceptionEntity)
                        .build());
    }

    @ExceptionHandler({AccessDeniedException.class})
    public ResponseEntity<ApiResult> exceptionHandler(final AccessDeniedException e) {
        ApiExceptionEntity apiExceptionEntity = ApiExceptionEntity.builder()
                .errorMessage(e.getMessage())
                .build();
        e.printStackTrace();
        return ResponseEntity
                .status(ExceptionEnum.ACCESS_DENIED_EXCEPTION.getStatus())
                .body(ApiResult.builder()
                        .status(ApiResultType.ERROR.toString())
                        .statusCode(ExceptionEnum.ACCESS_DENIED_EXCEPTION.getStatus().value())
                        .message(apiExceptionEntity.getErrorMessage())
//                        .exception(apiExceptionEntity)
                        .build());
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ApiResult> exceptionHandler(final Exception e) {
        ApiExceptionEntity apiExceptionEntity = ApiExceptionEntity.builder()
                .errorMessage(e.getMessage())
                .build();
        e.printStackTrace();
        return ResponseEntity
                .status(ExceptionEnum.INTERNAL_SERVER_ERROR.getStatus())
                .body(ApiResult.builder()
                        .status(ApiResultType.ERROR.toString())
                        .statusCode(ExceptionEnum.INTERNAL_SERVER_ERROR.getStatus().value())
                        .message(apiExceptionEntity.getErrorMessage())
//                        .exception(apiExceptionEntity)
                        .build());
    }
}