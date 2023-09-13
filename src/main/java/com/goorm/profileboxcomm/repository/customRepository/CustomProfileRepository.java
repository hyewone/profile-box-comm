package com.goorm.profileboxcomm.repository.customRepository;

import com.goorm.profileboxcomm.dto.profile.request.SelectProfileListRequestDto;
import com.goorm.profileboxcomm.entity.Profile;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomProfileRepository {
    Page<Profile> findProfiles(@Param("pageable") Pageable pageable, @Param("dto") SelectProfileListRequestDto dto);
}