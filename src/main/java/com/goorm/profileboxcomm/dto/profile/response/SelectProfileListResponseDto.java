package com.goorm.profileboxcomm.dto.profile.response;

import lombok.Data;

import java.util.List;

@Data
public class SelectProfileListResponseDto {
    private int allPageCount;
    private Long allCount;
    private List<SelectProfileResponseDto> profileList;

    public SelectProfileListResponseDto(int allPageCount, Long allCount, List<SelectProfileResponseDto> profileList) {
        this.allPageCount = allPageCount;
        this.allCount = allCount;
        this.profileList = profileList;
    }
}
