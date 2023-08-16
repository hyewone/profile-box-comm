package com.goorm.profileboxcomm.repository;

import com.goorm.profileboxcomm.entity.Profile;
import com.goorm.profileboxcomm.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {

    void deleteByVideoId(@Param("videoId") Long videoId);

    Optional<Video> findVideoByVideoId(@Param("videoId") Long videoId);

    Optional<List<Video>> findVideosByProfile(@Param("profile") Profile profile);
}
