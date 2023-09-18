package com.goorm.profileboxcomm.repository;

import com.goorm.profileboxcomm.entity.Apply;
import com.goorm.profileboxcomm.entity.Notice;
import com.goorm.profileboxcomm.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplyRepository extends JpaRepository<Apply, Long> {

    boolean existsApplyByProfileAndNotice(@Param("profile") Profile profile, @Param("notice") Notice notice);
}
