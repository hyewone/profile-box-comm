package com.goorm.profileboxcomm.repository.customRepositoryImple;

import com.goorm.profileboxcomm.entity.Like;
import com.goorm.profileboxcomm.entity.QLike;
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

@Repository
@RequiredArgsConstructor
public class CustomLikeRepositoryImple implements CustomLikeRepository {

    private final JPAQueryFactory queryFactory;
    private final QLike qLike = QLike.like;

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

}
