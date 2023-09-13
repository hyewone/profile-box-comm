package com.goorm.profileboxcomm.dto.profile.response;

import com.goorm.profileboxcomm.dto.filmo.response.SelectFilmoResponseDto;
import com.goorm.profileboxcomm.dto.image.response.SelectImageResponseDto;
import com.goorm.profileboxcomm.dto.link.response.SelectLinkResponseDto;
import com.goorm.profileboxcomm.dto.member.response.SelectMemberResponseDto;
import com.goorm.profileboxcomm.dto.video.response.SelectVideoResponseDto;
import com.goorm.profileboxcomm.entity.Profile;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Data
    public class SelectProfileResponseDto {

        @Schema(description = "프로필 ID")
        private Long profileId;

        @Schema(description = "배우 이름")
        private String actorName;

        @Schema(description = "제목")
        private String title;

        @Schema(description = "내용")
        private String content;

        @Schema(description = "기본 이미지 ID")
        private Long defaultImageId;

        @Schema(description = "프로필 공개 유형")
        private String ynType;

        @Schema(description = "생성일자")
        private String createDt;

        @Schema(description = "회원 정보")
        private SelectMemberResponseDto memberInfo;

        @Schema(description = "이미지 목록")
        private List<SelectImageResponseDto> images;

        @Schema(description = "비디오 목록")
        private List<SelectVideoResponseDto> videos;

        @Schema(description = "필모 목록")
        private List<SelectFilmoResponseDto> filmos;

        @Schema(description = "링크 목록")
        private List<SelectLinkResponseDto> links;

        public SelectProfileResponseDto(Profile profile) {
            this.profileId = profile.getProfileId();
            this.content = profile.getContent();
            this.actorName = profile.getActorName();
            this.title = profile.getTitle();
            this.defaultImageId = profile.getDefaultImageId();
            this.ynType = profile.getYnType().toString();
            this.createDt = profile.getCreateDt().toString();
            this.memberInfo = new SelectMemberResponseDto(profile.getMember());
            this.images = profile.getImageEntities().stream()
                    .map(o -> new SelectImageResponseDto(o))
                    .collect(toList());
            this.videos = profile.getVideoEntities().stream()
                    .map(o -> new SelectVideoResponseDto(o))
                    .collect(toList());
            this.filmos = profile.getFilmoEntities().stream()
                    .map(o -> new SelectFilmoResponseDto(o))
                    .collect(toList());
            this.links = profile.getLinkEntities().stream()
                    .map(o -> new SelectLinkResponseDto(o))
                    .collect(toList());
        }
    }