package com.goorm.profileboxcomm.dto.notice.response;

import com.goorm.profileboxcomm.entity.Notice;
import com.goorm.profileboxcomm.utils.Utils;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SelectNoticeResponseDto {

    @Schema(description = "작품공고 ID")
    private Long noticeId;

    @Schema(description = "작품공고 제목")
    private String noticeTitle;

    @Schema(description = "작품공고 내용")
    private String noticeContent;

    @Schema(description = "작품공고 유형")
    private String filmoType;

    @Schema(description = "작품 이름")
    private String filmoName;

    @Schema(description = "배역")
    private String filmoRole;

    @Schema(description = "지원 마감일자")
    private String applyDeadlineDt;

    @Schema(description = "촬영 시작일자")
    private String filmingStartPeriod;

    @Schema(description = "촬영 종료일자")
    private String filmingEndPeriod;

    public SelectNoticeResponseDto(Notice notice) {
        this.noticeId = notice.getNoticeId();
        this.noticeTitle = notice.getNoticeTitle();
        this.noticeContent = notice.getNoticeContent();
        this.filmoType = notice.getFilmoType().toString();
        this.filmoName = notice.getFilmoName();
        this.filmoRole = notice.getFilmoRole();
        this.applyDeadlineDt = Utils.dateToString(notice.getApplyDeadlineDt());
        this.filmingStartPeriod = Utils.dateToString(notice.getFilmingStartPeriod());
        this.filmingEndPeriod = Utils.dateToString(notice.getFilmingEndPeriod());
    }
}
