package com.goorm.profileboxcomm.repository;

import com.goorm.profileboxcomm.entity.Member;
import com.goorm.profileboxcomm.entity.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    @Override
    Page<Profile> findAll(@Param("pageable") Pageable pageable);
    Optional<Profile> findProfileByProfileId(@Param("profileId") Long profileId);

    Optional<Profile> findProfileByMember(@Param("member") Member member);

    Optional<Profile> findProfileByDefaultImageId(@Param("defaultImageId") Long defaultImageId);

    Optional<Profile> findProfileByProfileIdAndMember(@Param("profileId") Long profileId, @Param("member") Member member);

    boolean existsProfileByMember(@Param("member") Member member);

    void deleteByProfileId(@Param("profileId") Long profileId);
}
