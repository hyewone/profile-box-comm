package com.goorm.profileboxcomm.dto.member.response;

import com.goorm.profileboxcomm.entity.Member;
import lombok.Data;

@Data
public class SelectLoginMemberResponseDto {

    private String jwtToken;
    private SelectMemberResponseDto memberInfo;

    public SelectLoginMemberResponseDto(Member member, String jwtToken) {
        this.memberInfo = new SelectMemberResponseDto(member);
        this.jwtToken = jwtToken;
    }
}
