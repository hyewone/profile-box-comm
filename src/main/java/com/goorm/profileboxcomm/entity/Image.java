package com.goorm.profileboxcomm.entity;

import com.goorm.profileboxcomm.dto.image.request.CreateImageRequestDto;
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
@Table(name = "image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;

    @Column(name = "file_name")
    @NotNull
    @NotBlank
    private String fileName;

    @Column(name = "file_path")
    @NotNull
    @NotBlank
    private String filePath;

    @Column(name = "file_real_name")
    @NotNull
    @NotBlank
    private String fileRealName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_dt")
    private LocalDateTime createDt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        createDt = now;
    }

    // method
    public static Image createImage(CreateImageRequestDto imageDto, Profile profile) {
        return Image.builder()
                .fileName(imageDto.getFileName())
                .fileRealName(imageDto.getFileRealName())
                .filePath(imageDto.getFilePath())
                .profile(profile)
                .build();
    }
}

