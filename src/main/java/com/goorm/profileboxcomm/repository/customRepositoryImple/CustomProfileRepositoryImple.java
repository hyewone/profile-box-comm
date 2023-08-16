package com.goorm.profileboxcomm.repository.customRepositoryImple;

import com.goorm.profileboxcomm.entity.QProfile;
import com.goorm.profileboxcomm.repository.customRepository.CustomProfileRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class CustomProfileRepositoryImple implements CustomProfileRepository {
    private final QProfile profile = QProfile.profile;
    private final JPAQueryFactory queryFactory;

    public CustomProfileRepositoryImple(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

//    @Override
//    public Page<Profile> findProfilesByFilmoTypeAndFilmoName(String filmoType, String filmoName) {
//        BooleanBuilder builder = new BooleanBuilder();

//        if (filmoType != null && !filmoType.isEmpty()) {
//            builder.and(profile.filmoEntities.any().filmoType.eq(filmoType));
//        }
//
//        if (filmoName != null && !filmoName.isEmpty()) {
//            builder.and(profile.filmoEntities.any().filmoName.containsIgnoreCase(filmoName));
//        }
//
//        return queryFactory
//                .selectFrom(profile)
//                .where(builder)
//                .fetch();
//    }
}
