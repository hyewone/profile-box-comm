package com.goorm.profileboxcomm.dto.profile.response;

import com.goorm.profileboxcomm.dto.filmo.response.SelectFilmoResponseDto;
import com.goorm.profileboxcomm.dto.image.response.SelectImageResponseDto;
import com.goorm.profileboxcomm.dto.link.response.SelectLinkResponseDto;
import com.goorm.profileboxcomm.dto.member.response.SelectMemberResponseDto;
import com.goorm.profileboxcomm.dto.video.response.SelectVideoResponseDto;
import com.goorm.profileboxcomm.entity.Profile;
import lombok.Data;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Data
    public class SelectProfileResponseDto {
        private Long profileId;
        private String title;
        private String content;
        private Long defaultImageId;
        private String createDt;
        private SelectMemberResponseDto memberInfo;
        private List<SelectImageResponseDto> images;
        private List<SelectVideoResponseDto> videos;
        private List<SelectFilmoResponseDto> filmos;
        private List<SelectLinkResponseDto> links;

        public SelectProfileResponseDto(Profile profile) {
            this.profileId = profile.getProfileId();
            this.content = profile.getContent();
            this.title = profile.getTitle();
            this.defaultImageId = profile.getDefaultImageId() == null ? profile.getImageEntities().get(0).getImageId() : profile.getDefaultImageId();
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