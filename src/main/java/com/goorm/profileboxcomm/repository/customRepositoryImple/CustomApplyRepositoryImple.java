package com.goorm.profileboxcomm.repository.customRepositoryImple;

import com.goorm.profileboxcomm.entity.*;
import com.goorm.profileboxcomm.enumeration.YnType;
import com.goorm.profileboxcomm.repository.customRepository.CustomApplyRepository;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CustomApplyRepositoryImple implements CustomApplyRepository {

    private final JPAQueryFactory queryFactory;

//    private final QMember qMember = QMember.member;
    private final QProfile qProfile = QProfile.profile;
    private final QApply qApply = QApply.apply;
    private final QNotice qNotice = QNotice.notice;

    @Override
    public Page<Apply> findAllApplyByAppliedMember(@Param("pageable") Pageable pageable, @Param("member") Member member){
        JPAQuery<Apply> query = queryFactory
                .selectFrom(qApply)
                .join(qApply).on(qNotice.eq(qApply.notice))
                .fetchJoin()
                .where(qApply.profile.member.eq(member))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize());
        return new PageImpl<>(query.fetch(), pageable, query.fetchCount());
    }

    @Override
    public Optional<Profile> findByAvailableProfileByMember(@Param("member") Member member){
        Profile query = queryFactory
                .selectFrom(qProfile)
                .where(qProfile.member.eq(member))
                .where(qProfile.ynType.eq(YnType.Y))
                .fetchOne();
        return Optional.ofNullable(query);
    }

    @Override
    public Optional<Apply> findApplyByAppliedMemberAndApplyId(Member member, Long applyId) {
        Apply query = queryFactory
                .selectFrom(qApply)
                .where(qApply.profile.member.eq(member))
                .where(qApply.applyId.eq(applyId))
                .fetchOne();
        return Optional.ofNullable(query);
    }
}
