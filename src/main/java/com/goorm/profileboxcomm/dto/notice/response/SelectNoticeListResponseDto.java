package com.goorm.profileboxcomm.dto.notice.response;

import lombok.Data;

import java.util.List;

@Data
public class SelectNoticeListResponseDto {

    private int allPageCount;
    private Long allCount;
    List<SelectNoticeResponseDto> noticeList;

    public SelectNoticeListResponseDto(int allPageCount, Long allCount, List<SelectNoticeResponseDto> noticeList) {
        this.allPageCount = allPageCount;
        this.allCount = allCount;
        this.noticeList = noticeList;
    }
}
