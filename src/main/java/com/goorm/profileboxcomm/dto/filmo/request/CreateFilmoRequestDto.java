package com.goorm.profileboxcomm.dto.filmo.request;

import com.goorm.profileboxcomm.enumeration.FilmoType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateFilmoRequestDto {

    @Enumerated(EnumType.STRING)
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
