package com.goorm.profileboxcomm.dto.member.response;

import com.goorm.profileboxcomm.entity.Member;
import com.goorm.profileboxcomm.enumeration.GenderType;
import com.goorm.profileboxcomm.enumeration.MemberType;
import lombok.Data;

@Data
public class SelectMemberResponseDto {
    private Long memberId;
    private MemberType memberType;
    private String memberEmail;
    private String memberName;
    private GenderType gender;
    private String telNo;
    private String birthDt;

    public SelectMemberResponseDto(Member member) {
        this.memberId = member.getMemberId();
        this.memberType = member.getMemberType();
        this.memberEmail = member.getMemberEmail();
        this.memberName = member.getMemberName();
        this.gender = member.getMemberGender();
        this.telNo = member.getMemberTelNo();
        this.birthDt = member.getMemberBirthDt().toString();
    }

}