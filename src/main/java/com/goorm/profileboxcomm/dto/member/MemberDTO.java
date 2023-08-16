package com.goorm.profileboxcomm.dto.member;

import com.goorm.profileboxcomm.entity.Member;
import com.goorm.profileboxcomm.enumeration.GenderType;
import com.goorm.profileboxcomm.enumeration.MemberType;
import com.goorm.profileboxcomm.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private String token;
    private Long memberId;
    private String memberType;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
    private String memberGender;
    private String memberTelNo;
    private String memberBirthDt; //1995-12-09
    private Long profileId;

    public static Member toEntity(final MemberDTO dto) {
        return Member.builder()
                .memberId(dto.getMemberId())
                .memberType(MemberType.valueOf(dto.getMemberType()))
                .memberEmail(dto.getMemberEmail())
                .memberPassword(dto.getMemberPassword())
                .memberName(dto.getMemberName())
                .memberGender(GenderType.valueOf(dto.getMemberGender()))
                .memberTelNo(dto.getMemberTelNo())
                .memberBirthDt(Utils.stringToDate(dto.getMemberBirthDt()))
                .build();
    }
}
