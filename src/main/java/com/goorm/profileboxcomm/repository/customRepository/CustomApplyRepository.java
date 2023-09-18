package com.goorm.profileboxcomm.repository.customRepository;

import com.goorm.profileboxcomm.entity.Apply;
import com.goorm.profileboxcomm.entity.Member;
import com.goorm.profileboxcomm.entity.Profile;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CustomApplyRepository {

    Page<Apply> findAllApplyByAppliedMember(@Param("pageable") Pageable pageable, @Param("member") Member member);

    Optional<Profile> findByAvailableProfileByMember(@Param("member") Member member);

    Optional<Apply> findApplyByAppliedMemberAndApplyId(@Param("member") Member member, @Param("applyId") Long applyId);

}