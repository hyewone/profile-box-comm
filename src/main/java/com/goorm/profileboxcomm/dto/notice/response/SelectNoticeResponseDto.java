package com.goorm.profileboxcomm.dto.notice.response;

import com.goorm.profileboxcomm.dto.member.response.SelectMemberResponseDto;
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

    @Schema(description = "회원 정보")
    private SelectMemberResponseDto memberInfo;

    @Schema(description = "좋아요 개수")
    private Long likeCount;

    public static SelectNoticeResponseDto getDtoForDetail(Notice notice){
        SelectNoticeResponseDto dto = new SelectNoticeResponseDto();
        dto.setNoticeId(notice.getNoticeId());
        dto.setNoticeTitle(notice.getNoticeTitle());
        dto.setNoticeContent(notice.getNoticeContent());
        dto.setFilmoType(notice.getFilmoType().toString());
        dto.setFilmoName(notice.getFilmoName());
        dto.setFilmoRole(notice.getFilmoRole());
        dto.setApplyDeadlineDt(Utils.dateToString(notice.getApplyDeadlineDt()));
        dto.setFilmingStartPeriod(Utils.dateToString(notice.getFilmingStartPeriod()));
        dto.setFilmingEndPeriod(Utils.dateToString(notice.getFilmingEndPeriod()));
        dto.setMemberInfo(new SelectMemberResponseDto(notice.getMember()));
        return dto;
    }

    public static SelectNoticeResponseDto getDtoForList(Notice notice){
        SelectNoticeResponseDto dto = new SelectNoticeResponseDto();
        dto.setNoticeId(notice.getNoticeId());
        dto.setNoticeTitle(notice.getNoticeTitle());
        dto.setNoticeContent(notice.getNoticeContent());
        dto.setFilmoType(notice.getFilmoType().toString());
        dto.setFilmoName(notice.getFilmoName());
        dto.setFilmoRole(notice.getFilmoRole());
        dto.setApplyDeadlineDt(Utils.dateToString(notice.getApplyDeadlineDt()));
        dto.setFilmingStartPeriod(Utils.dateToString(notice.getFilmingStartPeriod()));
        dto.setFilmingEndPeriod(Utils.dateToString(notice.getFilmingEndPeriod()));
        dto.setLikeCount(notice.getLikeCount());
        return dto;
    }
}
