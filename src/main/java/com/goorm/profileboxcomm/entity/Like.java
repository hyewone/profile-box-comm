package com.goorm.profileboxcomm.entity;

import com.goorm.profileboxcomm.dto.like.request.CreateLikeRequestDto;
import com.goorm.profileboxcomm.enumeration.LikeType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "likes")
public class Like {

    @Id
    @Column(name="like_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeId;

    @Enumerated(EnumType.STRING)
    @Column(name = "like_type")
    @NotNull
    private LikeType likeType;

    @Column(name = "target_id")
    private Long targetId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_dt")
    private LocalDateTime createDt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        createDt = now;
    }

    public static Like createLike(CreateLikeRequestDto likeDto, Member member) {
        return Like.builder()
                .likeType(likeDto.getLikeType())
                .targetId(likeDto.getTargetId())
                .member(member)
                .build();
    }

    public static List<String> getLikeFieldNames() {
        List<String> fieldNames = new ArrayList<>();
        Class<?> likeClass = Like.class;

        Field[] fields = likeClass.getDeclaredFields();
        for (Field field : fields) {
            fieldNames.add(field.getName());
        }

        return fieldNames;
    }
}