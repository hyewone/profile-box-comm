package com.goorm.profileboxcomm.dto.member.response;

import com.goorm.profileboxcomm.dto.profile.response.SelectProfileResponseDto;
import com.goorm.profileboxcomm.entity.Member;

import lombok.Data;

@Data
public class SelectMemberResponseDto {
    private Long memberId;
    private String memberType;
    private String providerType;
    private String memberEmail;

    private SelectProfileResponseDto profileInfo;

    public SelectMemberResponseDto(Member member) {
        this.memberId = member.getMemberId();
        this.memberType = member.getMemberType().toString();
        this.providerType = member.getProviderType().toString();
        this.memberEmail = member.getMemberEmail();
        if (member.getProfile() != null){
            this.profileInfo = SelectProfileResponseDto.getDtoForUserInfo(member.getProfile());
        }
    }
}