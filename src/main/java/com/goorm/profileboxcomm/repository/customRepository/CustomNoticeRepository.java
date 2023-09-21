package com.goorm.profileboxcomm.repository.customRepository;

import com.goorm.profileboxcomm.dto.notice.request.SelectNoticeListRequsetDto;
import com.goorm.profileboxcomm.entity.Notice;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomNoticeRepository {
    Page<Notice> findNotices(@Param("pageable") Pageable pageable, @Param("dto") SelectNoticeListRequsetDto dto);
}