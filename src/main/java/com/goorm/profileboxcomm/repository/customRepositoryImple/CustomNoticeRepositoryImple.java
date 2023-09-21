package com.goorm.profileboxcomm.repository.customRepositoryImple;

import com.goorm.profileboxcomm.dto.notice.request.SelectNoticeListRequsetDto;
import com.goorm.profileboxcomm.entity.Notice;
import com.goorm.profileboxcomm.entity.QLike;
import com.goorm.profileboxcomm.entity.QNotice;
import com.goorm.profileboxcomm.repository.customRepository.CustomNoticeRepository;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.lettuce.core.dynamic.annotation.Param;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CustomNoticeRepositoryImple implements CustomNoticeRepository {
    private final JPAQueryFactory queryFactory;
    private final QNotice qNotice = QNotice.notice;
    private final QLike qLike = QLike.like;

    @Override
    public Page<Notice> findNotices(@Param("pageable") Pageable pageable, @Param("dto") SelectNoticeListRequsetDto dto) {
        List<Tuple> tupleNotices = queryFactory
                .select(
                        qNotice,
                        ExpressionUtils.as(
                                    JPAExpressions
                                            .select(qLike.count())
                                            .from(qLike)
                                            .where(qLike.targetId.eq(qNotice.noticeId)),
                                    "likeCount"
                            ))
                .from(qNotice)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        List<Notice> notices = tupleNotices.stream()
                .map(tuple -> {
                    Notice notice = tuple.get(0, Notice.class);
                    Long likeCount = tuple.get(1, Long.class);
                    notice.setLikeCount(likeCount);
                    return notice;
                })
                .collect(Collectors.toList());

        return new PageImpl<>(notices, pageable, notices.size());
    }
}
