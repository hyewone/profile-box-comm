package com.goorm.profileboxcomm.repository;

import com.goorm.profileboxcomm.entity.Member;
import com.goorm.profileboxcomm.entity.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {
    Page<Notice> findAll(@Param("pageable") Pageable pageable);
    Optional<Notice> findNoticeByNoticeId(Long noticeId);
    Optional<Notice> findNoticeByNoticeIdAndMember(Long noticeId, Member member);
//    Optional<Notice> findNoticeByNoticeProfile(Member member);

    void deleteByNoticeId(Long noticeId);
}
