package com.goorm.profileboxcomm.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.goorm.profileboxcomm.dto.member.MemberDTO;
import com.goorm.profileboxcomm.enumeration.GenderType;
import com.goorm.profileboxcomm.enumeration.MemberType;
import com.goorm.profileboxcomm.utils.Utils;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "member", uniqueConstraints = {@UniqueConstraint(columnNames = "member_email")})
public class Member{

    @Id
    @Column(name="member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Enumerated(EnumType.STRING)
    @Column(name = "member_type")
    @NotNull
    private MemberType memberType; // ACTOR, PRODUCER, ADMIN

    @Column(name = "member_email")
    @NotNull
    @NotBlank
    private String memberEmail;

    @Column(name = "member_password")
    @NotNull
    @NotBlank
    private String memberPassword;

    @Column(name = "member_name")
    @NotNull
    @NotBlank
    private String memberName;

    @Enumerated(EnumType.STRING)
    @Column(name = "member_gender")
    @NotNull
    private GenderType memberGender; // MALE, FEMALE

    @Column(name = "member_tel_no")
    @NotNull
    @NotBlank
    private String memberTelNo;

    @Temporal(TemporalType.DATE)
    @Column(name = "member_birth_dt")
    @NotNull
    private Date memberBirthDt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_dt")
    private LocalDateTime createDt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modify_dt")
    private LocalDateTime modifyDt;

    // v1
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "member_id")
    @JsonBackReference
    private Profile profile;

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        createDt = now;
        modifyDt = now;
    }

    @PreUpdate
    protected void onModify() {
        modifyDt = LocalDateTime.now();
    }

    // method
    public static MemberDTO toDTO(Member entity){
        return MemberDTO.builder()
                .memberId(entity.getMemberId())
                .memberType(entity.getMemberType().toString())
                .memberEmail(entity.getMemberEmail())
                .memberPassword(entity.getMemberPassword())
                .memberName(entity.getMemberName())
                .memberGender(entity.getMemberGender().toString())
                .memberTelNo(entity.getMemberTelNo())
                .memberBirthDt(Utils.dateToString(entity.getMemberBirthDt()))
//                .profileId(entity.getProfile().getProfileId())
                .build();
    }

    public List<String> getRoleList(){
        if(this.memberType.toString().length() > 0) return Arrays.asList(this.memberType.toString().split(","));
        return new ArrayList<>();
    }
}
