package com.goorm.profileboxcomm.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.goorm.profileboxcomm.dto.profile.request.CreateProfileRequestDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
//@QueryEntity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "profile")
public class Profile {

    @Id
    @Column(name="profile_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;

    @Column(name = "content")
    @NotNull
    @NotBlank
    private String content;

    @Column(name = "title")
    @NotNull
    @NotBlank
    private String title;

    @Column(name = "default_image_id")
    private Long defaultImageId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_dt")
    private LocalDateTime createDt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modify_dt")
    private LocalDateTime modifyDt;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @JsonManagedReference
    private Member member;

//    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "imageId")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profile", orphanRemoval = true)
    private List<Image> imageEntities;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profile", orphanRemoval = true)
    private List<Video> videoEntities;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profile", orphanRemoval = true)
    private List<Filmo> filmoEntities;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profile", orphanRemoval = true)
    private List<Link> linkEntities;

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
    public static Profile createProfile(CreateProfileRequestDto profileDto, Member member) {
        return Profile.builder()
                .title(profileDto.getTitle())
                .content(profileDto.getContent())
                .member(member)
                .build();
    }

    public static List<String> getProfileFieldNames() {
        List<String> fieldNames = new ArrayList<>();
        Class<?> profileClass = Profile.class;

        Field[] fields = profileClass.getDeclaredFields();
        for (Field field : fields) {
            fieldNames.add(field.getName());
        }

        return fieldNames;
    }
}

