package com.goorm.profileboxcomm.repository.customRepositoryImple;

import com.goorm.profileboxcomm.dto.profile.request.SelectProfileListRequestDto;
import com.goorm.profileboxcomm.entity.*;
import com.goorm.profileboxcomm.enumeration.FilmoType;
import com.goorm.profileboxcomm.enumeration.YnType;
import com.goorm.profileboxcomm.repository.customRepository.CustomProfileRepository;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.dsl.BooleanExpression;
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
public class CustomProfileRepositoryImple implements CustomProfileRepository {
    private final JPAQueryFactory queryFactory;
    private final QProfile qProfile = QProfile.profile;
    private final QImage qImage = QImage.image;
    private final QVideo qVideo = QVideo.video;
    private final QFilmo qFilmo = QFilmo.filmo;
    private final QLink qLink = QLink.link;
    private final QLike qLike = QLike.like;

    @Override
    public Page<Profile> findProfiles(@Param("pageable") Pageable pageable, @Param("dto") SelectProfileListRequestDto dto) {

        List<Tuple> tupleProfiles = queryFactory
                .select(
                        qProfile,
                        ExpressionUtils.as(
                                JPAExpressions
                                        .select(qLike.count())
                                        .from(qLike)
                                        .where(qLike.targetId.eq(qProfile.profileId)),
                                "likeCount"
                        )
                )
                .from(qProfile)
                .where(qProfile.ynType.eq(YnType.Y),
                        titleCon(dto.getTitle()),
                        actorNameCon(dto.getActorName()),
                        filmoJoin(dto.getFilmoType(), dto.getFilmoName()),
                        filmoTypeEq(dto.getFilmoType()),
                        filmoNameCon(dto.getFilmoName())
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        List<Profile> profiles = tupleProfiles.stream()
                .map(tuple -> {
                    Profile profile = tuple.get(0, Profile.class);
                    Long likeCount = tuple.get(1, Long.class);
                    profile.setLikeCount(likeCount);
                    return profile;
                })
                .collect(Collectors.toList());

        return new PageImpl<>(profiles, pageable, profiles.size());
    }

    private BooleanExpression titleCon(String title) {
        return hasText(title) ? qProfile.title.contains(title) : null;
    }

    private BooleanExpression actorNameCon(String actorName) {
        return hasText(actorName) ? qProfile.actorName.contains(actorName) : null;
    }

    private BooleanExpression filmoTypeEq(String filmoType) {
        return hasText(filmoType) ? qFilmo.filmoType.eq(FilmoType.valueOf(filmoType)) : null;
    }

    private BooleanExpression filmoNameCon(String filmoName) {
        return hasText(filmoName) ? qFilmo.filmoName.contains(filmoName) : null;
    }
    private BooleanExpression filmoJoin(String filmoType, String filmoName) {
        return hasText(filmoType) || hasText(filmoName) ? qProfile.filmoEntities.any().eq(qFilmo) : null;
    }

    private boolean hasText(String text){
        return !text.isEmpty();
    }
}
