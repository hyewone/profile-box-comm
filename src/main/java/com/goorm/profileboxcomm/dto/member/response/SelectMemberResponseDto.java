package com.goorm.profileboxcomm.dto.member.response;

import com.goorm.profileboxcomm.entity.Member;

import lombok.Data;

@Data
public class SelectMemberResponseDto {
    private Long memberId;
    private String memberType;
    private String providerType;
    private String memberEmail;

    public SelectMemberResponseDto(Member member) {
        this.memberId = member.getMemberId();
        this.memberType = member.getMemberType().toString();
        this.providerType = member.getProviderType().toString();
        this.memberEmail = member.getMemberEmail();
    }
}