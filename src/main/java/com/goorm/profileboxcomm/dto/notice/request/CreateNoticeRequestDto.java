package com.goorm.profileboxcomm.dto.notice.request;

import com.goorm.profileboxcomm.enumeration.FilmoType;
import com.goorm.profileboxcomm.exception.ExceptionEnum;
import com.goorm.profileboxcomm.validator.EnumPattern;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateNoticeRequestDto {

    @NotNull(message = "제목을 입력해주세요.")
    @NotBlank(message = "제목을 입력해주세요.")
    String noticeTitle;

    @NotNull(message = "내용을 입력해주세요.")
    @NotBlank(message = "내용을 입력해주세요.")
    String noticeContent;

    @EnumPattern(regexp = "DRAMA|MOVIE", message = "작품 유형을 확인해주세요.", enumType= ExceptionEnum.INVALID_FILMOTYPE)
    FilmoType filmoType;

    @NotNull(message = "작품 이름을 입력해주세요.")
    @NotBlank(message = "작품 이름을 입력해주세요.")
    String filmoName;

    @NotNull(message = "역할을 입력해주세요.")
    @NotBlank(message = "역할을 입력해주세요.")
    String filmoRole;

    @NotNull(message = "지원 마감일자를 입력해주세요.")
    @NotBlank(message = "지원 마감일자를 입력해주세요.")
    String applyDeadlineDt;

    String filmingStartPeriod;
    String filmingEndPeriod;

}
