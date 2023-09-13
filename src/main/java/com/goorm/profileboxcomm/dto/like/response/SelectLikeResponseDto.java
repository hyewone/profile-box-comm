package com.goorm.profileboxcomm.dto.like.response;

import com.goorm.profileboxcomm.entity.Like;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SelectLikeResponseDto {

    @Schema(description = "좋아요 ID")
    private Long likeId;

    @Schema(description = "좋아요 타입")
    private String likeType;

    @Schema(description = "좋아요 대상 ID")
    @NotNull
    private Long targetId;

    @Schema(description = "멤버 ID")
    @NotNull
    private Long memberId;

    private String createDt;

    public SelectLikeResponseDto(Like like) {
        this.likeId = like.getLikeId();
        this.likeType = like.getLikeType().toString();
        this.targetId = like.getTargetId();
        this.memberId = like.getMember().getMemberId();
        this.createDt = like.getCreateDt().toString();
    }
}
