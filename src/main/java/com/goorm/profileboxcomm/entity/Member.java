package com.goorm.profileboxcomm.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.goorm.profileboxcomm.enumeration.MemberType;
import com.goorm.profileboxcomm.enumeration.ProviderType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
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

    @Enumerated(EnumType.STRING)
    @Column(name = "provider_type")
    @NotNull
    private ProviderType providerType; // GOOGLE, KAKAO, NAVER

    @Column(name = "member_email")
    @NotNull
    @NotBlank
    private String memberEmail;

//    @Column(name = "member_name")
//    @NotNull
//    @NotBlank
//    private String memberName;
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "member_gender")
//    @NotNull
//    private GenderType memberGender; // MALE, FEMALE
//
//    @Column(name = "member_tel_no")
//    @NotNull
//    @NotBlank
//    private String memberTelNo;
//
//    @Temporal(TemporalType.DATE)
//    @Column(name = "member_birth_dt")
//    @NotNull
//    private Date memberBirthDt;

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

//    public List<String> getRoleList(){
//        if(this.memberType.toString().length() > 0) return Arrays.asList(this.memberType.toString().split(","));
//        return new ArrayList<>();
//    }
//
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Collection<GrantedAuthority> authorities = new ArrayList<>();
//        getRoleList().forEach((r) -> {
//            authorities.add(()->{return r;});
//        });
//        return authorities;
//    }

    public static Member createMember(MemberType memberType, ProviderType providerType, String memberEmail) {
        return Member.builder()
                .memberType(memberType)
                .providerType(providerType)
                .memberEmail(memberEmail)
                .build();
    }
}
