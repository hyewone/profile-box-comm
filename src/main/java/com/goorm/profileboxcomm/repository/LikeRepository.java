package com.goorm.profileboxcomm.repository;

import com.goorm.profileboxcomm.entity.Like;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    @Override
    Page<Like> findAll(@Param("pageable") Pageable pageable);

    Optional<Like> findLikeByLikeId(@Param("likeId") Long likeId);

    void deleteByLikeId(@Param("likeId") Long likeId);

//
//    Optional<Profile> findProfileByProfileId(@Param("profileId") Long profileId);
//
//    Optional<Profile> findProfileByDefaultImageId(@Param("defaultImageId") Long defaultImageId);
//
//    Optional<Profile> findProfileByProfileIdAndMember(@Param("profileId") Long profileId, @Param("member") Member member);
//
//    boolean existsProfileByMember(@Param("member") Member member);
//
//    void deleteByProfileId(@Param("profileId") Long profileId);
}
