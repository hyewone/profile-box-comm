package com.goorm.profileboxcomm.repository.customRepositoryImple;

import com.goorm.profileboxcomm.entity.*;
import com.goorm.profileboxcomm.enumeration.LikeType;
import com.goorm.profileboxcomm.repository.customRepository.CustomLikeRepository;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomLikeRepositoryImple implements CustomLikeRepository {

    private final JPAQueryFactory queryFactory;
    private final QLike qLike = QLike.like;
    private final QProfile qProfile = QProfile.profile;
    private final QNotice qNotice = QNotice.notice;

    @Override
    public Page<Like> findAllLikeByCondition(@Param("pageable") Pageable pageable, @Param("likeType") String likeType) {
        JPAQuery<Like> query = queryFactory.selectFrom(qLike)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize());

        if (!likeType.isEmpty()) {
            query.where(qLike.likeType.eq(LikeType.valueOf(likeType)));
        }
        return new PageImpl<>(query.fetch(), pageable, query.fetchCount());
    }

    public List<Profile> findProfilesByMemberIdAndLikeType(Long memberId) {
        return queryFactory
            .selectFrom(qProfile)
                .join(qLike)
                .on(qLike.targetId.eq(qProfile.profileId))
                .where(qLike.member.memberId.eq(memberId))
                .where(qLike.likeType.eq(LikeType.PROFILE))
                .fetch();
    }

    public List<Notice> findNoticesByMemberIdAndLikeType(Long memberId) {
        return queryFactory
                .selectFrom(qNotice)
                .join(qLike)
                .on(qLike.targetId.eq(qNotice.noticeId))
                .where(qLike.member.memberId.eq(memberId))
                .where(qLike.likeType.eq(LikeType.NOTICE))
                .fetch();
    }

}
