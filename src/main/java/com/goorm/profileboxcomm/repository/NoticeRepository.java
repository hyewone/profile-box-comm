package com.goorm.profileboxcomm.repository;

import com.goorm.profileboxcomm.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {
    Optional<Notice> findByNoticeId(Long noticeId);
    void deleteByNoticeId(Long noticeId);
}
