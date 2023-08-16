package com.goorm.profileboxcomm.dto.profile.request;

import lombok.Data;
import org.springframework.data.domain.Sort;

@Data
public class SelectProfileListRequestDto {
//    @NotNull(message = "이름은 Null 일 수 없습니다!")
//    @Size(min = 1, max = 10, message = "이름은 1 ~ 10자 이여야 합니다!")
//    private String name;
//
//    @NotNull(message = "이름은 Null 일 수 없습니다!")
//    @Min(1)
//    @Max(10)
//    @Email
    private int offset;
    private int limit;
    private String sortKey;
    private String sortDirection;
//    private String gender;
//    private int age;

    public SelectProfileListRequestDto() {
        this.offset = 1;
        this.limit = 10;
        this.sortKey = "ProfileId";
        this.sortDirection = Sort.Direction.DESC.toString();
//        this.gender = "";
//        this.age = 0;
    }
}
