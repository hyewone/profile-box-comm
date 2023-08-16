package com.goorm.profileboxcomm.repository;

import com.goorm.profileboxcomm.entity.Member;
import com.goorm.profileboxcomm.entity.Profile;
import com.goorm.profileboxcomm.repository.customRepository.CustomProfileRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long>, CustomProfileRepository {
    @Override
    Page<Profile> findAll(@Param("pageable") Pageable pageable);

    Optional<Profile> findProfileByProfileId(@Param("profileId") Long profileId);

    boolean existsProfileByMember(@Param("member") Member member);

    void deleteByProfileId(@Param("profileId") Long profileId);
}
