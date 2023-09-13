package com.goorm.profileboxcomm.repository.customRepository;

import com.goorm.profileboxcomm.entity.Like;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface CustomLikeRepository {
    Page<Like> findAllLikeByCondition(@Param("pageable") Pageable pageable, @Param("likeType") String likeType);
}