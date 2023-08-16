package com.goorm.profileboxcomm.entity;

import com.goorm.profileboxcomm.dto.filmo.request.CreateFilmoRequestDto;
import com.goorm.profileboxcomm.enumeration.FilmoType;
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
@Table(name = "filmo")
public class Filmo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long filmoId;

    @Enumerated(EnumType.STRING)
    @NotNull
    private FilmoType filmoType;

    @Column(name = "filmo_name")
    @NotNull
    @NotBlank
    private String filmoName;

    @Column(name = "filmo_year")
    @NotNull
    @NotBlank
    private String filmoYear;

    @Column(name = "filmo_director")
    @NotNull
    @NotBlank
    private String filmoDirector;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_dt")
    private LocalDateTime createDt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modify_dt")
    private LocalDateTime modifyDt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    // Getters and Setters
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
    public static Filmo createFilmo(CreateFilmoRequestDto filmoDto, Profile profile) {
        return Filmo.builder()
                .filmoType(filmoDto.getFilmoType())
                .filmoName(filmoDto.getFilmoName())
                .filmoYear(filmoDto.getFilmoYear())
                .filmoDirector(filmoDto.getFilmoDirector())
                .profile(profile)
                .build();
    }

    // Getters and Setters

    // Constructor
}
