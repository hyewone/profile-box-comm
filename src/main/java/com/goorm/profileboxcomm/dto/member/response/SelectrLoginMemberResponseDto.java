package com.goorm.profileboxcomm.dto.member.response;

import lombok.Data;

@Data
public class SelectrLoginMemberResponseDto {

    private String jwtToken;
    private SelectMemberResponseDto memberInfo;

    public SelectrLoginMemberResponseDto(SelectMemberResponseDto memberDto, String jwtToken) {
        this.memberInfo = memberDto;
        this.jwtToken = jwtToken;
    }
}
