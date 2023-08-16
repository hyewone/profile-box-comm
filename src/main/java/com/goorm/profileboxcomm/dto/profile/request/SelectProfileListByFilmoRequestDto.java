package com.goorm.profileboxcomm.dto.profile.request;

import lombok.Data;

@Data
public class SelectProfileListByFilmoRequestDto {
    private int offset;
    private int limit;
    private String sortKey;
    private String filmoType;
    private String filmoName;
//    private String gender;
//    private int age;

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
