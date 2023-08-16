package com.goorm.profileboxcomm.entity;

import com.goorm.profileboxcomm.dto.link.request.CreateLinkRequestDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "link")
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long linkId;

    @Column(name = "link")
    @NotNull
    @NotBlank
    private String link;

    @Column(name = "link_name")
    @NotNull
    @NotBlank
    private String linkName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_dt")
    private LocalDateTime createDt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    // Getters and Setters
    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        createDt = now;
    }

    // method
    public static Link createLink(CreateLinkRequestDto linkDto, Profile profile) {
        return Link.builder()
                .link(linkDto.getLink())
                .linkName(linkDto.getLinkName())
                .profile(profile)
                .build();
    }
}