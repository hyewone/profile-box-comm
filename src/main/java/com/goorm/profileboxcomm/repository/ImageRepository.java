package com.goorm.profileboxcomm.repository;

import com.goorm.profileboxcomm.entity.Image;
import com.goorm.profileboxcomm.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

    void deleteByImageId(@Param("imageId") Long imageId);

    Optional<Image> findImageByImageId(@Param("imageId") Long imageId);

    Optional<List<Image>> findImagesByProfile(@Param("profile") Profile profile);
}
