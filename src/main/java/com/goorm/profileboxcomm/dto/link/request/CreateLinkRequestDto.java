package com.goorm.profileboxcomm.dto.link.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateLinkRequestDto {

    @NotNull(message = "링크를 입력해주세요.")
    @NotBlank(message = "링크를 입력해주세요.")
    private String link;

    @NotNull(message = "링크명을 입력해주세요.")
    @NotBlank(message = "링크명을 입력해주세요.")
    private String linkName;

}
