package com.goorm.profileboxcomm.dto.member.request;

import com.goorm.profileboxcomm.entity.Member;
import com.goorm.profileboxcomm.enumeration.GenderType;
import com.goorm.profileboxcomm.enumeration.MemberType;
import com.goorm.profileboxcomm.utils.Utils;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CreateMemberRequestDTO {

    @NotNull
    @NotBlank
    @Email(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "이메일 형식이 아닙니다.")
    private String memberEmail;

    @NotNull
    @NotBlank
    private String memberPassword;

    @NotNull
    @NotBlank
    private String memberName;

    @NotNull
    @NotBlank
    private String memberGender;

    @NotNull
    @NotBlank
    private String memberType;

    @NotNull
    @NotBlank
    @Pattern(regexp="^01[0-9]{1}-[0-9]{4}-[0-9]{4}$", message = "010-1234-5678 형식으로 입력해 주세요")
    private String memberTelNo;

    @NotNull
    @NotBlank
    @Pattern(regexp="(19[0-9][0-9]|20\\d{2})-(0[0-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$", message = "1919-12-31 형식으로 입력해 주세요")
    private String memberBirthDt;

    public static Member toEntity(CreateMemberRequestDTO dto){
        return Member.builder()
                .memberEmail(dto.getMemberEmail())
                .memberPassword(dto.getMemberPassword())
                .memberName(dto.getMemberName())
                .memberGender(GenderType.valueOf(dto.getMemberGender()))
                .memberType(MemberType.valueOf(dto.getMemberType()))
                .memberTelNo(dto.getMemberTelNo().toString())
                .memberBirthDt(Utils.stringToDate(dto.getMemberBirthDt()))
                .build();
    }
}
