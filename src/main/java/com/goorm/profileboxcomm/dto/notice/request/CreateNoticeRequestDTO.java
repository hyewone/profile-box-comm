package com.goorm.profileboxcomm.dto.notice.request;

import com.goorm.profileboxcomm.entity.Notice;
import com.goorm.profileboxcomm.enumeration.FilmoType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateNoticeRequestDTO {
    @NotNull(message = "공지 제목을 입력해주세요.")
    @NotBlank(message = "공지 제목을 입력해주세요.")
    String title;
    String content;
    String filmo_type;
    String filmo_name;
    String filmo_role;
    String apply_deadline_dt;
    String filming_start_period;
    String filming_end_period;

    public static Notice toEntity(CreateNoticeRequestDTO dto) throws ParseException{
        return Notice.builder()
                .noticeTitle(dto.getTitle())
                .noticeContent(dto.getContent())
                .filmoType(FilmoType.valueOf(dto.getFilmo_type()))
                .filmoName(dto.getFilmo_name())
                .filmoRole(dto.getFilmo_role())
                .applyDeadlineDt(new SimpleDateFormat("yyyy-MM-dd").parse(dto.getApply_deadline_dt()))
                .filmingStartPeriod(new SimpleDateFormat("yyyy-MM-dd").parse(dto.getFilming_start_period()))
                .filmingEndPeriod(new SimpleDateFormat("yyyy-MM-dd").parse(dto.getFilming_end_period()))
                .build();
    }
}
