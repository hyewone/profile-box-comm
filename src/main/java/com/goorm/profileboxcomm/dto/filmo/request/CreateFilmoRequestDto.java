package com.goorm.profileboxcomm.dto.filmo.request;

import com.goorm.profileboxcomm.enumeration.FilmoType;
import com.goorm.profileboxcomm.exception.ExceptionEnum;
import com.goorm.profileboxcomm.validator.EnumPattern;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateFilmoRequestDto {

    @EnumPattern(regexp = "DRAMA|MOVIE", message = "필모그래피 유형을 확인해주세요.", enumType= ExceptionEnum.INVALID_FILMOTYPE)
    @NotNull(message = "필모그래피 타입을 입력해주세요.")
    private FilmoType filmoType;

    @NotNull(message = "필모그래피 이름을 입력해주세요.")
    @NotBlank(message = "필모그래피 이름을 입력해주세요.")
    private String filmoName;

    @NotNull(message = "필모그래피 연도를 입력해주세요.")
    @NotBlank(message = "필모그래피 연도를 입력해주세요.")
    private String filmoYear;

    @NotNull(message = "필모그래피 감독을 입력해주세요.")
    @NotBlank(message = "필모그래피 감독을 입력해주세요.")
    private String filmoDirector;

}
