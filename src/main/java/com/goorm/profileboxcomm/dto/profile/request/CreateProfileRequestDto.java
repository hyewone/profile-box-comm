package com.goorm.profileboxcomm.dto.profile.request;

import com.goorm.profileboxcomm.dto.filmo.request.CreateFilmoRequestDto;
import com.goorm.profileboxcomm.dto.image.request.CreateImageRequestDto;
import com.goorm.profileboxcomm.dto.link.request.CreateLinkRequestDto;
import com.goorm.profileboxcomm.dto.video.request.CreateVideoRequestDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateProfileRequestDto {

    @NotNull(message = "프로필 타이틀을 입력해주세요.")
    @NotBlank(message = "프로필 타이틀을 입력해주세요.")
    private String title;

    @NotNull(message = "프로필 자기소개를 입력해주세요.")
    @NotBlank(message = "프로필 자기소개를 입력해주세요.")
    private String content;

    private int defaultImageIdx;

    @NotNull(message = "프로필 작성 멤버ID를 확인해주세요.")
    private Long memberId;

    private List<CreateImageRequestDto> images;
    private List<CreateVideoRequestDto> videos;
    private List<CreateFilmoRequestDto> filmos;
    private List<CreateLinkRequestDto> links;

}
