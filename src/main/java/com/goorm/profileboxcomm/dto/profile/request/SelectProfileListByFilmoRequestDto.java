package com.goorm.profileboxcomm.dto.profile.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SelectProfileListByFilmoRequestDto {
    private int offset;
    private int limit;
    private String filmoType;
    private String filmoName;
    @Schema(description = "정렬 필드")
    private String sortKey;
    @Schema(description = "정렬 방향")
    private String sortDirection;

    public SelectProfileListByFilmoRequestDto() {
        this.offset = 1;
        this.limit = 10;
        this.sortKey = "ProfileId";
        this.filmoType = "";
        this.filmoName = "";
//        this.gender = "";
//        this.age = 0;
    }
}
