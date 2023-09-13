package com.goorm.profileboxcomm.dto.like.response;

import lombok.Data;

import java.util.List;
@Data
public class SelectLikeListResponseDto {
    private int allPageCount;
    private Long allCount;
    private List<SelectLikeResponseDto> likeList;

    public SelectLikeListResponseDto(int allPageCount, Long allCount, List<SelectLikeResponseDto> likeList) {
        this.allPageCount = allPageCount;
        this.allCount = allCount;
        this.likeList = likeList;
    }
}

