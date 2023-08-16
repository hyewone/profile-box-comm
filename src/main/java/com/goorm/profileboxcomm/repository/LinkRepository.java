package com.goorm.profileboxcomm.repository;

import com.goorm.profileboxcomm.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LinkRepository extends JpaRepository<Link, Long> {

    void deleteByLinkId(@Param("linkId") Long linkId);
    Optional<Link> findLinkByLinkId(@Param("linkId") Long linkId);

}
