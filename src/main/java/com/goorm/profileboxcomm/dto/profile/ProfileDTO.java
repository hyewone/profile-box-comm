package com.goorm.profileboxcomm.dto.profile;

import com.goorm.profileboxcomm.entity.Profile;
import com.goorm.profileboxcomm.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDTO {
    private Long profileId;
    private String content;
    private String title;
    private Long default_image_id;
    private String create_date;
    private String modify_date;
    private Long member_id;

    public static Profile toEntity(ProfileDTO dto){
        return Profile.builder()
                .profileId(dto.getProfileId())
                .content(dto.getContent())
                .title(dto.getTitle())
                .defaultImageId(dto.getDefault_image_id())
                .createDt(Utils.stringToLocalDateTime(dto.getCreate_date()))
                .modifyDt(Utils.stringToLocalDateTime(dto.getModify_date()))
//                .member(dto.getMember_id())
                .build();
    }
}
